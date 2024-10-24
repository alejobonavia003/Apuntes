me muevo a la carpeta del CPUsim y le man´do 
`java -cp



# Practica 5
## wombat1




#### Ejercicio 1
a) En su definicion de hardware tiene: 
- `acc`: con un ancho de 16 bytes *un registro que lo usamos para almacenar el resultado de operaciones aritmetico-logicas*
- `pc`: con un ancho de 12 bytes *es para almacenar la direccion de memoria de la proxima instruccion a ejecutar*
-  `mdr`:con un ancho de 12 bytes *es para almacenar la direccion de memoria que vamos a leer o escribir*
- `ir`: con un ancho de 16 bytes *Contiene la instruccion que esta actualmente siendo ejecutada*
- `mar`: con un ancho de 16 bytes *almacena los datos que se leen de la memoria o que se van a escribir en ella*
- `status`: con un ancho de 3 bytes *contiene todos los flags*
- ***todos son registros***
luego todos tienen una parte que dice initial value que en todos esta en cero y tambien tienen un check que dice read-onli desmarcados en todos explicame que significan estas ultimas dos cosas

b) Tenemos las siguientes instrucciones:
- `stop `: *Detiene la ejecución del programa*.
- `load [direccion]`: *Toma el valor almacenado en una dirección de memoria específica y lo coloca en el registro acumulador (ACC)*.
- `store [direccion]`: *Toma el valor que se encuentra en el acumulador (AC) y lo almacena en una dirección de memoria específica.* 
- `read`: *Solicita un valor del dispositivo de entrada y lo almacena en el acumulador (AC).*
- `write`: *Envía el valor que está almacenado en el acumulador (AC) al dispositivo de salida.*
- `add [direccion]`: *Toma el valor en una dirección de memoria, lo suma al valor del acumulador (AC), y guarda el resultado en el acumulador.*
- `subtrac [direccion]`: *Toma el valor de una dirección de memoria, lo resta al valor del acumulador (AC), y guarda el resultado en el acumulador.* 
- `multiply [direccion]`: *Multiplica el valor en una dirección de memoria por el valor del acumulador (AC), y guarda el resultado en el acumulador.*
- `divide [direccion]`: *Toma el valor en el acumulador (AC) y lo divide por el valor en una dirección de memoria, almacenando el resultado en el acumulador.*
- `jump [direccion]`: *Modifica el registro de programa (PC) para apuntar a una nueva dirección, continuando la ejecución desde allí.*
- `jmpz [direccion]`: *Si el valor en el acumulador (AC) es cero, salta a la dirección especificada. Si no, continúa con la siguiente instrucción.*
- `jmpn [direccion]`:*Si el valor en el acumulador (AC) es negativo, salta a la dirección especificada. Si no, continúa con la siguiente instrucción.*

c) proporciona las siguientes microinstrucciones: 
- pc->mar: *. Esto prepara a la unidad de control para acceder a la memoria en esa dirección.*
- mar->pc: *El valor almacenado en el MAR se transfiere al PC. Esto permite cambiar la dirección de la próxima instrucción a ejecutar.*
- ir(4-15)->mar: *Los bits 4 a 15 del IR, que normalmente contienen una dirección de memoria, se transfieren al MAR. Esto se utiliza para acceder a una dirección específica en la memoria relacionada con la instrucción que se está ejecutando.*
- mdr->ir: *El contenido del MDR, que contiene los datos o la instrucción leída de la memoria, se transfiere al IR. Esto permite cargar la instrucción que se va a ejecutar en el registro de instrucciones.*
- mdr->acc: *El contenido del MDR se transfiere al acumulador. Esto se utiliza cuando una operación aritmética o lógica va a ser realizada en el valor leído de la memoria.*
- acc->mdr: *El valor actual del acumulador se transfiere al MDR, normalmente para almacenarlo en la memoria o para realizar alguna operación con él.*
- ir(4-15)->pc: *El valor de los bits 4 a 15 del IR, que normalmente contiene una dirección de salto, se transfiere al PC. Esto se utiliza para modificar el flujo de ejecución, como en un salto incondicional o condicional.*

d) la arquitectura posee 128 bytes de ram.

e) disponemos de 4 bits para el operador y 12 bits para los operandos

f) ***PREGUNTAR***

g) 
- mdr`: con un ancho de 16 bytes *almacena los datos que se leen de la memoria o que se van a escribir en ella
- mar`: con un ancho de 12 bytes *es para almacenar la direccion de memoria que vamos a leer o escribir*

