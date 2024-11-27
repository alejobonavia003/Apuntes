# default port: 5432
*La base de datos es como otro servidor mas pero solo para almacenar datos, por eso es necesario iniciarlo y cerrarlo cuando lo usamos*
Para trabajar con la base de datos usamos la librerias `import client from "pg"` 
![[data-bases.png]]
de esta manera iniciamos una base de datos y hacemos una consulta sobre la tabla de usuarios 
`db.query` es la forma de hacer consultas luego usamos en una funcion lamda las variables err y res para recibir tanto respuestas de la base de datos o de algun error que a ocurrido 

## Como crear un tabla 
muy similar a lo que vimos en [[SQL]]
``` sql 
CREATE TABLE friends(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	age INT,
	is_cool BOOL
)
```
`SERIAL` Es para que cuando se cree un nuevo elemento dentro de la tabla automaticamente se ponga un id que sea un numero mas grande que el que habia antes 
`VARCHAR(50)`: Es como decir que queremos una cadena de caracteres de 50 caracteres maximo pero a diferencia de `CHAR` cuando usamos menos caracteres se achica el tamaño para ser mas eficiente
`TEXTO`: es lo mismo que varchar(x) pero no necesitamos definir un limite 
`UNIQUE`: Es una propiedad para que solo se pueda cargar un valor unico 

## Relaciones de tablas 
### one to one 
![[Relacion-uno a uno.png]]
Aca relacionamos la tabla student con la contac_detail. la tabla studenst es una tabla normal y la de contacto lo que tiene es que sus id se referencian a los id de los estudiantes y son unicos por lo que el estudiante con id 1 se va a relacionar con la row que tenga id 1. 

**Pagina para diseñar base de datos graficamente:** www.draw.io 

### Many to one
![[Relacion muchos a uno.png]]

### Many to Many
```SQL
CREATE TABLE class (-- tabla de clases 

  id SERIAL PRIMARY KEY, -- columna para el id

  title VARCHAR(45) -- columna para el nombre de la clase 

);

CREATE TABLE student ( -- tabla de estudiantes

  id SERIAL PRIMARY KEY, -- columna para el id

  first_name TEXT, -- columna para nombre

  last_name TEXT -- columna para el apellido 

);

CREATE TABLE enrollment ( --tabla de inscripcion 

  student_id INTEGER REFERENCES student(id), -- columna para el id

  class_id INTEGER REFERENCES class(id), -- columna para el id

  PRIMARY KEY (student_id, class_id) -- columna para el id

);
```
Esta es una forma de relacionar muchos estudiantes con muchas clases. 

EN la tabla de inscripcion hacemos dos referencias con claves foraneas para luego generar una tupla de ID con esto logramos cubrir todos los tipos de relaciones (1,2) alumno 1 clase 2.
