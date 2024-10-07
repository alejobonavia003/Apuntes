# javascript object notation 
Es una forma de darle formato a los archivos que se envian por internet de manera legible pero a la vez eficaz
	_Basicamente lo que se mueven dentro de estos archivos son objetos_![[JSON-examples.png]]
	son como registros...

*Luego estos archivos son enviados en formato plano sin espacios ni saltos de linea.* 

https://jsonviewer.stack.hu/ podemos armar y desarmar archivos JSON  

 **Funcion para empaquetar archivo JSON**
``` JS
const jsonData = JSON.stringfy(ArchivoJSON)
```

**Funcion para desempaquetar un archivo JSON** 
``` JS
const data = JSON.parse(ArchivoJSON)
```


