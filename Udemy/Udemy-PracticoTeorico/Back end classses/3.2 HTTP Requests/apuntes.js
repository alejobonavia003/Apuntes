/*
1. GET
Descripción:    Solicita la representación de un recurso específico. Las peticiones que usan el método GET solo deben recuperar datos.
Uso:            Obtener información de un servidor, como una página web o datos JSON.
Ejemplo:        GET /users obtiene una lista de usuarios.
|--------------------------------------------------------------------------------------------------------------------------------------------------|

2. POST
Descripción:    Envía datos al servidor para crear un nuevo recurso. Los datos se envían en el cuerpo de la solicitud.
Uso:            Crear un nuevo recurso, como un nuevo usuario en una base de datos.
Ejemplo:        POST /users crea un nuevo usuario con los datos proporcionados en el cuerpo de la solicitud.
|--------------------------------------------------------------------------------------------------------------------------------------------------|

3. PUT
Descripción:    Reemplaza un recurso existente con los datos enviados. Si el recurso no existe, puede crearlo.
Uso:            Actualizar un recurso existente o crear uno nuevo si no existe.
Ejemplo:        PUT /users/1 actualiza el usuario con ID 1 con los nuevos datos proporcionados.
|--------------------------------------------------------------------------------------------------------------------------------------------------|

4. PATCH
Descripción:    Aplica modificaciones parciales a un recurso. A diferencia de PUT, que reemplaza el recurso completo, PATCH solo cambia partes del recurso.
Uso:            Actualizar parcialmente un recurso existente.
Ejemplo:        PATCH /users/1 actualiza solo algunos campos del usuario con ID 1.
|--------------------------------------------------------------------------------------------------------------------------------------------------|

5. DELETE
Descripción:    Elimina un recurso específico.
Uso:            Eliminar un recurso del servidor.
Ejemplo:        DELETE /users/1 elimina el usuario con ID 1.
|--------------------------------------------------------------------------------------------------------------------------------------------------|

Ejemplo práctico en una API RESTful
Supongamos que tienes una API para gestionar usuarios, aquí tienes ejemplos de cómo se usarían estos métodos:

GET: Para obtener la lista de todos los usuarios.
En consola
GET /api/users
|--------------------------------------------------------------------------------------------------------------------------------------------------|

GET (individual): Para obtener los detalles de un usuario específico.
En consola
GET /api/users/1
|--------------------------------------------------------------------------------------------------------------------------------------------------|

POST: Para crear un nuevo usuario.
En consola
POST /api/users
{
  "name": "John Doe",
  "email": "john@example.com"
}
|--------------------------------------------------------------------------------------------------------------------------------------------------|

PUT: Para actualizar completamente un usuario existente.
En consola
PUT /api/users/1
{
  "name": "Jane Doe",
  "email": "jane@example.com"
}
|--------------------------------------------------------------------------------------------------------------------------------------------------|

PATCH: Para actualizar parcialmente un usuario existente.
En consola
PATCH /api/users/1
{
  "email": "newemail@example.com"
}
|--------------------------------------------------------------------------------------------------------------------------------------------------|

DELETE: Para eliminar un usuario.
En consola
DELETE /api/users/1
Estos métodos son fundamentales en el desarrollo de aplicaciones web y APIs RESTful. 
Entender cómo y cuándo utilizarlos es clave para diseñar y consumir APIs de manera efectiva.
|--------------------------------------------------------------------------------------------------------------------------------------------------|

 */

// NODEMON: ES UNA LIBRERIA QUE CADA VEZ QUE GUARDO EL ARCHIVO ACTUALIZA EL SERVIDOR PARA NO TENER QUE ESTAR APAGANDO Y PRENDIENDO EL SERVIDOR TODO EL TIEMPO 

/*
COMO INSTALARLO:
        npm i -g nodemon 

SI NO TE DEJA EJECUTAR EL SCRIPT DALE PERMISOS DE ADMINISTRADOR CON : 
        Set-ExecutionPolicy RemoteSigned -Scope CurrentUser

*/