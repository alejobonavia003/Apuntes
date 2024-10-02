# FULL ADDER
![[FULL-ADDER.png]]
*Contiene circuitos [[OR]], [[AND]], [[XOR]]*

EL FULL ADDER es un [[HALF ADDER]] mejorado para que ahora pueda leer un carry anterior y pueda mandar un carry al próximo.

Luego de hacer la suma de los dos bits del registro lo que hace es sumar lo que aya en el carry **como si estuviera un [[HALF ADDER]] conectado con otro [[HALF ADDER]] que suma el carry que le llego** luego con un [[OR]] entre los dos carry decidimos si hay próximo carry o no.

entonces ahora podríamos unir muchos bits con el cable de carry y así podríamos hacer sumas mas grandes 

![[Full-Adder-4bits.png]]

**Y asi es el circuito que se encarga de la [[Suma y RestaR]] dentro del procesador** 
