## Operaciones basicas

`mov operador1, operador2` 
el dato de operador2 es copiado en operador1 

`add operador1, operador2` ; operador1 = operador1 + operador2
`add al, ah` ; al = al + ah

Sub : restar enteros 
`sub bx, 10` ; bx = bx -10 

Incrementar y decrementar 
`inc eax` ; eac ++ 
`dec eax` ; eax -- 


## Directivas 

##### Unidad de almacenamiento 

| unidad            | Letra |
| ----------------- | ----- |
| byte              | B     |
| Palabra           | w     |
| palabra doble     | d     |
| palabra cuadruple | q     |
| dies bytes        | t     |

#### Directivas de datos 
La letra d es de directiba y se usa dX donde X puede ser cualquier letra de la tabla de arriba 

la palabra resbX es para recervar bits de memoria X puede ser cualquier tamaño que este en la tabla 

luego si definimos una etiqueta 
`L1 db 1010b` ; la b al ultimo del numero dice que se reserva tan numero en binario
`L2 db f5h` la letrah al final del numero dice que se define tal nummero en hexadecimal 

`L3 db 0,1,2,3` ; en los proximos 4 bits de L3 se definen 0, 1 , 2, 3


`L4 times 100 db 0` ; equivalente a 100 veces db 0
`L5 resw 100` reserva lugar para 100 palabras 

### Aclaracion 
las Etiquetas `L1` y esas van a guardar adentro una dirreccion de memoria 

`mov eax, L1` mueve la direccion de memoria `L1` a eax 
`mov eax,[L1]` mueve lo que hay dentro de la direccion de memoria a eax

