- que son las promesas? 
  Las promesas en javascript se usan para manejar codigo asincronico y reprecentan un valor que puede estar disponible ahora, despues o nunca
  Las promesas tienen tres estados principales **pendiente, resuelta o rechazada** y para trabajar estos resultados un vez que los obtenemos usamos las funciones .`then` y .`catch` 
- - -
- que es codigo asincronico? 
  El **codigo asincronico** se refiere a que es una parte del codigo que se pued ejecutar en segundo plano sin interrumpir el flujo normal del programa 
- - -
- Como funciona el async?
  cuando definimos una funcion com `async` automaticamente devuelve una promesa y la funcion pasa a poder ejecutarce de manera asincronica 
- - -
- Como funciona await?
  `await` solo puede usarce dentro de una funcion asincronica, lo que hace es pausar la ejecicion de esa funcion hasta que la promesa se cumpla o de error pero mientras la promesa se mantega en espera no se ejecuta la funcion 
- - -