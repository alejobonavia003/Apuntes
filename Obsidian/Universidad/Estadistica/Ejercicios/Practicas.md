##### Ejercicio1.
En una urna hay 1 bola roja, 2 azules y 3 blancas, calcular las probabilidades del evento $A=\text{sacar una bola que no sea blanca}$ 
**Experimento Aleatorio:** Sacar una bola que no sea blanca de una urna.
**Espacio muestral ($\Omega$):** $\omega=\text{[R,A,A,B,B,B]}$ 
**Evento o Suceso:** $A=\text{[R,A,A]}$ 
* La posibilidad de sacar una bola blanca es de $\frac{3}{6}$ por lo tanto la posibilidad de no sacar una bola blanca es de $1-\frac{3}{6} = \frac{1}{2}$ 

##### Ejercicio2.
en un campeonato realizado entre 10 equipos se requiere seleccionar los 2 primeros para que representen al colegio ¿permutación o combinación? 
	nos preguntamos ¿importa el orden? y en este caso no importa el orden por lo que es COMBINACION. 
No importa el orden por que formar dos grupos iguales pero con diferente orden es lo mismo ya que los dos van a representar al colegio 

equipos = [1,2,3,4,5,6,7,8,9,10] es lo mismo que [4,5] representen el colegio y que [5,4] representen el colegio SI.

##### Ejercicio3.
¿Cuántas claves de una computadora será posible diseñar si debe estar formada por 3 letras seguidas de 2 números?
	Primero nos preguntamos si importa el orden para luego poder saber si lo vamos a resolver como permutacion o como combinacion. Claramente aca importa el orden ya que si hacemos dos claves con los mismos caracteres pero con diferente orden la computadora no da acceso.

cantidad de letras = 27 
cantidad de números = 10
por principio fundamental de conteo:$$27*27*27*10*10 = 1968300$$

##### Ejercicio4.
hay 5 coches en una fila ¿de cuantas formas diferentes se pueden ordenar?
nos preguntamos si importa el orden? 
coches = [1,2,3,4,5] es lo mismo este orden que este [5,4,3,2,1]? no 
	por lo tanto SI IMPORTA EL ORDEN.

##### Ejercicio5.
si de un grupo de 6 amigo se deben seleccionar 3 para un trabajo ¿de cuantas formas diferentes se puede seleccionar ese grupo? 
	amigos  = [a,b,c,d,e,f] 
	si el grupo lo forman [a,b,c] es diferente a que lo forme [c,b,a]? NO.
		por lo tanto vamos a usar combinaciones

##### Ejercicio6.
en una heladeria ofrecen 7 sabores de helado diferentes ¿cuantas combinacuibes de helado de tre bolas puedo escojer? 
sabores = [1,2,3,4,5,6,7] ahore
	es lo mismo escojer [1,2,3] a escojer [3,2,1]? si es lo mismo por que sigo teniendo el mismo conjunto de sabores 
Usamos combinaciones por que no importa el orden. 


### **Permutación combinación o variación?** 
##### Ejercicio1. 
5 estudiantes están corriendo en 100m planos ¿de cuantas formas diferentes pueden quedar ubicados en la llegada? 

¿Importa el orden? SI --> permutación 


##### Ejercicio2. 
Andrea tiene 12 camisetas pero solo puede llevar 3 para un paseo ¿de cuantas maneras puede seleccionar las 3 camisetas? 
Importa el orden? NO por que es lo mismo en el orden que lo agarre si total van a ir todas al mismo paseo. 

--> Combinación 

### **Resolver permutaciones y combinaciones** 

[[Combinación, permutación o variación]]

##### Ejercicio 1.
de un grupo de 10 estudiantes se quiere seleccionar un comité de 3 estudiantes ¿Cuántas formas diferentes se puede seleccionar el comité? 

importa el orden? NO --> combinación  
$$\frac{n!}{r!*(n-r)!}$$
estudiantes = n = 10 
comite = r = 3
$$\frac{10!}{3!*(7!)}=120$$
El comite se puede seleccionar de 120 maneras diferentes. 

##### Ejercicio 2.
en un curso de 10 estudiantes se desea escoger presidente, vicepresidente y secretario ¿de cuantas formas se pueden seleccionar los 3 estudiantes? 

Importa el orden? Si y solo 3 van a ser seleccionados --> Variación 
$$\frac{n!}{(n-k)!}$$
n = cantidad de estudiantes = 10 
k = estudiantes seleccionados = 3
$$\frac{10!}{7!}= 720$$
los estudiantes se pueden seleccionar de 720 formas diferentes

##### Ejercicio 3.
de cuantas maneras diferentes se pueden ubicar 4 autos en la fila de un estacionamiento? 
importa el orden? Si por que dos filas ordenadas diferentes son dos cosas diferentes 
se usan todos los eventos? SI --> es una permutación. 
$$n!$$
por lo tanto $4! = 24$ hay  24 combinaciones diferentes para hacer.


##### Ejercicio 4.
en un campeonato compiten 8 equipos ¿de cuantas maneras diferentes se podrán ganar los premios de campeón y subcampeón?

Importa el orden? Si 
se usan todos los eventos? NO --> variación
$$\frac{n!}{(n-k)!}$$
8 equipos // n=8
se seleccionan 2// k=2
$$\frac{8!}{6!}=56$$
los premios de campeón y subcampeón se pueden ganar de 56 maneras diferentes.


##### Ejercicio 5.
de los 10 estudiantes de un salon debo seleccionar 4 para llevarlos a un almuerzo ¿de cuantas formas diferentes puedo seleccionar a los 4 estudiantes? 

Importa el orden? No --> combinaciones 

con remplazo o sin? SIN REMPLAZO $$\frac{n!}{k!*(n-k)!}$$
n son los 10 estudiantes // n=10
k son los 4 estudiantes seleccionados // k=4 
$$\frac{10!}{4!*6!}= 210$$
se pueden seleccionar los estudiantes de 210 formas diferentes.


##### Ejercicio 6.
en una heladeria ofrecen 7 diferentes sabores ¿cuantas combinaciones de helado de 3 bochas puedo hacer? 

importa el orden? NO --> combinaciones con remplazo $$\frac{(n+k-1)!}{(n-1)!*k!}$$
en este caso n = 7 y k = 3
$$\frac{(7+3-1)!}{(7-1)!*3!}=\frac{9!}{6!*3!}= 84 $$
puedo hacer 84 combinaciones de 3 bochas con 3 sabores.





