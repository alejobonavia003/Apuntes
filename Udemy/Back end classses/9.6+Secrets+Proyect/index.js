import express from "express";
import bodyParser from "body-parser";
import pg from "pg";
import bcrypt from "bcrypt";
import passport from "passport";
import { Strategy } from "passport-local";
import GoogleStrategy from "passport-google-oauth2";
import session from "express-session";
import env from "dotenv";
// importa librerias necesarias 


const app = express();//configuramos el servidor
const port = 3000;//configuraomos el puerto
const saltRounds = 10;// constante para las rondas de sal
env.config();// agregamos las variables de entorno

app.use(// configuramos las cokies
  session({
    secret: process.env.SESSION_SECRET,// le damos una firma 
    resave: false,// propiedad para que se pierda la cokie cuando se modifique algo 
    saveUninitialized: true,// y que se guarde aunque no aya caargado los datos
  })
);
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));

app.use(passport.initialize());// iniciamos las funciones passaport 
app.use(passport.session());// si o si se inicializan antes de usar, es como el body-parser

const db = new pg.Client({
  user: process.env.PG_USER,
  host: process.env.PG_HOST,
  database: process.env.PG_DATABASE,
  password: process.env.PG_PASSWORD,
  port: process.env.PG_PORT,
});
db.connect();
// elegimos valores para configurar la base de datos y la iniciamos 

app.get("/", (req, res) => {
  res.render("home.ejs");
});// cuando llega una peticin get con / lo mandamos a home.ejs

app.get("/login", (req, res) => {
  res.render("login.ejs");
});// si llega una peticion get con /login lo mandamos a login.ejs

app.get("/register", (req, res) => {
  res.render("register.ejs");
});// lo mismo para register 

app.get("/logout", (req, res) => {// si llega una peticion get de logout
  req.logout(function (err) {//llamamos a la logout en minuscula, que desautentica el usuario
    if (err) {
      return next(err);
    }// si hay un error lo informamos y sino vamos a "/"
    res.redirect("/");
  });
});

app.get("/secrets", async (req, res) => {// esta es la pagina principal despues de iniciar secion 
  if (req.isAuthenticated()) {// si el usuario esta autenticado, lo dejamos pasar 
    const consult = await db.query("SELECT secret FROM public.users;");
 
    res.render("secrets.ejs", {secret : consult.rows});

    // ---------------------------------------------------------------------------------------------
    //TODO: Update this to pull in the user secret to render in secrets.ejs
    // ---------------------------------------------------------------------------------------------

  } else {// si no esta autenticado lo mandamos a loguearse 
    res.redirect("/login");
  }
});

// ---------------------------------------------------------------------------------------------
//TODO: Add a get route for the submit button
//Think about how the logic should work with authentication.
// ---------------------------------------------------------------------------------------------
app.get("/submit", (req, res) => {
  res.render("submit.ejs");
});

app.post("/submit", async (req, res) => {
  const newSecret = req.body.secret;
  if (req.isAuthenticated()) {// si el usuario esta autenticado, lo dejamos pasar 
    const mail = req.user.email;
    try{
    const consult = await db.query("UPDATE users SET secret = $1 WHERE email = $2;",
      [newSecret, mail]
    );
    res.redirect("/secrets");
  }catch (err) {
    console.log(err);
  }
  } else {// si no esta autenticado lo mandamos a loguearse 
    res.redirect("/login");
  }

}); 

app.get(//midleware para reucuperar los datos proporcionados por google 
  "/auth/google",
  passport.authenticate("google", {
    scope: ["profile", "email"],//solo queremos recuperar el perfil y el email
  })
);

app.get(
  "/auth/google/secrets",
  passport.authenticate("google", {
    successRedirect: "/secrets",
    failureRedirect: "/login",
  })
);

app.post(
  "/login",
  passport.authenticate("local", {
    successRedirect: "/secrets",// si se autentico bien lo mandamos a secrets 
    failureRedirect: "/login",// si se autentico mal lo mandamos a login
  })
);
// cuando mandamos un registro post de /register 
app.post("/register", async (req, res) => {
  const email = req.body.username;//recuperamos email
  const password = req.body.password;// recuperamos password

  try {
    const checkResult = await db.query("SELECT * FROM users WHERE email = $1", [
      email,//consultamo si el email existe en la base de datos 
    ]);

    if (checkResult.rows.length > 0) {
      req.redirect("/login");//si ya existe lo mandamos a iniciar secion 
    } else {//si no existe encriptamos la contraceña 
      bcrypt.hash(password, saltRounds, async (err, hash) => {
        if (err) {
          console.error("Error hashing password:", err);
        } else {//si no ocurre ningun error al encriptar la contraceña 
          const result = await db.query(
            "INSERT INTO users (email, password) VALUES ($1, $2) RETURNING *",
            [email, hash]
          );//guardamos en la base de datos el email y la contraceña encriptaa del usuario 
          const user = result.rows[0];//si ya esta registrado guardamos el usuario dentro de una constante
          req.login(user, (err) => {//llamamos a la funcion login para iniciar secion con su cokie
            console.log("success");
            res.redirect("/secrets");//lo mandamos al feed
          });
        }
      });
    }
  } catch (err) {
    console.log(err);
  }
});

// ---------------------------------------------------------------------------------------------
//TODO: Create the post route for submit.
//Handle the submitted data and add it to the database
// ---------------------------------------------------------------------------------------------


//Configuramos la estrategia de inicio de secion local 
passport.use(
  "local",
  new Strategy(async function verify(username, password, cb) {
    try {
      const result = await db.query("SELECT * FROM users WHERE email = $1 ", [
        username,
      ]);
      if (result.rows.length > 0) {
        const user = result.rows[0];
        const storedHashedPassword = user.password;
        bcrypt.compare(password, storedHashedPassword, (err, valid) => {
          if (err) {
            console.error("Error comparing passwords:", err);
            return cb(err);
          } else {
            if (valid) {
              return cb(null, user);
            } else {
              return cb(null, false);
            }
          }
        });
      } else {
        return cb("User not found");
      }
    } catch (err) {
      console.log(err);
    }
  })
);

// configuramos la estrategia de inicio de seccion por google 
passport.use(
  "google",
  new GoogleStrategy(
    {
      clientID: process.env.GOOGLE_CLIENT_ID,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET,
      callbackURL: "http://localhost:3000/auth/google/secrets",
      userProfileURL: "https://www.googleapis.com/oauth2/v3/userinfo",
    },
    async (accessToken, refreshToken, profile, cb) => {
      try {
        console.log(profile);
        const result = await db.query("SELECT * FROM users WHERE email = $1", [
          profile.email,
        ]);
        if (result.rows.length === 0) {
          const newUser = await db.query(
            "INSERT INTO users (email, password) VALUES ($1, $2)",
            [profile.email, "google"]
          );
          return cb(null, newUser.rows[0]);
        } else {
          return cb(null, result.rows[0]);
        }
      } catch (err) {
        return cb(err);
      }
    }
  )
);

// guardamos cokies en el navegador 
passport.serializeUser((user, cb) => {
  cb(null, user);
});
//pedimos colkies al navegador 
passport.deserializeUser((user, cb) => {
  cb(null, user);
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
