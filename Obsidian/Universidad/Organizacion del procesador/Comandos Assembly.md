## Nativos
- `%include "asm_io.inc`: Nos permite incluir archivos con codigo fuente 
- `%define SIZE 100` : Nos permite declarar constantes(asocian nombres a valores).
## Instrucciones Aritmetico-Logicas 
- `add <destino>, <valor>` : Suma 
- `sub <destino>, <valor>` : Resta 
- `inc <destino>` : Incrementa 
- `dec <destino>` : Decrementa 
- `imul <destino>, <valor>` : Multiplicacion 
- `mul <valor>` : Esta la usamos cuando queremos multiplicar numeros de 32 bits, suponemos que el operando esta en el `EAX` y solo cargamos el segundo operando, el resultado queda guardado en `EDX:EAX`
- `div <destino>, <valor>` : Division
- `idiv <valor>` Division 

## Instrucciones de manipulacion de bits 
- `shr <registro> <constante>` : shift a derecha 
- `shl <registro> <constante>` : Shift a la izquierda 
- `sar <registro> <constante>` : Shift aritmetico a la derecha 
- `sal <registro> <constante>` : Shift aritmetico a la izquierda  
- `ror <registro> <constante>` : Rotacion a la derecha  
- `rol <registro> <constante>` : Rotacion a la izquierda
	"los shifteos aritmeticos conservan el signo del numero."
## Instrucciones logicas
- `and <destino> <valor>`  
- `or <destino> <valor>`
- `xor <destino> <valor>`
- `not <destino>`

## Instrucciones de saltos 
`je` : salta si es igual
`jne` : salta si NO es igual
`jz`: salta si el último resultado fue cero
`jg` : salta si es mayor
`jge`: salta si es mayor o igual
`jl`: salta si es menor
`jle`: salta si es menor o igual
`jo`: salta si hubo overflow
`jno`: salta si NO hubo overflow
`js`: salta si el FLAG de signo está encendido
`jns`: salta si el FLAG de signo NO está encendido



