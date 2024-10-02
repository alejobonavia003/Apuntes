//To see how the final website should work, run "node solution.js".
//Make sure you have installed all the dependencies with "npm i".
//The password is ILoveProgramming

//importo librerias que considero necesarias 
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
    //envio como respuesta el archivo html
    res.sendFile(__dirname+"/public/index.html");
});

app.post("/check", (req, res)=>{
    if (req.body.password == "Alejo"){
        res.sendFile(__dirname+"/public/secret.html");
    }else {
        res.sendFile(__dirname+"/public/index.html");
    }
});

//defino el el escuchador de la pagina en mi port
app.listen(port,()=>{
    console.log("se establecio la coneccion en el port: "+port);
});

