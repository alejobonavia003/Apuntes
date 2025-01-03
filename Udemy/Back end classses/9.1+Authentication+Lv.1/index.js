import express from "express";
import bodyParser from "body-parser";
import pg from "pg";

const app = express();
const port = 3000;

const db = new pg.Client({
  user: "postgres",
  host: "localhost",
  database: "secrets",
  password: "12345",
  port: 5432,
});
db.connect();


app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));

app.get("/", (req, res) => {
  res.render("home.ejs");
});

app.get("/login", (req, res) => {
  res.render("login.ejs");
});

app.get("/register", (req, res) => {
  res.render("register.ejs");
});

app.post("/register", async (req, res) => {
  console.log("usuario: "+req.body.username);
  console.log("password: "+req.body.password);

    const checkResult = await db.query("select * from users where email = $1",[req.body.username]);


    if(checkResult.rows.length > 0){
      res.send("el email ya esta registrado");
    } else {
try{
  await db.query("insert into users(email, password) values ($1, $2);",[req.body.username,req.body.password]);
  res.render("secrets.ejs");
}catch (err){
  console.log(err);
}

    }
  
});

app.post("/login", async (req, res) => {
  const usuario = (req.body.username);
  const constracena = (req.body.password);
try{
  const usuarios = await db.query("select * from users")
  console.log("mirame aca" + usuarios.rows.length);

  for (let i = 1; i<=usuarios.rows.length;i++){
    console.log(usuarios.rows[i].email);
    if (usuarios.rows[i].email === usuario){
      if (usuarios.rows[i].password == constracena){
        res.render("secrets.ejs");
      }else{
        res.send("contraceña incorrecta.");
      } 
    } else {
      res.send("usuario no registrado.");
    }
  }
} catch (err){
console.log(err);
}


});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
