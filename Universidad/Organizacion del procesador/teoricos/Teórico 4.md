# Cómo computar utilizando la electricidad
![[Un bit de memoria]]


![[HALF ADDER]]
![[FULL ADDER]]
![[NOT CONDICIONAL]]
![[SHIFT]]

## Overflow
Es cuando no alcanzan la cantidad de bits para representar el resultado de una operación.
#### Como lo vemos?
- calculamos los limites y vemos si el numero esta dentro del limite ó 
- si el ultimo y el penúltimo CARRY son diferentes entonces hay overflow

![[DECODIFICADOR]]

![[PROGRAM COUNTER]]

![[REGISTROS DE INSTRUCCIONES]]

## Arquitectura von Neumann
con todos estos conceptos ya podemos armar la arquitectura de von Neumann.

- La Unidad de control obtiene de la memoria la próxima instrucción que indica el contador de programa ([[PROGRAM COUNTER]]) y la almacena en el Registro de Instrucción (IR). Finalmente actualiza el PC indicando la dirección de la próxima instrucción.
- La Unidad de control decodifica la instrucción y obtiene de la memoria (si fuere necesario) la información que involucra dicha instrucción.
- La ALU ejecuta (calcula) el resultado de la operación y lo almacena en un registro o memoria.