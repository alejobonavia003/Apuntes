// jQuery es un framework de jscript iudd que mamitas 

/*cada vez que use este framework hay que agregarle su CDN para hacer la llamada a la script 

--------------------------------------------------------------

cada llamada a un selector como document.queryselector("h1"); va a ser $("h1");

cada cambio de style uso la propiedad $("h1").css("propiedad", "valor"); 

agregar cases $("h1").addClass("className");
eliminar clases $("h1").removeClass("ClassName");
consultar si tiene una clase $("h1").hasClass("ClassName");
--------------------------------------------------------------
COMO CAMBIAR UN TEXTO 

$("h1").text("newTitle");

--------------------------------------------------------------
QUE PASA CUANDO QUEREMOS SELECCIONAR MUCHOS ELEMENTOS 
    lo hacemos de la misma manera y seleccionar todos los elementos y aplicara o cambiara una propiedad a todos por igual 

    por ej: si tenemos 5 botones 

    $("buttom").text("dont not click me"); se cambiaran el texto de los 5 botones 

--------------------------------------------------------------
COMO CAMBIAMOS EL CONTENIDO DE UN SELECTOR DE HTML O AGREGAMOS OTRO CONTENIDO (innerHTML)
    $("h1").html("<a>hola</a>");
--------------------------------------------------------------
ATRIBUTOS 
    $("a").atrr("NameOfAttribute","por que lo que lo voa a cambiar");

    podemos hacer una consulta de que hay dentro de un atributo 

$("a").atrr("NameOfAttribute"); 
--------------------------------------------------------------
EVENTOS O OYENTES 
    antes para agregar un evento o un oyete para muchas cosas deviamos usar un bucle y recorrer todos los botones 
    ahora lo ariamos asi 
    $("button").click(function () {
        $("h1").css("color", "purpleHaze"); // cambio el titulo de color al hacer clic en cualquiera de los 5 botones 
    });
--------------------------------------------------------------    
    Y SI QUISIERAMOS UN OYENTE DE CADA TECLA QUE PRECIONO 
    
   $(Document).keypress(function(event){
    console.log(event.key); //cada ves que se preciona una tecla dentro del documento se va a mostrar en consola 
   });
    

--------------------------------------------------------------  
COMO DETECTAR EVENTOS 
   $("h1").on("mouseOver", function(){
        aca especificamos que va a pasar cuando se detecte mouseOver
   });

   moseOver: es cuando pasamos el maus por arriba.
--------------------------------------------------------------    
COMO AGREGAR ELEMNTOS DESDE JS EN HTML 
    $("h1").beforce("<button>newButton</button>"); agrega un boton arriba del titulo 
    $("h1").after("<button>newButton</button>");   agrega un boton abajo del titulo 
    $("h1").prepend("<button>newButton</button>"); agrega un boton antes del titulo pero adentro de la etiqueta
    $("h1").append("<button>newButton</button>"); agrega un boton despues del titulo pero adentro de la etiqueta
--------------------------------------------------------------    
COMO ELIMINAR ELEMENTOS 
   $("button").remove(); 
   simplemente elejimos el elemento y con la funcion remove lo eliminamos
--------------------------------------------------------------    
ANIMACIONES 
   supongamos que queremos desaparecer algo al cliquear un botton 
   $("button").on("cluck", function(){
    $("h1").hide(); esta funcion desaparecera el h1 al hacer click en el boton 
    $("h1").show(); esta funcion mostrara lo que hay en el h1 al hacer click en el boton 
    $("h1").toggle(); aparece el h1 si no esta y desaparece si lo esta 
   })

   DESAPARECER COSAS BAJANDOLE LA OPACIDAD O APARECERLAS SUBIENDO LA OPACIDAD 
   .
   $("h1").fadeOut(); desaparecera el elemento bajandole la opacidad hasta 0 
   $("h1").fadeIn(); aparecera el elemento subiendole la opcacidad progresivamente 
   $("h1").fadeToggle(); lo mismo que los demas pero toggle 

   APARECER Y DESAPARECER ELEMENTOS DESLIZANDOLOS HACIA ARRIBA Y ABAJO 
   .
   $("h1")slideUp.(); desaparece un elemento deslizandolo hacia arriba.
   $("h1")slideDown.(); aparece un elemento deslizandolo hacia abajo.
   $("h1")slideToggle.(); tambien tienen su toggle

   ANIMACIONES PERSONALIZADAS 
   $("h1").animate({aca va todo el css correspondiente a la animacion}); 
   es muy importante que aca usemos propiedades con valores numeriocos para que jquery los pueda trabajar gradualmente  
   */


//VERY IMPORTANT DONT NOT MEMORYZE PROPYTIS. SEARCH IN GOOGLE PROPYTIES IS VERY EASY    
$(Document).keypress(function(event){
    $("h1").text(event.key);
});