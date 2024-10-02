// COMO AGREGAR UN EVENTO AL HACER CLICK 
// script.js

// Selecciona el botón y el párrafo de resultado
const boton = document.getElementById('miBoton');
const resultado = document.getElementById('resultado');

// Define la función que se ejecutará cuando se haga clic en el botón
function mostrarMensaje() {
    resultado.textContent = '¡Has hecho clic en el botón!';
}

// Agrega un evento de clic al botón que llama a la función mostrarMensaje
boton.addEventListener('click', mostrarMensaje);

//es importante no hacer la llamada a la funcion con los parentesis por 
//que sino se ejecutaria cada vez que se entre a la pagina o actualiza  
//---------------------------------------------------------------------------------------------------------------
// si tenemos muchos botones con un bucle podemos hacer muchos eventos para listas 
function mostrarMensaje() {
    alert("has echo clic");
}
for (var i = 0; i<document.querySelectorAll(".drum").length; i++){
    document.querySelectorAll(".drum")[i].addEventListener("click", mostrarMensaje);
}

// tambien podriamos detectar cuando se hace clic en cualquier otro cosa 
// por ejemplo un h1 

document.querySelector("h1").addEventListener("click", mostrarMensaje);

//COMO FUNCIONA 
document.addEventListener("keydown", function (event){
    reproducirSonido(event.key);
});
/*
estas son funciones de orden superior como las de haskell 
es una funcion a la que le pasamos otra funcion como paramtro 
addEventListener("tipo de evento", funcion a ejecutar cuando se detecta el evento)

            IMPORTANT

addEventListener("",function(event));
si le pasamos una funcion sin nombre y solo con un parentesis lo que hace 
es detectar cual fue el evento que ocurrio por ejemplo que tecla se preciono 
si quisiera usar el evento dentro de la funcion lo podria usar con ese nombre.

luego cada evento tiene sus propiedades coomo que tecla el codigo de la tecla o durante cuanto 
tiempo fue precionada la tecla. para encontrar todas esa informacion la busco en internet 

*/