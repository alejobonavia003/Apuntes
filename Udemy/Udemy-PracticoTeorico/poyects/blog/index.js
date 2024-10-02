//incluyo librerias necesarias
import express from "express";
import bodyParser from "body-parser";
import methodOverride from 'method-override';

//defino un puerto para que se conecte a mi oredenador
const port = 3000;
const app = express();
var posts = [{titulo:"A lo Vivo", content:"Era un pueblecito rayano, Ribamoura, vivero de contrabandistas, donde esta profesión de riesgo y lucro hacía a la gente menos dormida de lo que suelen ser los pueblerinos. Abundaban los mozos de cabeza caliente, y se desdeñaba al que no era capaz de coger una escopeta y salir a la ganancia.Las mujeres, vestidas y adornadas con lo que da de sí el contrabando, lucían pendientes de ostentosa filigrana, patenas fastuosas, pañuelos de seda de colorines; en las casas no faltaba ron jamaiqueño ni queso de Flandes, y los hombres poseían armas inglesas, bolsas de piel y tabaco Virginia y Macuba. Al través de Portugal, Inglaterra enviaba sus productos, y de España pasaban otros, cruzando el caudaloso río.Algunos días del año se interrumpía el tráfico y la industria de Ribamoura. El pueblo entero se congregaba a celebrar las solemnidades consuetudinarias, que servían de pretexto para solaces y holgorio. Tal ocurría con el Carnaval, tal con la fiesta de la Patrona, tal con los días de la Semana Santa. A pesar de ser éstos de penitencia y mortificación, para los de Ribamoura tenían carácter de fiesta; en ellos se celebraba, en la iglesia principal, espacioso edificio de la época herreriana, la representación de la Pasión, con personajes de carne y hueso, y encargándose de los papeles gente del pueblo mismo.Venido de Oporto, un actor portugués, con el instinto dramático de la raza, organizaba y dirigía la representación; pero sin tomar parte en ella. Esto se hubiese considerado en Ribamoura irreverente. «Trabajaban» por devoción y por respeto tradicional a los misterios redentores; pero nunca hubiesen admitido a nadie mercenario, ni tolerado que hiciese los papeles nadie de mala reputación. Gente honrada, aunque contrabandease; que eso no deshonra. Ni por pecado lo daban en el confesionario los frailes.", fecha:"16/61/2024:14hs", id:generateUUID()}];
//var posts = [];

//uso el bodi parser para tener acceso al cuerpo de mi html 
app.use(bodyParser.urlencoded({extended : true}));
app.use(express.static("public"));//incluyo cosas estaticcd as como fotos o estilos 
app.use(methodOverride('_method'));
var alejo = 's';
console.log(typeof alejo);
// homePage
app.get("/", (req, res) => {
    res.render("index.ejs", {feed : posts, title:"Inicio"});
});
app.get("/nueva-publicacion", (req, res) => {
    res.render("index.ejs", {nueva : true, title:"Nueva publicacion"});
});
app.get("/acerca-de", (req, res) => {
    res.render("index.ejs", {acercaDe : true, title:"Informacion"});
});
app.post('/submit', (req, res) => {
    posts.push({
     titulo: req.body.titulo1,
     content:  req.body.publishContent,
     fecha:  new Date().getDate()+"/"+(new Date().getMonth())+"/" +new Date().getFullYear()+":"+new Date().getHours()+"hs",
     id : generateUUID(),  
    });   
    res.render('index.ejs', {feed : posts, title: 'Inicio'});
});

app.patch('/posts/:id', (req, res) => {
    const { titulo, content } = req.body;
    var i = 0;
    while(posts[i].id != req.params.id){//me posiciono en el elemento que voy a eliminar
        i++;
    }

      console.log(titulo);
      console.log(content);

      posts[i].titulo = titulo;
      posts[i].content = content;
    
      res.render('index.ejs', {feed : posts, title: 'Inicio'});
  });
  
  app.delete('/posts/:id', (req, res) => {
    // Lógica para eliminar la publicación
    var i = 0;
    while(posts[i].id !== req.params.id){//me posiciono en el elemento que voy a eliminar
        i++;
    }
    posts.splice(posts[i].id, 1);//elimino el elemento en tal pocicion 
    res.render('index.ejs', {feed : posts, title: 'Inicio'});
  });


//dejo abierto un escuchador para que se conecte
app.listen(port, ()=> {
    console.log("se establecio la coneccion en el port "+port);
});



//FUNCION PARA GENERAR ID ALEATORIOS
function generateUUID() {
    var d = new Date().getTime();
    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random() * 16) % 16 | 0;
        d = Math.floor(d / 16);
        return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    });
    return uuid;
}