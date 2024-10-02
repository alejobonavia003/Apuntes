# Multiplicación
Multiplicar es lo mismo que hacer sumas parciales por ejemplo 3* 2 es lo mismo que sumar 3 dos veces o sumar 2 tres veces, con esta lógica podemos usar los circuitos de [[FULL ADDER]] para hacer muchas sumas parciales y no hacer un circuito a parte par la multiplicación.

## Algoritmo de la multiplicación
Primero dibujamos una tabla así.

*MULTIPLICANDO*              *MULTIPLICADOR*
![[Alg-Multiplicacion.png]]
*CEROS*

 **Ahora nos vamos a fijar el el primer bit del lado derecho del multiplicador**
	   Si es 1 entonces: 
	    - sumamos el multiplicando a los ceros o al numero que tenga en el registro
	    - Shifteamos a la derecha completando con cero
	    Si es 0 entonces: 
	    - Solo Shifteamos a la derecha con cero 
	*Y así sucesivamente.*

==CONSEJOS==
- ==vamos a hacer tanta cantidad de Shifteos como cantidad de bits del multiplicador.==
- ==Vamos a hacer tantas sumas parciales como unos tenga el multiplicador.==

## Regla de signos 
$+*+$ : Usamos el algoritmo tal cual lo conocemos. 
$-*+$ : ==Tenemos en cuenta que después de la primera suma parcial los Shifteos se completan con 1 ya que nos debe quedar el numero complementado.==
$+*-$ : Complementamos los dos números y los trabajamos como el caso anterior.
$-*-$ : Complementamos los dos números y los tratamos como$+*+$ .

_Usamos [[Suma y RestaR]], [[Complemento a la base]]._
