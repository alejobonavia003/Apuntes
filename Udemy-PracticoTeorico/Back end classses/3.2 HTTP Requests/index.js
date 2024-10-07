import express from "express";

const port = 3000;
const  app = express();


// GET(PETICION, FUNCION RESPUESTA(){}); GET ES UNA FUNCION PARA RECUPERAR DATOS DEL USUARIO 
//      esta funcion anonima del segundo parametro se ejecuta cuando recibe la peticion "/" 
app.get( "/",(req, res)=>{
    res.send("<h1>Hello word.</h1>"); // RES.SEN: FUNCION PARA ENVIAR UNA RESPUESTA 
});

app.get("/contact", (req, res)=>{
    res.send("<h1>pagina de contactos</h1>");
});

app.get("/about", (req, res)=>{
    res.send("<h1>pagina de informacion</h1>");
});

//LISTEN: FUNCION QUE CONECTA EL SERVIDOR AL PUERTO 3000
app.listen(port, ()=>{ 
    console.log("servido funcionando en port: "+port);
});