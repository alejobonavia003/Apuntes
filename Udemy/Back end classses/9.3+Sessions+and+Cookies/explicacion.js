import express from "express";
import bodyParser from "body-parser";
import pg from "pg";
import bcrypt from "bcrypt";//encriptar contraceñas
import passport from "passport";// autenticacion local
import { Strategy } from "passport-local"; // autenticacion local
import session from "express-session";//manejar seciones para autenticacion persistente 
import env from "dotenv"; // leer variables de entorno

const app = express();//lanzamos el sercidor
const port = 3000; // guardamos el puerto
const saltRounds = 10;//roondas de sal con las que se va a encryptar la contraceña 
env.config(); // nose que hace

app.use(
  session({
    secret: "TOPSECRETWORD",
    resave: false,
    saveUninitialized: true,
  })//configura seciones para almacenar el esrado del usuario entre peticiones 
);
app.use(bodyParser.urlencoded({ extended: true }));//combierte detos del formulario en req.body
app.use(express.static("public"));//sirve archivos estaticos desde la carpeta public

app.use(passport.initialize());//habilitan autenticacnion con seciones 
app.use(passport.session());//habilitan autenticacnion con seciones 

const db = new pg.Client({//configuracion de la base de datos 
  user: "postgres",
  host: "localhost",
  database: "secrets",
  password: "2836856773Ale?",
  port: 5432,
});
db.connect();//conectamops la base de datos

app.get("/", (req, res) => {//renderiza la pagina principal 
  res.render("home.ejs");
});

app.get("/login", (req, res) => { //renderiza la pagina de login 
  res.render("login.ejs");
});

app.get("/register", (req, res) => {//renderiza la pagina de registro
  res.render("register.ejs");
});

app.get("/logout", (req, res) => {//cierra la secion del usuario
  req.logout(function (err) {//llama a la funcion logout para cerrar la secion 
    if (err) {//si err es true 
      return next(err);//devuele el error
    }
    res.redirect("/");//luego se va al inicio
  });
});

app.get("/secrets", (req, res) => {//renderiza secrets solo si el usuario esta autenticado
  // console.log(req.user);
  if (req.isAuthenticated()) {//si la funcion esta autenticado da true lo deja pasar a /secrets
    res.render("secrets.ejs");
  } else {
    res.redirect("/login");//de lo contratio tiene que iniciar secion
  }
});

app.post("/login",passport.authenticate("local", {successRedirect: "/secrets",failureRedirect: "/login",}));
/**
 * cuando enviamos un metodo post para login:
 * en vez de usar el midleware como se constumbre usamos passaport en la funcion authenticate.
 * a este metodo le pasamos la estrategia y que hacer cuando 
 * esta autenticado(successRediirect), en este caso lo mandamos a la pagina de /secrets 
 * no esta autenticado(dailurearedirect) que lo mandamos a la paginas de /login
 */

app.post("/register", async (req, res) => {//renderiza cuando se envia el formulario de registro
  const email = req.body.username;//tomamos el email ingresado del formulario
  const password = req.body.password;//tomamos la contraceña ingresado del formulario

  try {
    const checkResult = await db.query("SELECT * FROM users WHERE email = $1", [
      email,
    ]);//consultamos a la base de datos si el email ya esta registrado 

    if (checkResult.rows.length > 0) {//si ya hay un email registrado
      req.redirect("/login");//vuelva a iniciar secion
    } else {//sino
      bcrypt.hash(password, saltRounds, async (err, hash) => {//encriptamos la contraceña
        if (err) {//si ocurre un error
          console.error("Error hashing password:", err);//reportamos el error 
        } else {//sino
          const result = await db.query(
            "INSERT INTO users (email, password) VALUES ($1, $2) RETURNING *",
            [email, hash]
          );//insertamos el nombre y la contraceña encriptada dentro de la base de datos y devolvemos el ID
          const user = result.rows[0];//Guardamos el ID en una constante
          req.login(user, (err) => {//llamamos a la funcion login para que pueda entrar a la pagina teniendo en cuenta el ID
            console.log("success");//mostramos en consola si salio todo bien 
            res.redirect("/secrets");//redirigimos a /secrets al usuario junto con sus datos
          });
        }
      });
    }
  } catch (err) {//si de principio ocurre un error 
    console.log(err); //decimos por consola que a ocurrido
  }
});

passport.use( //registramos una nueva estrategia de autenticacion
  new Strategy(async function verify(username, password, cb) {//creamos un objeto para la estrategia 
    try {//y este objeto llama a la funcion verify con 3 parametros(cb es callback) y espera a que termine de ejecutarce para contunuar
      const result = await db.query("SELECT * FROM users WHERE email = $1 ", [
        username,
      ]);//consulta a la base de datos si este username existe dentrode la tabla de usuarios
      if (result.rows.length > 0) {//si este username existe
        const user = result.rows[0];// guarda la primera fila de la tabla en user
        const storedHashedPassword = user.password;//guardamos su contaceña dentro de una constante 
        bcrypt.compare(password, storedHashedPassword, (err, valid) => {
          //compáramos la la contraceña encriptada de la base de datos con la contraceña introducida encriptada
          if (err) {
            //Error with password check
            console.error("Error comparing passwords:", err);
            return cb(err);
          } else {
            if (valid) {
              //Passed password check
              return cb(null, user);
              /*cuando devolvemos un callback, la funcion devuelve datos que se recuperan luego en el req de los 
              * midelware el primer parametro de la funcion cb(p1, p2) devuelve un error, por eso cuando 
              * consideramos que no hay ningun error pasamos null.
              * El segundo parametro es el usuario que se pasa, esto afecta a la funcion isAutenticated que usamos
              * mas arriba, si le pasamos el usuario es que esta auntenticado y si le pasamos false es que algo fallo 
              * como introducir la contraceña mal 
              */ 
            } else {
              //Did not pass password check
              return cb(null, false);
            }
          }
        });
      } else {
        return cb("User not found");
        // aca directamente devolvemos un error por que solo se le paasa el primer parametro 
      }
    } catch (err) {
      console.log(err);
    }
  })
);

passport.serializeUser((user, cb) => {
  cb(null, user);
});//definimos la forma en la que se va a guardar los datos del usuario como cokie 
passport.deserializeUser((user, cb) => {
  cb(null, user);
});//define la forma en la que se pide la cokie al navegador 

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
