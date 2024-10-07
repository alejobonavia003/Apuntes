/* 
1. Use the inquirer npm package to get user input.
2. Use the qr-image npm package to turn the user entered URL into a QR code image.
3. Create a txt file to save the user input using the native fs node module.
*/
import inquirer from 'inquirer';
import qr from 'qr-image';
import * as fs from 'node:fs';

const questions = [{ // CONFIGURACION DE LAS PREGUNTAS Y DE LAS ENTRADAS.
    type: 'input',// que tipo de entrada se va a ingresar 
    name: 'url',//nombre de que se va a ingresar 
    message: 'introdusca una url: ',//mensaje de que tiene que ingresada
    default: 'https://alejobonavia003.github.io/Porfolio/', // si no ingresa nada entonces por default tenemos una cadena vacia 
    validate: ((val)=> val.length > 0), //valida que no ingrece un texto vacio
}]; //la constante questions es un arreglo que por cada elemento del arreglo va a hacer una entrada respetando las propiedades que le pasemos 

inquirer.prompt(questions).then((answers) => {   //aca vamos a devolver el qr


    //uso la libreria de qr-image para generar una url con el link y lo guardo en una variable
    var newQR = qr.image(answers.url, { type: 'png',parse_url:'true' });//no es necesario poner las opciones simplemente qr.image("url"); basta
    newQR.pipe(fs.createWriteStream('qr_img.png'));//creo un nuevo archivo con la imagen

    //el qr que esta en la imgaen va a ser siempre de la url que este en URL.txt
    fs.writeFile("URL.txt",(answers.url),"utf8",(err)=>{
        if (err) throw err;
        console.log("el archivo URL se sobreescribio exitosamente.");
    });


    console.log("se creo un qr llamado qr_img.pn con la url: "+answers.url);
});
