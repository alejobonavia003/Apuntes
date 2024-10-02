alert("es una ventana emergente con un mensaje");
typeof(/*dato de algun tipo*/5); // devuelve el tipo de dato 
prompt("esto es una ventana emergente con una entrada de datos");

//variables 
var name = "Alejo"; 
//es tan simple como eso y no es necesario especificar eel tipo

// cadena de caracteres 
name.length; // devuelve la longitud 
name.slice(1,10); // corta la cadena desde el 1 al 10 
name.tuOpperCase; //pasa todos los caracteres a mayusculas 
name.tuLowerCase; // pasaa toda la cadena a minusculas 

//EJERCICIO 1 DE MODULO 14 JSCRIPT 
var tweet = prompt("Ingrese un tweet: "); 

if (tweet.length > 140) {
    tweet = tweet.slice(0,140);
    alert("Te pasaste del maximo de caracteres y sera recortado.");
    alert("Su thweet tiene "+ tweet.length +" caracteres de "+(140-tweet.length)+" caracteres"); 
    alert ("Su tweet: " + tweet);
} else {    
    alert("Su thweet tiene "+ tweet.length +" caracteres de "+(140-tweet.length)+" caracteres"); 
}


// -------------------------------------------------------------------------------------------------------------------------------------------


var name = prompt("Whats is your name?. ");
var head = name.slice(0,1); 
var last = name.slice(1,10);
head = head.toUpperCase();
last = last.toLowerCase();
name = head + last; 
alert("Hello " + name);

//----------------------------------------------------------------------------------------------------------------------------------------
function lifeInWeeks(age) {
    
    /************Don't change the code above************/    
        
        //Write your code here.
        var x = (90*365) - (age*365);
        var y = (90*52) - (age*52);
        var z = (90*12) - (age*12);
        
        console.log("You have "+x+" days, "+y+" weeks, and "+z+" months left.");
        
        
    /*************Don't change the code below**********/
    }
    
    lifeInWeeks(21);
//----------------------------------------------------------------------------------------------------------------------------------------
function bmiCalculator(peso, altura){
    return Math.round(peso /(altura*altura));
   }
   
//----------------------------------------------------------------------------------------------------------------------------------------
// calculadora ramdom 
// como guardar un numero random en una variable 

function amor(){
    prompt("Introduzca un nombre.");
    prompt("Introduzca otro nombre.");
    var n = Math.random();//calculo numero random
    n = n * 100;// como los numeros random son del 0..0,999 al multiplicarlo por 100 me va a dar 100 numeros randoms
    n = Math.floor(n)++; //redondeo el numero para que efectivamente sean 100 numeros y ++ por que sino los numeros son del 0 al 99 
    alert("tienen una coneccion del :" + n + "%");
  }
  
  amor();

// dato sobre tipos 
// con '==' es comparan dos tipos de datos sin importar los tipos 
// con '===' se compara tambien el tipo de dato 

//----------------------------------------------------------------------------------------------------------------------------------------

function bmiCalculator (weight, height) {
    var interpretation;
    var bmi = weight / (height*height);
    if (bmi > 24.9) {
      interpretation = "Your BMI is "+bmi+", so you are overweight.";
    } else {
      if(bmi > 18.5) {
        interpretation = "Your BMI is "+bmi+", so you have a normal weight.";
      } else {
        interpretation = "Your BMI is "+bmi+", so you are underweight.";
      }
    }
    return interpretation;
}

bmiCalculator(55, 1.80);
/*
BMI <18.5, the output should be: "Your BMI is <bmi>, so you are underweight."

BMI 18.5-24.9, the output should be "Your BMI is <bmi>, so you have a normal weight."

BMI >24.9, the output should be "Your BMI is <bmi>, so you are overweight."
*/
//----------------------------------------------------------------------------------------------------------------------------------------
function isLeap(year) {
    var esbiciesto = false;
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        if ( year % 400 == 0) {
          console.log("Leap year.");    
        } else {
          console.log("Not leap year.");  
        }
      } else {
        console.log("Leap year.");  
      }
    } else {
      console.log("Not leap year.");
    }   
}

isLeap(2020);

/*
Un año es bisiesto si es divisible exactamente por 4 ;

excepto si ese año también es divisible por 100 ;

a menos que ese año también sea divisible por 400 .
Leap year.
Not leap year.
*/
//----------------------------------------------------------------------------------------------------------------------------------------

//arreglos 
var arreglo = [1,2,3,4,5];
// es lo mismo que los demas lenguajes 

// como saber si un elemento pertenece a un arreglo 
var arr = [1,2,3,4];
arr.includes(1);
// obviamente pertenece pa 
//----------------------------------------------------------------------------------------------------------------------------------------
// como agregar y quitar elementos del final de arreglo 
var arr = [];
arr.push(1); // agrega el numero 1 al final del arreglo 
arr.put();// elimina el ultimo elemento del arreglo 
//----------------------------------------------------------------------------------------------------------------------------------------
var out = [];
var cont = 0;
function fizzbuzz() {
  var lenn = (out.length + 1);
  if((lenn % 3 == 0) || (lenn % 5 == 0)){
    if (lenn % 3 == 0){
      
      if(lenn % 5 == 0){
        out.push("fizzbuzz")
      } else {
        out.push("fizz");  
      }
    } else {
      out.push("buss");
    }
  } else {
    out.push(lenn);
  }
  console.log(out);
}

//----------------------------------------------------------------------------------------------------------------------------------------

function whosPaying(names) {
    var tu = (Math.round(Math.random()*(names.length - 1)));
    return names[tu]+" is going to buy lunch today!";
}
//Michael is going to buy lunch today!

whosPaying(["Angela", "Ben", "Jenny", "Michael", "Chloe"]);
//----------------------------------------------------------------------------------------------------------------------------------------
function bottles() {
    cont = 100;
    while (cont >= 0) {
      cont--;
      if (cont > 1) {
      console.log(cont+" bottles of beer on the wall, "+cont+" bottles of beer.Take one down and pass it around, "+(cont-1)+" bottles of beer on the wall.");
      }else {
        console.log("1 bottle of beer on the wall, 1 bottle of beer.Take one down and pass it around, no more bottles of beer on the wall.");
      }
    }
    console.log("No more bottles of beer on the wall, no more bottles of beer.Go to the store and buy some more, 99 bottles of beer on the wall.");
  }
  bottles(); 
  
//----------------------------------------------------------------------------------------------------------------------------------------
