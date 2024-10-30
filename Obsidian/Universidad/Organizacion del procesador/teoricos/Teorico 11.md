# Memoria Virtual 
La memoria virtual es basicamente sacar memoria del almacenamiento para reservarla por si acabamos la cantidad de memoria ram que tenemos. 
	si tenemos 8gb de ram y nos pasamos por un poco se va a usar la memoria del almacenamiento mucho mas lenta pero no se corta nada 

**Objetivo**
que el sistema operativo administre y mueva la memoria usada de la manera mas eficiente posible 

en su funcionamiento teorico lo que hace es si tenemos que ejecutar 3 procesos diferentes, divide los 3 procesos en muchas paginas o frames y a medida de que cada proceso necesita un bloque de memoria la RAM se la va dando 

![[Memoria-Virtual.png]]

SI a pesar de todas estas tecnicas de optimizacion necesitamos mas memoria podemos simular mas memoria de la que tenemos RAM, sacando del almacenamiento SSD o HHD 

***AHORA SACARLE MEMORIA AL DISCO NO ES GRATIS*** Hay que tener en cuenta tambien que asi como la memoria cache es mas rapida que la Ram la memoria RAM es 100 veces mas rapido que la HDD o SDD 

# Tabla de paginas
[[Tareas a liquidar]]
la tabla de paginas me va a ahcer entender por que es contraproducente poner memoria virtual de mas 

pero basicamente mientras mas memoria virtual tenemos o asignamos mas grande es la tabla de paginas y la tabla de paginas esta alojada en memoria 

Buscar el problema de fragmentacion interna [[Tareas a liquidar]] basicamente trabaja como la desfragmentador del disco 


**Ta todo hay que resumir teoricos bien con mis palabras y no dejar ni un ejercicio para hacer** 




