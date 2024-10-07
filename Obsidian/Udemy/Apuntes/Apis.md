# Aplication programing interfaces
Es basicamente comunicarte con el servidor de otra entidad para iteractuar y usar funcionalidades de ese otro codigo y funciona con [[HTTP]] podemos pedir, enviar y recibir informacion, *Comunicarte* con otros servidores. 
``` HTTP
https://bored-api.appbrewery.com/filter?type=education
```

*Lugo de lo que seria el link osea despues del .com empiezan los parametros que enviamos junto con la peticion* 
$?$ Luego del signo le enviamos el nombre del parametro 
$=$ luego del igual le mandamos el valor del parametro 
	_esta es una forma de mandar una clave para pedir informacion adicional o informacion mas especifica._ 
``` HTTP
https://bored-api.appbrewery.com/endpoint?query=value&query1=value1
```  


podemos usar un parametro de camino **PATH PARAMETER** 
	es acceder a una informacion especifica como si de un archivo de texto se tratara 
simplemente $/$ nos movemos con las barras 
``` HTTP
https://bored-api.appbrewery.com/activity/3943506
```
_Hacemos una peticion de la actividad con el id 3943506_. esta api nos devuleve una actividad aleatoria pero asi accedemmos a una actividad en particular 

**Las apis web suelen mover informacion a travez de archivos [[JSON]]**   
