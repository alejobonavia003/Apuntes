*puede existir un arrglo eterogeneo con la funcion union de c.*

### Arreglos 
para que funcionen necesitamos 
- la pocicion del primer elemento 
- el tamaño de cada elemento 
- la cantidad de elementos

pocicion i en un arreglo: $$[\text{Registro base} + \text{tamaño De cada dato}+\text{registro indice}]$$

---
`lea EBX, [4 * EAX + ECX]` : *nos guarda en EBX la direccion a la que nos referimos dentro de los corchetes, LA DIRECCION QUE NOS REFERIMOS ==NO LO QUE HAY DENTRO DE ESA DIRECCION.*==

--- 
a
#### Arreglos bidimencionales 
Estos funcionan guardando una pocicion al lado de la otra de igual manera que los arreglos comunes nomas que la segunda columna va a estar en la fila de abajo 
  y asi podria ser con las dimeciones que queramos lo unico que vamos a tener que liealizar cualquier estructura y eso puede ocupar una cantidad de memoria exponencial. 
![[Filas-y.Columnas.png]]
**Luego al linealizar todos los datos vamos a tener que encontrar una forma para acceder a cada pocicion y dependiendo de cuantas dimenciones tenaga la estructura va a variar la forma de acceder a la pocicion de memoria.**

$$A[m][n] = i+(m-1)*c+(n-1)$$
Esta es la manera de acceder a una direccion de memoria trabajando con un arreglo bidimencional.

--- 

### EDI   y   ESI 
[[EDI]] y [[ESI]] son registros comunes pero los usamos para otra cosa por que tienen operaciones asociadas entre ellos que son un tanto especiales 
`rep movsb`: mueve un byte desde la direccion apuntada por [[ESI]] hasta [[EDI]] y actualiza los valores 

## Subrutinas
![[Subrutinas]]
