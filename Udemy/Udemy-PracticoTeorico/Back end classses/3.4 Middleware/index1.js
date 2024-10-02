/*

COMO USAR BODY-PARSER

 */
import bodyParser from "body-parser";
import express from "express";
import { dirname } from "path";
import { fileURLToPath } from "url";
const __dirname = dirname(fileURLToPath(import.meta.url));

const app = express();
const port = 3000;

//EL 100 PORCIENTO DE LAS VECES VOY A USAR ESTA LINEA DE CODIGO 
app.use(bodyParser.urlencoded({extended: true}));
/*es basicamente para agregar la opcion body dentro de mi objeto res 
    el problema es que sin esta opcion no podriamos acceder a nuestros objetos
    dentro del html 
*/

app.get("/", (req, res) => {
  res.sendFile(__dirname + "/public/index.html");
});

app.post("/submit", (req,res)=>{
  //cuando llamemos a post nos enviara a la pestaña /submit y rescatara lo que hay detro del selector con nombre street y pet
  console.log(" calle: "+req.body.street+" \n animalito: "+req.body.pet);
});

app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});

//los BODY-PARSER o analizadores de cuerpo nos van a servir para hacer autenticacion registros de login y para
// un mejor manejo de errores 