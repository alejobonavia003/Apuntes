# Representación de números racionales
Para representar los números con punto flotante nos vamos a basar sistema de la notación científica que usa la calculadora. 
![[Notacion-cientifica.png]]
**Si el $n$ es negativo agregamos $n$ ceros adelante y la coma después del primer cero y si $n$ es positivo agregamos $n$ ceros atrás.**

## Como representamos números flotantes con bits
Al usarse notación científica forzamos a dividir nuestra celta de bits en 3 partes para poder representa su *signo*, *exponente* y *mantiza*  
![[Reprecentacion-de-flotantes.png]]
**El bit del signo es para el numero final no para el exponente**. El signo del exponente va a depender del Sesgo o bias que se calcula con la [[#Polarización]] 

## Representación de Números Racionales con punto flotante - convenciones
![[Convenciones-punto-flotante.png]]

## Polarización
La polarización es una forma de representar números positivos y negativos. se suma un valor fijo (llamado **sesgo** o **bias**) al exponente real para obtener el valor final del exponente.
#### Y por que sumarle un sesgo?
Para polarizar el numero tendremos que sumar por que la idea de sesgo es representar los números negativos al principio de la celda de bits al medio estaría el cero y en la segunda mitad estarían los números positivos. ![[sesgo-bias.png]]
#### Como se calcula el sesgo? 
**se calcula en base a la cantidad total de la representación dividido 2 menos 1.**![[Tabla-sesgo.png]]
Sumando el sesgo se puede calcular el exponente para un numero.
Restando el sesgo se puede calcular un numero que estaba en el exponente. 

Exponente binario --> exponente decimal = Restar sesgo 
Exponente decimal --> Exponente binario = Sumar sesgo 

## Bit Oculto
Esto parece ser inútil a simple vista pero es obvio que la mantiza va a tener como mínimo un uno de otro caso seria el caso especial cero o los infinitos, por lo que ==si asumimos que el primer bit siempre va a ser uno nos ahorramos un bit==
	con esto nos ahorramos mucho en costos en tema hardware.
![[bit-oculto.png]]
El bit subrayado con rojo es un bit que nunca lo vemos pero siempre lo tenemos que tener en cuenta. 

## Como pasar un numero binario a decimal
- Pasamos la parte entera y la parte decimal por separado del numero que nos den.
  20.50 pasamos 20 = 10100 y 0.50 = 1
- 10100.1 contamos cuantas veces tenemos que correr la coma para que queden el el primer 1 del lado izquierdo.
  1,01001 : Corrimos 4 veces la coma.
- exponente = 4 ahora le sumamos el sesgo 4 + (2^8)/2-1 = 131 
- ahora la mantiza son los números que quedaron después de la coma y el exponente es el calculo del punto anterior.


# Estándares IEEE 1985

**Single:** 32 bits

- 1 bit para el signo
- 8 bits para el exponente 
- 23 bits para la mantisa 

**Double**: 64 bits

- 1 bit para el signo 
- 11 bits para el exponente 
- 52 bits para el exponente 

![[Operaciones con Flotantes]]
