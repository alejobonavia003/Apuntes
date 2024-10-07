
//EN ESTA LECCION APRENDIMOS QUE PODEMOS USAR UNA FUNCION PARA RENDERIZAR UN ARCHIVO.EJS QUE ESTE ECHO DE HTML Y TENGA JAVASCRIPT INSRUSTADO 
// este archivo.EJS es un mundo nuevo que tiene toda la data en los ejercicios 

import bodyParser from "body-parser";
import express from "express";
import { dirname } from "path";
import { fileURLToPath } from "url";

//guardo la direccion de mi proyecto en una constante para que no se pueda modificar
const __dirname = dirname(fileURLToPath(import.meta.url));

//conecto node con exprees para poder trabajar la app desde aca y defino el puerto
const app = express();
const port = 3000;

//agrego un body para detectar los elementos del archivo html
app.use(bodyParser.urlencoded({extended: true}));

//que pasa cuando se entra en la pagina / 
app.get("/",(req, res)=>{
    const fecha = new Date();
    const dia = fecha.getDay();// obtengo el dia de hoy
    var text = "";


    if(dia == 0 || dia == 6) { // los dias 0 y 6 son sabado y domingo 
        text = "hoy es dia de maquelele..";
    } else {
        text = "a labura manito pero igual tambien es dia de makelele";
    }//Basicamente me dice si es dia de semana o fin de semana
    //renderiso un archivo ejs 
    res.render('index.ejs', {
        text: text
    });
});


//defino el el escuchador de la pagina en mi port
app.listen(port,()=>{
    console.log("se establecio la coneccion en el port: "+port);
});
