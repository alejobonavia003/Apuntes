es lo que esperamos por mucho tiempo 

### Librerias 
``` js
import React from "react";
import ReactDOM from "react-dom";
```

### Funciones usadas.
``` js
 ReactDOM.render("html a insertar", "donde insertarlo");
 ejemplo:
 ReactDOM.render(
  <div>
    <h1>Ultimas 3 comidas</h1>
    <ul>
      <li>Garrapiñada</li>
      <li>masitas de arroz</li>
      <li>hamburgesas</li>
    </ul>
  </div>,
  document.getElementById("root")
);
```



### Estilos en lineas de React
En html usabamos la propiedad`style="color: red"` pero en JDX esto hay que verlo como lo que es OBJETOS en css las propiedades son como objetos

entonces definimos un objeto con las propiedades que requeramos: 
``` js
const customStyle = {}
  color: "red",
  fontSize: "20px"
};
ReactDOM.render(<h1 style={customStyle}>Hello World!</h1>, document.getElementById("root"));
```

al definir un estilo dentro de un objeto despues podemos usar las propiedades de ese objeto para modificar el estillo en tiempo de procceso. 

``` js
	customStyle.color = "blue";
```

con solo hacer eso ya podriamos pasar a tener otra propuiedad de estilo en tiempo real 

# Modularizacion 
creando una funcion que su nombre enmpieze con una mayuscula hacemos que react interprete que puede retornar un elemnto html 

``` js
function Heading(){
return <h1>titulo</h1>;
}
```
aca no solo creamos una funcion sino que tambien un componente react

ahora si lo quisieramos usar en .render por ej:
```js
ReactDOM.render(
<Heading></Heading>,
document.getElementById("root");
);
```
En donde usamos Heading estamos llamado el nuevo componente que creamos 
**Diferenciamos los componentes que creamos nosotros de los que ya existe con una mayuscula al inicio.**

## Como modularizar desde otro archivo 
en el caso del ejemplo pasamos la funcion Heading a otro archivo.JSX y le agregamos export default Heading;

``` js
function Heading(){
return <h1>titulo</h1>;
}

export default Heading; 
```

y luego para recibirlo en index.js importamos Heading de "./heading.jsx"
```js
import Heading from "./Heading";
```

calificacion: "";


