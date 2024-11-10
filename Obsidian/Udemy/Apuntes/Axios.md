axios es una popular biblioteca de JavaScript utilizada para hacer solicitudes `HTTP` desde el navegador o desde Node.js. Es muy útil para interactuar con APIs, ya que permite enviar y recibir datos de forma sencilla. Con axios, puedes realizar operaciones como `GET, POST, PUT, DELETE` y otras solicitudes `HTTP`.

## Ejemplos de uso (get, post)
``` js
const axios = require('axios');

axios.get('https://jsonplaceholder.typicode.com/posts')
  .then(response => {
    console.log(response.data); // Muestra los datos de respuesta
  })
  .catch(error => {
    console.error('Error en la solicitud:', error);
  });

```

``` js
axios.post('https://jsonplaceholder.typicode.com/posts', {
    title: 'Nuevo Post',
    body: 'Contenido del post',
    userId: 1
  })
  .then(response => {
    console.log(response.data); // Muestra los datos de respuesta
  })
  .catch(error => {
    console.error('Error en la solicitud:', error);
  });

```

