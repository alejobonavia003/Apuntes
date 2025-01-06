import express from "express";
import bodyParser from "body-parser";
import pg from "pg";
import bcrypt from "bcrypt";
import passport from "passport";
import { Strategy } from "passport-local";
import session from "express-session";
import env from "dotenv";
import GoogleStrategy from "passport-google-oauth2";

const app = express();
const port = 3000;
const saltRounds = 10;
env.config();

app.use(
  session({
    secret: process.env.SESSION_SECRET,
    resave: false,
    saveUninitialized: true,
  })
);

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));

app.use(passport.initialize());
app.use(passport.session());

const db = new pg.Client({
  user: process.env.PG_USER,
  host: process.env.PG_HOST,
  database: process.env.PG_DATABASE,
  password: process.env.PG_PASSWORD,
  port: process.env.PG_PORT,
});
db.connect();

app.get("/", (req, res) => {
  res.render("home.ejs");
});

app.get("/login", (req, res) => {
  res.render("login.ejs");
});

app.get("/register", (req, res) => {
  res.render("register.ejs");
});

app.get("/logout", (req, res) => {
  req.logout(function (err) {
    if (err) {
      return next(err);
    }
    res.redirect("/");
  });
});

app.get("/secrets", (req, res) => {
  console.log(req.user);
  if (req.isAuthenticated()) {
    res.render("secrets.ejs");
  } else {
    res.redirect("/login");
  }
});

//programamos que va a pasar cuando entre al boton de autenticacion por google
app.get("/auth/google", passport.authenticate("google", {
  //de aca sacamos los datos que necesitamos para la autenticacion 
  scope: ["profile", "email"],

}));

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
    successRedirect: "/secrets",
    failureRedirect: "/login",
  })
);

app.post("/register", async (req, res) => {
  const email = req.body.username;
  const password = req.body.password;

  try {
    const checkResult = await db.query("SELECT * FROM users WHERE email = $1", [
      email,
    ]);

    if (checkResult.rows.length > 0) {
      req.redirect("/login");
    } else {
      bcrypt.hash(password, saltRounds, async (err, hash) => {
        if (err) {
          console.error("Error hashing password:", err);
        } else {
          const result = await db.query(
            "INSERT INTO users (email, password) VALUES ($1, $2) RETURNING *",
            [email, hash]
          );
          const user = result.rows[0];
          req.login(user, (err) => {
            console.log("success");
            res.redirect("/secrets");
          });
        }
      });
    }
  } catch (err) {
    console.log(err);
  }
});

passport.use("local",
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
            //Error with password check
            console.error("Error comparing passwords:", err);
            return cb(err);
          } else {
            if (valid) {
              //Passed password check
              return cb(null, user);
            } else {
              //Did not pass password check
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
//configuramos una estrategia de autenticacion por google 
passport.use("google", new GoogleStrategy({
  
  clientID: process.env.GOOGLE_CLIENT_ID,//pasamos id de cliente
  clientSecret: process.env.GOOGLE_CLIENT_SECRET,//pasamos secreto de cliente 
  callbackURL: "http://localhost:3000/auth/google/secrets",
  userProfileURL: "https://www.googleapis.com/oauth2/v3/userinfo",
  //todos estos datos son necesarios para que funcione la autenticacion   
}, async (accessToken, refreshToken, profile, cb)=>{// estos son parametros de donde despues podemos sacar infomacion
  // en esta parte debemos programar lo que sucede una vez que inicia secion con google
  //como guardar los datos del perfil proporcionados por google en nuestra base de datos
  console.log(profile);// mostramos todos los datos que nos proporciona del perfil en la consola

  try{
   const result = await db.query("select * from users where email = $1", [profile.email]);
   //comparamos si el mail esta en la base de datos, si este no existe entonces lo registramos 
   if (result.rows.length === 0) {
      const newUser = await db.query("insert into users (email, password) values ($1, $2);", 
        [profile.email, "google"]
      );
      cb(null, newUser.rows[0]);
      //por ultimo devolvemos la llamada con null errores y con el usuario nuevo
   } else { // si el usuario existe entonces devolvemos el usuario existente
    cb(null, result.rows[0]);
   }
  } catch (err) {//si el bloque try falla entonces devolvemos el err
    cb(err);
  }

})
);

passport.serializeUser((user, cb) => {
  cb(null, user);
});
passport.deserializeUser((user, cb) => {
  cb(null, user);
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
