import express from "express";

const app = express();
const port = 3000;

//esto es un midlware personalizado lo podemos usar para extraer datos mas especificos 
const logger = (req, res, next)=>{
  console.log("URL: "+req.method+"\nmetodo: "+req.url);
  next();
};

app.use(logger);

app.get("/", (req, res) => {
  res.send("Hello");
});

app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});
/*
  crear una midlware custom que rescate la url y el metodo de la peticion 

  req.method : nos va a servir para saber que se esta hacien ej get, post, delete, paych etc
  req.url : nos va a servir para saber en que url estamos posicionados 

  TODAS ESTAS COSAS SE SUPONE QUE VAN A SER IMPORTANTES A LA HORA DE CREAR PAGINAS ASIQUE DEBERIA REPASAR 
  ESTOS APUNTES CADA VEZ QUE TENGA UNA DUDA DE COMO HACER ALGO 
  O DEVERIA HACER UNOS APUNTES GENERALES QUE AGARREN TODOS LOS COMENTARIOS DE MIS ALGORRITMOS Y HAGAN ALGUN 
  APUNTE MAS GENERAL DE TODO LO QUE SE 
*/