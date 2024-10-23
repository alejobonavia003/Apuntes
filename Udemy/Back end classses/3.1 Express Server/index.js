//IMPORTAMOS LA LIBRERIA DE EXPRESS
import express from "express";

//ESTA FUNCION CREARA EL SERVIDOR EN app
const app = express(); 

//DEFINIMOS A QUE PUERTO NOS VAMOS A CONECTAR CADA VEZ QUE SE HAGA UNA PETICION 
const port = 3000;

// app.listen es la funcion ESCUCHAR cuando escuche el port va a ejecutar la funcion anonima del segundo parametro 
app.listen(port, ()=> { 
    console.log("servidor funcinoando en el port: "+port);
});

