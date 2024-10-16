## pipeline
al ejecutar una instruccion como ` add` ejecutamos por dentro muchas microistrucciones.
pipeline es ejecutar una subtarea y en el proximo tiempo volver a ejecutar esa misma tarea pero de la proxima instruccion, **es como ejectur todas las tareas de manera paralela para poder ser mas efectivos** 
### Conflictos 
estos pasan por que a veces hay que 
- esperar a que una instruccion termine para poder ejecutar la proxima o cuando una microinstruccion necesita usar un datos que ya esta en uso. 
- Los saltos incondicionales generan una variacion en el flujo del pipeline 
- Los saltos condicionales son peor por que todavia no sabemos si vamos a saltar
la alternativa de pipeline para estos casos es reacomodar las instrucciones para que se pueda si no se pueden reacomodar **no hace NADA** 
	si movemos algo al eax y luego le sumamos algo vamos a tener que esperar a que se mueva la totalidad para despues poder sumar.

Buscar videos de pipeline [[Tareas a liquidar]]


