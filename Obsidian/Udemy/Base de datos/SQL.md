sql es un lenguaje de programacion nuevo que trabaja con estructura de datos especificamente con tablas donde vamos a almacenar la informacion, esto nos permite dar una estructura a todos los datos que almacenemos y ademas el mismo lenguaje nos permite trabajar sobre ellas, 
- Crear tablas (**C**reate)
- Escribir tablas (**R**ead)
- Actualizar tablas (**U**pdate)
- eliminar informacion (**D**estroy)
**CRUD**

## Create

Como crear una tabla asi: 

| Productos |        |        |
| --------- | ------ | ------ |
| ID        | nombre | precio |
| 1         | pc     | 1000   |
``` sql
CREATE TABLE productos (
ID int not null 
name STRING 
price MONEY
PRIMARY KEY (ID)
)
```

Las primeras palabras pertenecen a los nompres y la segunda palabra pertenece a los tipos de datos que tiene SQL ahora sql tiene miles de tipos de datos que se usan comunmente por eso es que hay que mirar bien la documentacion para saber que es mejor usar [[Documentaciones]]

`PRIMARY KEY (ID) `: se refiere a que esta tabla va a usar como ID para identificarce lo que tenga almacenado en ID

**Como insertamos valores a la tabla**
``` SQL
INSERT INTO _table_name_ (_column1_, _column2_, _column3_, ...)  
VALUES (_value1_, _value2_, _value3_, ...);
``` 
De esta manera insertamos valores a la tabla en columnas especificas 

Para insertar todos los valores que hay a una tabla usamos solo el nombre 
``` SQL
INSERT INTO _table_name_ 
VALUES ... 
```


## Read 
``` SQL 
SELECT * FROM name_the_table_
```
Esto nos mostrara toda la tabla `name_the_table_` 

**Si quisieramos ver una parte especifica de la tabla** 
``` SQL 
SELECT name, price FROM name_the_table_
```
Nos mostraria solo las columnas nombre y precio de la `tabla name_the_table_` 

**Si quisieramos ver una columna especifica con tal ID**
``` SQL 
SELECT * FROM name_the_table_ WHERE condition
```
Nos mostraria toda la tabla `name_the_table_` que tengan tal condicion 

## Update
Como Actualizamos o agregamos un valor a una columna 
``` SQL
UPDATE name_the_table_ SET price=2.50 WHERE id=2 
```
Actualiza en la tabla `name_the_table_` la columna precio a 2 especificamente en la fila que tiene id igual a 2

**Como insertar elementos a la tabla**
``` SQL
insert into products (id,name,price) select 2, 'pencil', 0.8  
```
Inserta una fila en la tabla products completando los campos id, name, price }

**Como agregamos una nueva columna**
``` SQL
ALTER TABLE name_the_table_ ADD stock INT 
```
Agregamos una nueva columna a la tabla llamada stock y que almacena datos de tipo entero 

## Delete
``` SQL
DELETE FROM products WHERE id=2;
```
Elimina la columna con id 2 de la tabla productos 

# Claves foraneas (SQL FOREIGN KEY)
Estas claves las usamos para relacionar tablas entre si por ejemplo:
	si tenemos una tabla de productos, una de personas y una de pedidos, en la tabla de pedidos se ve a relacionar el pedido con una persona y con un producto 

**Ejemplo:**
``` SQL
create table orders(
  id int not null,
  order_number int,
  customer_id int,
  product_id int,
  primary key (id),
  FOREIGN key (customer_id) REFERENCES customers(id),
  FOREIGN key (product_id) REFERENCES products(id)
)
```
Creamos una tabla de ordenes que relaciona los numeros de orden con un cliente y con un producto 

**Como unir tablas a partir de las claves foraneas**
``` SQL
select orders.order_number, customers.first_name, customers.last_name, customers.address
from orders 
inner JOIN customers on orders.customer_id = customers.id
```
Esto crea una tabla nueva pero teniendo en cuenta la clave forence 
- Luego de `select` ponemos los campos que vamos a usar en la nueva tabla
- Luego de `from` ponemos de donde vamos a sacar las claves forences 
- Luego de `inner join` ponemos en que tabla aplican esas claves forences
- Luego den `on` decimos tal columna es un id de otra tabla por ejemplo: 
  `on orders.customer_id = customers.id` de la tabla de ordenes customers_id es el id del ckliente que hizo la orden y en la tabla customers el campo id es el que tiene la informacion de ese cliente
   
**Como relacionamos las tres taablas cliente, pedido, producto**
``` SQL
select orders.order_number, customers.first_name, customers.last_name, customers.address, products.name
from ((orders 
inner JOIN customers on orders.customer_id = customers.id)
INNER join products on orders.product_id = products.id)
```
De esta manera creamos una nueva tabla que es mucho mejor por que ya no vemos numeros de id sino que numero de pedidos relacionado con un cliente que hizo la compra y con un producto que compro 


