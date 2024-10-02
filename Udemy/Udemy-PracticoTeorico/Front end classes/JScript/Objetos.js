//asi creamos una variabre que se puede usar como objeto
var bellBoy1 = {
    name: "timmy",
    edad: 19, 
    permisos: true,
    idiomas: ["french","inglis"]
}
/* crear objetos de esta manera es muy ineficiente 
por eso podemos CREAR UNA FABRICA DE OBJETOS 
podemos usar una funcion para fabricar objetos y luego con new ya podriamos tener los nuevos objetos
*/

//FUNCION FABRICADORA DE OBJETOS
function BellBoy(nombre,edad,permisos,idiomas){
    this.name = nombre;
    this.edad = edad; 
    this.permisos = permisos; 
    this.idiomas = idiomas; 
    //PODEMOS AGREGAR FUNCIONES A NUESTEOS OBJETOS Y ESTAS SE LLAMAN METODOS
    this.trabajar = function(){
        alert("estoy trabajando.");
    }
}

//FORMA CORRECTA DE CREAR NUEVOS OBJETOS 
var bellBoy = new BellBoy("timmy",19,true,["french","englis"]);

/*
luego podemos obtener ver cambiar y modificar los datos del objeto 
tambien podemos usar las funciones de cada objeto 
TENER CLARO ESTOS CONCEPTOS ES MUY IMPORTNANTE 
*/ 