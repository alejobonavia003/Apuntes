Usando la libreria **dotenv**. 
```js
import env from "dotenv";
```
creamos un archivo .env donde definimos todas nuestras variables locales.

luego lo configuramos para que el codigo lo vea, tan facil como agregar:
``` js
env.config();
```

luego llamamos esas variables locales con la funcion process.env.variableelejida; 

por ejemplo:
si tenemos la variable 
```js
SESSION_SECRET="TOPSECRETWORD"
```

la usamos :
``` js
app.use(
session({
secret: process.env.SESSION_SECRET,
resave: false,
saveUninitialized: true,
}));
```

