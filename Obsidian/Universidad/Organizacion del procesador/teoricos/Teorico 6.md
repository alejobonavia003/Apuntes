# Assembly
Es un lenguaje de bajo nivel que permite trabajar a instrucciones maquina sin tener que programar bit a bit.
### Tipos de procesadores 
*RISC*: Reduced instruccion set computer 
*CISC*: Complex instuccion set computer 

*Instrucciones*: El enssamblador X86 opera a nivel de instrucciones de maquina del procesador  por lo tanto cada instruccion de assembly se corresponde a una operacion que puede hacer el procesador. 
*Registros*: en assembly se manejan registros de propocito generales como EAX, EBX, ECX, EDX que se pueden usar para almacenar valores en numeros hexadecimales. 
*Memoria*: Se pueden usar direcciones de memoria directamente con las instrucciones para poder leer o escribir datos en la memoria principal 
*Directivas enssamblador*: ademas de las insntrucciones ensamblador tiene algunas directivas especificas que se pueden utilizar para definir constantes, recervar espacio de memoria, especificar segmentos de codigo y datos entre otras cosas. 

### Unidades de memoria 

| Unidad            | Letra |
| ----------------- | ----- |
| Byte              | B     |
| Palabra           | W     |
| Palabra doble     | D     |
| Palabra cuadruple | Q     |
| Dies Bytes        | T     |
	_Normalmente vamos a usar las primeras 3 y solo tenemos que acordarnos cuantos bytes recerva_

En general todos los procesadore nos van a permitir hacer operaciones para: 
- Transferencia de datos. *como guardar valores en registros.*
- Operaciones aritmetico-logicas. *ademas de las operaciones comunes como la suma y la resta los procesadores modernos tienen operaciones mas operaciones especiales como puede ser la multimedia*
- Control de programa. *Permite controlar el flujo de la ejecucion del programa mediante instrucciones de salto y de ramificacion*
- Instrucciones de entrada y salida. *Permite que el procesador interactue con dispocitivos externos como teclados y pantallas.*

## Instrucciones ISA
Cada instruccion es una posible operacion que el procesador puede hacer por Hardware por lo que cada va a tener su codigo de identificacion y estas van a depender de cada procesador ![[Instucciones-ISA.png]]
Tipos de operaciones: 
- *Inmediato*: `mov EAX, 1` Es cuando trabajamos con un valor como tal
- *Directo*: `mov EAX, [n]` Es cuando trabajamos con lo que hay dentro de una direccion de memoria 
- *Registro*: `mov EAX, EBX` Es cuando trabajamos directamente con registros 
- *Indirecto*: `mov EAX, [EBX]` Es cuando usamos registros para alojar direcciones de memoria y luego trabajar con eso. 

# Saltos 
Son la mejor forma de alterar el secuenciamiento por defecto que indica la proxima instruccion. 
	De esta forma podemos simular las estructuras de control de los lenguajes de alto nivel 
### Condicionales 
![[IfElse.png]]
	`cmp EAX, EBX` : Compara los registros restandolos luego usamos un salto de tipo `jne` que salta si no son iguales 
``` c
//Ejemplo de un if
cmp EAX, EBX 
jne else 
	// Cuerpo del if cuando son iguales EAX y EBX
jmp break  //break = salir o finSi 
else: 
	//Cuerpo del else cuando son diferentes EAX y EBX
break: 
//Luego continua el flujo del codigo 
```
### Bucles 
Para simular los bucles podemos usar la instruccion `loop` 
- `loop` usa el registro `ecx` para saber cuantas veces  tiene que ciclar, debemos mover alli cuantas veces necesitamos ciclar 
``` c
mov ECX, 10 
for1: 
	// Cuerpo del for 
	inc ECX 
loop for1
```

![[Comandos Assembly]]

