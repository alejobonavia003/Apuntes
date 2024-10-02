const fs = require('fs'); //guardo la libreria de manejo de archivos en la constante fs


 

/*      fs.writeFile("archivo a crear", "contenido del archivo", que sucede si hay un error); 
fs.writeFile("messagee.txt", "mensaje de ejemplo", (err) => {
    if (err) throw err; // si err true muestro el error especifico(throw error)
    console.log("el archivo se cargo"); // si no entra al if no hubo errores
});*/

/* fs.unlink("ruta", error); elimina el archivo que se encuentre en la ruta seleccionada 
fs.unlink("./messagee.txt", (err) => {
    if (err) throw err;
   console.log("se elimino correctamente"); 
});*/

/*funcion que sobreescribe el archivo que esta en la ruta 
fs.writeFile("./message.txt", "que onda brooo", (err) => {
    if (err) console.log("hubo un error al escribir el archivo. ",err);
    console.log("nuevo contenido: ","que onda brooo")
});*/

// funcion para leer el archivo que se encuentre en la ruta, es importante especificar la codificacion utf8
fs.readFile("./message.txt","utf8",(err, dat) =>{
    if (err) console.log("error al leer el archivo.",err);
    console.log("informacion original",dat);
});
