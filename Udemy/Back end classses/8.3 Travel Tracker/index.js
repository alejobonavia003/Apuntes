import express from "express";
import bodyParser from "body-parser";
import pg from "pg";

const db = new pg.Client({
  user: "postgres",
  host: "localhost",
  database: "World",
  password: "2836856773Ale?",
  port: 5432,
});
db.connect();
const app = express();
const port = 3000;

//NUNCA MAS TE OLVIDES DE PRENDER LA BASE DE DATOS


app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public"));

let pasarTotal = 0;
let pasarCountries = [];
let newCountry;
let errores= "sin errores";

app.get("/", async (req, res) => {
  //Write your code here.
  let countries = [];
 
  const result = await db.query("SELECT country_code FROM visited_countries"); //consulta a la base de datos

  for (let i=0;i<result.rows.length;i++){
    countries.push(result.rows[i].country_code);
  }

  console.log(countries);
  if(errores === "sin errores"){
  res.render("index.ejs", {total: result.rows.length, countries: countries,});
  console.log("paises pintados: " + countries);
  } else{
    res.render("index.ejs", {total: result.rows.length, countries: countries,error: errores});
    errores = "sin errores";
  }
});

app.post("/add", async (req, res) => {
  
  const name = req.body["country"];
  

try {
  const result = await db.query(
    "SELECT country_code FROM countries WHERE country_name LIKE '%' || $1 || '%';",  //consulta a la base de datos
    [name]
  );
//SELECT country_code FROM countries WHERE country_name LIKE 'United States%'


  if (result.rows.length !== 0){// evitamos agregar resultados errados a la base de datos

   await db.query("INSERT INTO visited_countries (country_code) VALUES ($1)",[result.rows[0].country_code,]);//consulta a la base de datos

   res.redirect("/");
  } else {
    throw new Error(`No se encontró el país con el nombre: ${name}`);
  }
} catch (error){
  errores = error.message;
  console.log(errores);
  res.redirect("/"); 
}

});

app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
