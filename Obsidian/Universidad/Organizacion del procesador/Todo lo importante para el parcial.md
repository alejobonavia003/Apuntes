# Memoria Cache 
- `hit` es cuando la instruccion que buscamos esta en la cache 
- `miss` es cuando la instruccion que buscamos no esta en la cache 

### Tamaño de las direcciones
El tamaño de la direccion de memoria osea cuantos bits se van a alojar por cada casilla tanto si es RAM o CACHE va a ser: $$\text{Total de ram} = 2^x$$
							O
$$\text{Total de cache} = 2^x$$
	*En hambos casos el tamaxo de las direcciones es $X$* 

El tamaño de cada palabra/celda lo vamos a calcular con la catidad de palabras por bloque 
$$\text{Palabras por bloque} = 2^x$$
$X$ es el tamaño de cada celda/palabra

- - -
TRUQUITO
***Si nos dice que nos da una memoria con $x$ cantidad BLOQUES tenemos que calcular la cantidad en almacenamiento que ocupa*** multiplicando la cantidad de $x$ bloques por la cantidad de palabras/word/casillas que hay por bloque 
- - - 
***Ahora si nos da una memoria con $x$ cantidad PALABRAS entonces ya tenemos el tamaño calculado***
- - -

###  Bloques 
El Tamaño de los bloques es algo que se decide por lo que me lo van a dar en la consigna 


*Una vez calculado los tamaño de las direcciones y el tamaño de cada palabra*
### Tipo de organizacion  **Directa**
- *Numero de bloque*: lo calculamos restando el total de la memoria cache con el tamaño de palabra
- *tag*: Restamos el tamaño de las direcciones de memoria ram con el total de la memoria cache y nos sobra el tag
- *tabla auxiliar*: en **Directa** siempre es del tamaño del tag 


- - - 
**Memoria RAM**

| TAG \| | NUMERO DE BLOQUE \| | PALABRA |
| ------ | ------------------- | ------- |
- - -
**Memoria CACHE**

| NUMERO DE BLOQUE | \| PALABRA |
| ---------------- | ---------- |
- - -
**Tabla** 

| TAG |
| --- |
- - - 
Lo que nos van a pedir es que calculemos cuantos bits tiene cada división de la memoria que esto nos lo piden como decodificacion.

### Tipo de organizacion **FULL asociativa o asociativa completa**
ahora la memoria principal la vamos a dividir en TAGS y PALABRAS y la memoria cache en NUMERO DE BLOQUE y PALABRAS 
- - -
MEMORIA PRINCIPAL 
	Teniendo el tamaño de palabra y el tamaño de total de la memoria principal podemos calcular el tamaño de tag #MP - #palabra = #Tag

| TAGS \| | PALABRA |
| ------- | ------- |
- - -
MEMORIA CACHE
	Ahora repitiendo el proceso que hicimos para calcular el tamaño del tag podemos saber el tamaño del numero de bloque

| NUMERO DE BLOQUE \| | PALABRA |
| ------------------- | ------- |
- - -
TABLA AUXILIAR

| TAG \| | BLOQUE |
| ------ | ------ |
Ahora para saber el tamaño de las direcciones que tiene la tabla solo tenemos que sumar el tamaño de tag y de bloque que calculamos anteriormente 
- - -

### Tipo de organizacion **Asociativa por conjuntos**
Tambien nos podemos encontrar con 2 set asociativa o 4 ser asociativa es lo mismo lo unico que cambia es cuantos bloques va a tomar por conjuntos
- - -

MEMORIA PRINCIPAL 

| TAG \| | SET \| | PALABRA |
| ------ | ------ | ------- |
SET: este va a ser la potencia de 2 de la cantidad de bloques que tenga el conjunto *por ejemplo si tenemos sets de dos bloques entonces solo vamos a necesitar un bit para reprecentar dos numeros*

TAG: restamos la cantidad de bits del SET y de la PALABRA al total de la memoria principal
- - -
MEMORIA CACHE

| SET \| | NUMERO DE BLOQUE \| | PALABRA |
| ------ | ------------------- | ------- |
Numero de bloque: ***ATENCION*** ahora para calcular el numero de bloque o podemos hacer una substraccion o podemos dividir el numero de bloque que habiamos calculado anteriormente con la cantidad de bloque que hay por SET osea el tamaño  de los SETS
- - -
TABLA AUXILIAR

| TAG \| | NUMERO DE BLOQUE |
| ------ | ---------------- |
|        |                  |
Para saber la longitud de la tabla solo sumamos las dos partes que anteriormente tendriamos que haber calculado 
- - -
COSAS QUE ME VOY A MECHETEAR 
### Tipos de remplazo 
- **LRU**: es cuando el mas antiguo es remplazado *y el que normalmente vamos a usar*
- **FIFO**: Es un tipo de remplazo que se comporta como la cola
### Tiempo de acceso efectivo 
![[Tiempo efectivo de acceso Cache.png]]


