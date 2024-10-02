//esta animacion le da un efecto de tecla apertada a un boton 
function animationKey(keyPressed){//le paso la tecla como parametro

    //creo una variablre con la ubicacion de lo que le voy a aplicar esa animacion 
    var activeButtom = document.querySelector("."+keyPressed);

    // cuando se llame la funcion al boton le voy a agregar un estilo nuevo
    activeButtom.classList.add("pressed");
    
    //luego le voy a quitar ese estilo despues de 100 milisegundos
    setTimeout(function remov() {
        activeButtom.classList.remove("pressed");
    },100);
}

/*setTimeOut
es una funcion que le vamos a pasar como parametros:
    *) una funcion que se va a ejecutar despues de un tiempo
    *)el tiempo que tiene que pasar antes de que se eecute la funcion 



*/