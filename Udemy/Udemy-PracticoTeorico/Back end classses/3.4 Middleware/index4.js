/*
 *  se tiene que pasar dos nombres en los formuclarios html y cuando apretamos el boton submit nos va a llevar a otra pestaña que junta los dos nombres y los muestra en pantalla  
 */
import express from "express";
import bodyParser from "body-parser";
import { dirname } from "path";
import { fileURLToPath } from "url";

//esta constante va a contener la direcicon url del archivo donde estamos parados 
const __dirname = dirname(fileURLToPath(import.meta.url));//el 100 por ciento de las veces se hace de esta manera


const app = express();
const port = 3000;

//esta linea de codigo era obligatoria para poder usar body 
app.use(bodyParser.urlencoded({extended: true}));

// cuando hacemos get en / nos envia el archivo en la ubicacion de index.html
app.get("/",(req, res)=>{
  res.sendFile(__dirname+"/public/index.html");
});

//una vez que le da al boton submit y llama a post 
app.post("/submit",(req, res)=>{
  var calle =  req.body.street;
  var animal = req.body.pet;
  console.log("{ street: "+calle+" pet: "+animal+"}");
  res.send("<h1>Your band name is:</h1><p>"+calle+animal+" juju</p>");
});


app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});

/**
 * tambien podriamos haber creado una funcion que nos de ese nombre todo junto que necesitamos 
 
  function bandNameGenerator(req, res, next) {
  console.log(req.body);
  bandName = req.body["street"] + req.body["pet"];
  next();
}

app.use(bandNameGenerator);

 */
