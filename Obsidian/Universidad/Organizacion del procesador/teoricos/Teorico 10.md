# Memorias ROM, RAM y Memoria cache
Es una memoria que esta muy proxima al procesador y hoy en dia esta en el procesador, y tambien tenemos diferentes niveles de cache L1, L2, L3

![[memorias.png]]

Memoria RAM: es una memoria estatica mucho mas rapida pero es volatil *al perder la energia pierden los datos*.

Memoria ROM: es mas lenta que la ram pero aun *cuando pierden la electricidad persisten sus datos*

## Bit en la memoria ram
![[bit-RAM.png]]
	 estos funcionan como los [[Flips-Flops]]

## DRAM
Estas funcionan con capacitores en ves de transistores, 
![[DRAM.png]]
	El problema es que el capasitor se descarga al sacar la informacion por lo que habia que estar recargandolo por eso salio la....
## SDRAM![[SDRAM.png]]
Para que funcione tiene un clock interno que se encarga de cargar los capacitores y de ahi sale la nocion de latencia y tiempos de acceso 

**row o cas latency**: a medida que es mas chico es mas rapida y son los nanosegundos que tarda en setear un clock osea mover los datos. 

Pero esto se puede optimizar mas... *aprobechando los cambios de estados del reloj todos los cambios no solo cuando esta en uno* ![[DDR.png]]
aprobechando cada cambio de estado podemos hacer hasta el doble de operaciones. asi surgio DDR 

## Diferentes memorias y velocidades 
![[Memorias-y-velocidades.png]]

## Memoria ROM 
• **PROM (Programable ROM)**: El material conector son fusibles, el proceso de grabado (quema) los de las celdas a contener 1.
• **EPROM (Erasable Programable ROM)**: A diferencia de las PROM, tiene transistores en vez de fusibles, estos puede ser borrados y vueltos a programa mediante luz ultravioleta.
• **EEPROM (Electrical Erasable Programable ROM)**: Son memorias reprogramables con electricidad, a diferencia de las EPROM, utilizan diferentes voltajes para activar o desactivar los transistores de las celdas.
• **FLASH**: En esencia son EEPROM pero que sólo pueden ser modificados de a Páginas reduciendo la complejidad de circuitos y su costo.


# Memoria cache
• **Directa (Direct Mapping):** Cada bloque de la memoria Principal SOLO puede estar en un lugar específico en la memoria Cache.
• **Asociativa Completa (Fully Associative Mapping)**: Cada bloque de la memoria Principal puede estar en cualquier lugar en la memoria Cache.
• **Asociativa por Conjuntos (Set Associative Mapping)**: Cada bloque de la memoria Principal puede estar en cualquier lugar de un conjunto de la memoria Cache

## Memoria Cache - correspondencia DIRECTA (Direct Mapping)
Cada bloque de la memoria Principal **SOLO** puede estar **en un lugar específico en la**
**memoria Cache.**![[CACHE-DIRECTO.png]]
El problema de esto es cuando queremos correr procesos en simultaneo, como vemos en la imagen si es esta coorriendo el bloque 1 y 5 se correria uno y despues la otra a pesar de que 2 3 y 0 no esten haciendo nada, una **ventaja** es que es muy eficiente y barato 

## Memoria Cache - correspondencia ASOCIATIVA COMPLETA (Fully Associative Mapping)
Cada bloque de la memoria Principal puede estar en cualquier lugar en la memoria Cache.
![[ASOSIATIVA COMPLETA.png]]
esta es mas eficiente para correr varios procesos a la vez pero es ineficiente en el sentido de que hay que hacer una busqueda por hardware para saber que bloque esta libre 

## Memoria Cache - correspondencia ASOCIATIVA por Conjuntos (Set Associative Mapping)
Cada bloque de la memoria Principal puede estar en cualquier lugar de un conjunto de la memoria Cache![[ASOCIATIVA-Z-Cache.png]]
esto es lo mas eficiente ya que trabajamos por bloques de memoria y hay que hacer busquedas solo cada 2 bytes [[Tareas a liquidar]]

## Memoria Cache - Cómo para determinar si la dirección requerida está en Cache (Directo)
Tiene una celda por bloque que mantiene el TAG del bloque que reside actualmente. En DIRECTA, sólo se compara el TAG de la dirección con la UNICA posición donde puede estar.

## Memoria Cache - Cómo para determinar si la dirección requerida está en Cache (Asociativa Completa)
[[Tareas a liquidar]]
**Esta ta patra**

## Memoria Cache - Cómo para determinar si la dirección requerida está en Cache (Asociativa por Conjuntos)
[[Tareas a liquidar]]


## Tipos de remplazo de cache
**cuando esta lleno y hay que pedir un bloque nuevo a la RAM**

• **LRU (Least Recently Used)**: el más antiguo debe ser reemplazado.
• **FIFO (First In First Out)**: comportamiento de cola.
• **RADOM**: se elige uno aleatoriamente.

### Como se calcula el tiepo de acceso efectivo 
![[Tiempo efectivo de acceso Cache.png]]

# ***LOS TAMAÑOS DE BLOQUES SON SIEMPRE POTENCIA DE DOS***

#### Memoria Cache - Políticas de escritura
• **Write through**: cuando se modifica el valor en la memoria cache, se propaga y se modifica en la memoria principal.
• **Write back**: sólo se modifica en la memoria caché hasta que el Bloque se marcado como víctima para ser reemplazado, en ese momento se copia todo el Bloque a la memoria


**Repaso.**
la idea de cache es principio de localidad: si usamos algo lo mas probable es que lo proximo que usemos este cerca 
	Entonces la cache es una memoria muy rapida mas que la ram y esta entre la ram y el procesador entonces como hay muchas chances de que la proxima instruccion que usemos esten cercas si guardamos las instrucciones cercanas, 
	*si una memoria anda por lo gb la cache anda por los mb*


