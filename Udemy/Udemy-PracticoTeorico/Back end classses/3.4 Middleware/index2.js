/*
COMO USAR MORGAN
*/
import express from "express";
import morgan from "morgan";

const app = express();
const port = 3000;
// morgan es una libreria que podemos usar para rescatar datos diferentes como el tiempo de ejecucion entre otros
//app.use(morgan("tiny"));
//app.use(morgan(':method :url :status :res[content-length] - :response-time ms'));
app.use(morgan(function (tokens, req, res) {
  return [
    tokens.method(req, res),
    tokens.url(req, res),
    tokens.status(req, res),
    tokens.res(req, res, 'content-length'), '-',
    tokens['response-time'](req, res), 'ms'
  ].join(' ')
}));
//estas 3 formas de usar morgan son lo mismo es decir a diferentes formas de especificar que informacion queremos 
// es mejor buscar informacion en internet sobre la informacion que querramos recolectar 

app.get("/", (req, res) => {
  res.send("Hello");
});

app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});
