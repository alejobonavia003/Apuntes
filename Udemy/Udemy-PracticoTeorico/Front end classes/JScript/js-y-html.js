// para vincular js con html ponemos en html 
<script src="index.js" charset="utf-8"> </script>

// como buscar un tag atributo o algo dentro de css para trabajarlo en js 
// en js 
Document; // con esta palabra clave nos referimos al archivo html 
Document.querySelector("h1"); // esto buscara todos los h1 del archivo 
Document.querySelector("h1").innerHTML = "hola";// aca estamos refiriendonos al titulo que esta adentro de h1 y lo va a cambiar por la cadena hola
// js genera automaticamente un arbol con todo nuestro archivo HTML para que podamos movernos y seleccionar elementos del HTML 
// para ver el arbol de manera grafica podemos usar la extencion html tree generator 
// ---------------------------------------------------------------------------------------------------------------------------------------------
// podemos movernos por el documento 
Document.firstElementChild; // vamos a entrar al primer nodo que tengamos desde donde estamos parados 
Document.lastElementChild; // vamos a entrar en el ultimo nodo que apunte el que estamos parados 
// con estas dos formas podemos movernos sobre el html 
// una vez que encontramos una ubicacion la podemos guardar en una variable para volverla a usar 
heading = Document.firstElementChild.lastElementChild.firstElementChild; //esto es solo un ejemplo 
//supongamos que guardamos el h1 de la pagina 
// podriamos cambiar alguna propiedad de su estilo 
heading.style.color = "red"; 
// SELECIONAR ELEMENTO ESPECIFICO 
document.querySelector("botton");//selecciona el primer elemento que encuentra del tipo 
//SELECCIONAR TODOS LOS ELEMENTOS IGUALES
document.querySelectorAll("ul")//selecciona todos los elementos ul
//SELECCIONAR LOS ELEMENTOS CON UN NOMBRE 
document.getElementsByTagName("li"); //esto nos va a dar una arreglo con todos los elementos 
//si quisieramos cambiar el tercer elemento del arreglo lo trabajamos como arreglo 
document.getElementsByTagName("li")[2].style.color = "red"; 
//SELECCIONAR ELEMENTOS POR CLASES 
document.getElementsByClassName("btn");//como es elements en plural tambien nos va a dar un arreglo para trabajar 
//SELECCIONAR ELEMENTOS POR ID
document.getElementById("28928fsd87");//porsupollo tambien se trabaja como un arreglo 


// ---------------------------------------------------------------------------------------------------------------------------------------------


//COMO SELECCIONAR CUALQUIER ELEMENTO COMO SI ESTUBIESEMOS ES CSS 
document.querySelector("aqui podemos seleccionar id(#btn), class(.container), selector(h1)");
// de esta manera podemos buscar elementos como en css
// POR LO TANTO TAMBIEN PODEMOS USAR JERARQUIAS


/*
ES MEJOR SEPARAR HTML CSS Y JS 
por eso es mejor trabajar añadiendo y quitando clases cuando sea necesario cambiar apariencias 
*/

// COMO AGREGAR Y QUITAR CLASES 
document.querySelector("button").classList.add("invisible");// .classList.add agrega una clase 
document.querySelector("button").classList.remove("invisible");// .classList.remove quita una clase
document.querySelector("button").classList.toggle("invisible");
//.classList.toggle si tiene la clase entonces la quita y si no la tiene entonces la agrega 


// ---------------------------------------------------------------------------------------------------------------------------------------------

//COMO TRABAJAR CON LOS ATRIBUTOS
document.querySelector("a").attributes;//nos da todos los atributos 
document.querySelector("a").getAttribute("elijo el atributo"); //nos dice que hay dentro del atributo 
document.querySelector("a").setAttribute("elijo el atributo", "remplazo del contenido")// es para cambiar el contenido de un atributo 

