import express from "express";
import bodyParser from "body-parser";
import pg from "pg";

const app = express();
const port = 3000;

//DataBase
const db = new pg.Client({
  user: "postgres",
  host: "localhost",
  database: "World",
  password: "2836856773Ale?",
  port: 5432,
});



//we define a variables
let totalCorrect = 0;


db.connect();
let quiz = [];
db.query("SELECT * FROM flags", (err, res) => {
  if(err){
    console.error("Error al ejecutar encuesta", err.stack);
  } else {
    quiz = res.rows;
  }
  db.end();
});



// Middleware
app.use(bodyParser.urlencoded({ extended: true }));//accede a la estructura del frontend
app.use(express.static("public"));//conecta las carpetas de los estilos e imagenes con el front-end

let currentQuestion = {};

// GET home page
app.get("/", async (req, res) => {//apenas inicia la pagina
  totalCorrect = 0;//el total de preguntas correctas inicia en cero
  await nextQuestion();//llama a la funcion nueva pregunta
  console.log(currentQuestion);//mueztra la pregunta por consola
  res.render("index.ejs", { question: currentQuestion });//renderiza el front-end con la pregunta actual
});//osea en el front end se deveria de mostrar un pais y nos deveria preguntar la capital 

// POST a new post
app.post("/submit", (req, res) => {//submit se llama cuando el usuario envia la respuesta 
  let answer = req.body.answer.trim();//variable answer recupera del cuerpo la respuesta sin espacios
  let isCorrect = false;//definimos una variable booleana es correcta = falso
  if (currentQuestion.name.toLowerCase() === answer.toLowerCase()) {
    //comparamos la respuesta guardada con la respuesta del usuario eliminando mayusculas
    totalCorrect++;//si es correcta al total se le suma 1
    console.log(totalCorrect);//mostramos por consola el total 
    isCorrect = true;//pasamos la variable booleana a true
  }

  nextQuestion();//llamamos a la funcion next cuestion que vuelve a guardar una pocicion del arreglo de preguntas en una variable
  res.render("index.ejs", {//renderizamos el indice con:  
    question: currentQuestion,//la pregunta actual
    wasCorrect: isCorrect,//la variable que nos decia si erra correcta
    totalScore: totalCorrect,//el total de preguntas correctas
  });
});

async function nextQuestion() {
  const randomCountry = quiz[Math.floor(Math.random() * quiz.length)];//guarda en una constante un elemento aleatorio de arreglo quiz
  currentQuestion = randomCountry;// guarda ese elemento en la variablo de pregunta actual 
}

app.listen(port, () => {//solo inicia el servidor
  console.log(`Server is running at http://localhost:${port}`);
});


