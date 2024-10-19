es un registro que lo vamos a usar para saber donde esta la base de la pila. 

lo usamos como guia de la base o medio entre los parametros y las variables locales 
	*entonces si le sumamos al EBP estamos viendo los parametros y si le restamos estamos viendo las variables locales* 
Peroooo para ver el primer parametro tenemos que sumar 8 por que si sumamos 4 estamos viendo el [[EIP]] que es el registro de direccion de retorno  

Graficamente lo vemos asi:

| Codigo programa      | codigo del programa | memoria |
| -------------------- | ------------------- | ------- |
| Datos estaticos      | datos estaticos     | memoria |
| pila sin usar        | pila                | memoria |
| variables locales    | pila                | memoria |
| ebp viejo            | pila                | memoria |
| direccion de retorno | pila                | memoria |
| parametros           | pila                | memoria |

```c
+-----------------+        
|   Variable Local 1 |      <-- [EBP + 8]
+-----------------+
|   Variable Local 2 |  
+-----------------+
|   Dirección de Retorno |  <-- [EBP + 4]
+-----------------+
|   EBP Anterior  |       <-- EBP
+-----------------+
|   Primer Parámetro  |     <-- [EBP - 4]
+-----------------+
|   Segundo Parámetro |     <-- [EBP - 8]
+-----------------+

```

