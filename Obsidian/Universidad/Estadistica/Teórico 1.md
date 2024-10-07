
**Experimento Aleatorio:** Son aquellos experimentos en los que no se puede predecir su resultado. Lanzar una moneda, tirar un dado, seleccionar una carta de un mazo.
**Espacio muestral ($\Omega$):** Es el conjunto de todos los resultados posibles de un *Experimento Aleatorio*.  
**Evento o Suceso:** uno o varios de los posibles resultados.
[[Ejemplo 1.]]

# Técnicas de conteo 

 **Regla de la multiplicación:** 
  Si un evento $A$ puede ocurrir de $m$ maneras diferentes y un evento $B$ puede ocurrir de $n$ maneras diferentes.
  
  **Entonces el numero total de formas en  que ambos pueden ocurrir es de $m * n$ maneras**
  
  EJEMPLO: si tiráramos un dado y una moneda a la vez y quisiéramos saber con cuantas combinaciones diferentes pueden caer usamos Regla de la multiplicación $6*2 = 12$
  
  ==Importante== Si los eventos pueden ocurrir al mismo tiempo **Multiplicamos** y si solo puede ocurrir un evento a la vez **Sumamos**. 
	  si tiramos un dado y una moneda estos pueden tocar simultáneamente pero si tuviéramos que elegir en que ir a la uní y tenemos 2 ubres y 3 colectivos solo tenemos 3 + 2 posibilidades por que no podemos ir en Uber y bondi a la vez
	[[ejercicio de patente con dos letras y un numero]]

**Como saber si si importa el orden.** 
 **Hacer dos combinaciones diferentes con los mismos elementos ¿SON DIFERENTES?**
	   SI = permutación 
       NO = combinación.
    EJEMPLO: Tenemos 5 estudiantes y tenemos que elegir presidente y vicepresidente
	 *hacemos dos combinaciones diferentes con los mismos estudiantes 1 y 4 ahora
	 ¿Es lo mismo que 1 sea presidente y 4 vicepresidente a que 4 sea presidente y 1 vicepresidente?*  OBVIO NOO por lo tanto importa el orden. PERMUTACION.

**Combinatoria:** formas de ordenar un determinado numero de elementos.
    **Como reconocer el tipo de combinatoria:**(con o sin remplazo).
    Tenemos que encontrar 4 datos.
    1. Conjunto de todos los posibles eventos.    
    2. Muestra (eventos que nos importan)          
    3. ¿Importa el orden? 
    4. ¿Se pueden repetir? 


**Permutaciones y combinaciones:**
![[WhatsApp Image 2024-09-11 at 6.26.02 PM.jpeg]]
**Combinación, permutación ?** Sirven para encontrar en numero de elementos del espacio muestral. 


- Permutación --> *Si importa el orden y NO se usan todos los elementos *
  - Permutaciones sin remplazo:$$\frac{n!}{(n-r)!}$$
  - permutaciones con remplazo: $$n^k$$
- Permutación --> *Si importa el orden y SI se usan todos los elementos.*
  - $$ n!$$

- Combinación --> *No importa el orden.*
- Sin remplazo:$$\frac{n!}{r!*(n-r)!}$$
- Con remplazo: $$\frac{(n+k-1)!}{(n-1)!*k!}$$
## Probabilidad Condicional: 

$$P(A|B)=\text{Probabilidad de que suceda A si ya ocurrio B}$$

resumen: *si tenemos dos conjuntos de eventos que se intersecan en n puntos es la probabilidad de que suceda esa intercesión.*
ejemplos.
- cual es la probabilidad de que sea blanco, **si** se selecciono un perro.
- **Si** se selecciono un perro cual es la probabilidad de que sea blanco.
- le gustan las matemáticas dado que le gusta ingles.
Lo podemos reconocer cuando se habla de un conjunto y se da una condición previa al conjunto, y esta condición probablemente forme otro conjunto y siempre la probabilidad condicional va a ser su intersección sobre la totalidad de casos.
$$\text{probabilidad de que a los que le sucedio B les suceta tamnien A}=P(A|B)=\frac{P(A\cap B)}{P(B)}$$
$$\frac{P(A\cap B)}{P(B)}$$
## Ley de probabilidad total
La usamos cundo los eventos sin independientes. cuando nos dicen la probabilidad de que salgan eventos seguidos uno del otro y independientes entre si, 

Nos preguntamos es con o sin remplazo? 
- **Con remplazo:** hago el diagrama de árbol poniendo todos los sucesos y la posibilidad de que suceda cada uno, y de cada suceso(nodo) desprendo lo que falte para completar el evento pueden ser mas posibles sucesos o podemos llegar al evento
	 luego  multiplicamos la posibilidad de cada suceso recorriendo la rama y asi con cada rama que requiera el evento.
	  luego sumamos el valor que nos dio cada rama![[ley de probabilidad total con remplazo.png]]
- **Sin remplazo:** hago el diagrama de arbol pero por cada nodo nuevo osea suceso que se desprende de otro le restamos uno a la cantidad de casos totales por que logicamente ya no esta por ser sin remplazo.![[ley de probabilidad total sin remplazo.png]]

