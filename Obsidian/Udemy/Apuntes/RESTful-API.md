# Reglas para que una api sea RESTful
1. cumplir con [[HTTP]] standar: esto significa que debe poder usarse con los metodos GET, POST, PUT, PATCH, DELETE. en sentido si tenemos que pedir algo al servidor lo pedimos con GET, si queremos eliminar algo lo hacemos con el metodo POST, ETC......
2. deberá tener un formato estandar para sus respuestas puede ser un archivo [[JSON]]
3. Los clientes  y los servidores de la api deberán estar separados, incluso en archivos separados, esto es para que pueda ser completamente escalable.
4. Stateles: Cada solicitud del cliente al servidor debe contener toda la informacion necesaria para que la api pueda trabajar por si sola.
5. Identificador unico de recursos, osea a travez de la url debemos poder identificar los recursos de la api 


## Como recibir peticiones EndPoint 
Ejemplo: http://localhost:3000/filter?type=Puns hacen una peticion get a nuestra api con esa url. 
	Entonces nosotros por adentro la recibimos y almacenamos sus parametros 
``` js
app.get('/filter', (req, res) => {
  // Acceder al parámetro 'type' de la query string
  const type = req.query.type;

  // Enviar una respuesta o procesar el parámetro
  res.json({ type }); // Responde con el valor del parámetro
});
```

