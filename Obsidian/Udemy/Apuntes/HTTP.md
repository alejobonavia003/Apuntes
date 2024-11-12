# protocolo de transferencia de hipertexto 
Es un lenguaje que permite cominicar el servidor con el cliente o el programador.
	basicamente es para enviar o recibir textos o imagenes a traves de urls cada peticion se hace enviando una url y recibiendolo en un codigo 

#### Tipos de peticiones 
- `Get` : Se utiliza para solicitar informacion al servidor. La solicitud de datos se hace atravez de la url 
- `Post` : Se utiliza para enviar datos al servidor. A diferencia de `GET`, en `POST` los datos se envían en el cuerpo, no en la URL, lo cual permite enviar grandes volúmenes de información, como formularios complejos, archivos o JSON.
- `put` : Este metodo lo usamos para actulizar datos del servidor, tambien se podria crear un recurso pero para esto generalmente se usa `post` 
  **Como funciona**: Generalmente le pasamos a traves  de la url cual dato vamos a querer actualizar del servidor y en el cuerpo de pasamos los datos por los cuales vamos a actualizar. 
- `patch` : Como la palabra lo dice es un parche y lo usamos para hacer una modificacion parcial, **Funciona** de la misma manera que post pero en vez de enviar el cuerpo completo solo enviamos lo que queremos actualizar, es util para hacer mas eficientes las cosas 
- `delete` : Lo usamos cuando queremos eliminar un recurso del servidor **funciona** solo con mandarle a travez de la url que recurso se quiere eliminar 

