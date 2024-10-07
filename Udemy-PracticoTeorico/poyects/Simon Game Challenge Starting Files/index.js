// ------------------------------------------------------------------------
//      VARIABLES

var userClickPattern = [];
var secuence = [];
var level = 0;
// ------------------------------------------------------------------------
//      SENSORES

    const inicio = function(){
    $("body").removeClass("game-over");        

    $(document).off("keypress"); // ya no puede volver a iniciar
    $("h1").text("level "+level); // se cambia el titulo 

    secuence = randomcolour(secuence); // se agrega un color random a la secuencia

    const buttonClick = function (event) { //se ejecuta cuando detecta un click
    
    
    //animacion de boton apretado
    buttonAnimationP(event.target.id); //animacion
    repSound(event.target.id);  //soniditop
    userClickPattern.push(event.target.id); // el color que clikee se agrega al arreglo

    if(chek(secuence,userClickPattern) == "NextLevel"){ // si pasa de nivel 
            setTimeout(function(){
                secuence = randomcolour(secuence); // se agrega un color a la secuencia
                userClickPattern = []; //el usuario empieza de cero
                level++; 
                $("h1").text("level "+level); // se cambia el titulo
            },1000);
        } else if (chek(userClickPattern,secuence) == "GameOver"){ // si el boton que toco no era el correcto
            gameOver(); //pantalla de game over
            $(".btn").off("click",buttonClick); //dsactvo el sensor de clicks
            $(document).on("keypress",inicio); // activo el sensor de teclas
            $("h1").text("Press key to restart");  // aviso que tiene que apretar otra tecla para empezar devuelta
            level = 0;  
            secuence = [];
            userClickPattern = []; //empieza todo devuelta
        }

    } 
    $(".btn").on("click",buttonClick); // sensor de clicks
}
$(document).on("keypress",inicio); //sensor de apretar tecla

// ------------------------------------------------------------------------
//      FUNCIONES


//devuelve nextlevel continue o gameover 
function chek(uSec,sec) {
    var resultado = "Continue";
    
    for(var i = 0;i<uSec.length;i++){
        console.log("sec = "+sec[i]+" , uSec = "+uSec[i]);
        if(sec[i] == uSec[i]){
            if(sec.length == uSec.length){
                resultado = "NextLevel";
            }  
        }else {
            resultado = "GameOver";
        }
    }

    console.log(resultado);
    return resultado;
}
//pantalla de game over
function gameOver(){
    $("h1").text("Game Over");  
    $("body").addClass("game-over");
    var over = new Audio("sounds/wrong.mp3");
    over.play();
}
//animacion de cuando el usuario hace click
function buttonAnimationP(buttonPress){
    $("."+buttonPress).addClass("pressed");
    setTimeout(function(){
        $("."+buttonPress).removeClass("pressed");
    },100);
}
//animacion de cuando el juego hace un paso
function buttonAnimation(buttonPress){

    $("."+buttonPress).fadeOut(150);
    setTimeout(function(){
        $("."+buttonPress).fadeIn(150);
    },100);
    
}
//agrega un color random a una secuencia de colores
function randomcolour(sec) {
    var buttonColor = ["red", "blue", "green", "yellow"];
    var number = Math.floor((Math.random())*4);
    buttonAnimation(buttonColor[number]);
    repSound(buttonColor[number]);    
    sec.push(buttonColor[number]);
    return sec;
 }
//reproduce un sonido dependiendo del color que le ingrece
function repSound(soundName){
    switch(soundName){
        case "blue" : 
            var blue = new Audio("sounds/blue.mp3");
            blue.play();
        break;
        case "green" : 
            var green = new Audio("sounds/green.mp3");
            green.play();
        break;
        case "red" : 
            var red = new Audio("sounds/red.mp3");
            red.play();
        break;
        case "yellow" : 
            var yellow = new Audio("sounds/yellow.mp3");
            yellow.play();
        break;
        default : console.log("no papa no toqes");
    }
}