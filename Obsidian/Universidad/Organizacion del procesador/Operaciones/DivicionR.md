DIVISOR                              DIVIDENDO 
![[alg-divicion.png]]
REGISTRO

**Es mejor escribir el divisor complementado por que después tenemos que restar** 
**Vamos a hacer tanta cantidad de Shifteos como bits del dividendo** 

1. Arrancamos shifteando con cero para la derecha siempre.
2. Sumamos el Complemento del divisor al registro.
	1. si el primer bit a la Izquierda del REGISTRO es 1 restauramos(registro)
	2. si el primer bit a la Izquierda del REGISTRO es 0 no restauramos y cambiamos el cero del ultimo shifteo por un 1 a la Derecha del DIVIDENDO

**EN EL REGISTRO NOS QUEDA EN EL RESTO Y DONDE ESTABA EL DIVISOR NOS QUEDA EL RESULTADO** 

