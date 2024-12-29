// Importamos librerías
import express from "express";
import axios from "axios";
import bodyParser from "body-parser";
import multer from "multer";
import path from "path";

const app = express(); // Definimos la app
const port = 3000; // Definimos el puerto

// Middleware para analizar el cuerpo de las solicitudes
app.use(bodyParser.urlencoded({ extended: true }));

// Carpeta pública para estilos y fotos
app.use(express.static("public"));

// Configuración del almacenamiento de `multer`
const storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, "uploads/"); // Carpeta donde se guardarán los archivos
    },
    filename: function (req, file, cb) {
        cb(null, Date.now() + path.extname(file.originalname)); // Nombre único para cada archivo
    },
});

const upload = multer({ storage });

// Rutas
app.get("/", async (req, res) => {
    res.render("index.ejs");
});

app.get("/nuevo", async (req, res) => {
    res.render("regis.ejs");
});

app.get("/Registros", async (req, res) => {
    res.render("historial.ejs");
});

app.get("/estadisticas", async (req, res) => {
    res.render("estadisticas.ejs");
});

app.get("/Gastos", async (req, res) => {
    res.render("gastos.ejs");
});

// Ruta POST con `multer`
app.post("/enviarRegistro", upload.single("foto"), async (req, res) => {
    /* Recuperamos los datos
    const fecha = req.body.fecha;
    const riego = req.body.riego;
    const fertilizacion = req.body.fertilizacion;
    const anomalias = req.body.anomalias;
    const notas = req.body.notas;
    const foto = req.file ? req.file.filename : null;

    console.log("Fecha:", fecha);
    console.log("Riego:", riego);
    console.log("Fertilización:", fertilizacion);
    console.log("Anomalías:", anomalias);
    console.log("Notas:", notas);
    console.log("Foto:", foto);
*/
console.log(req.body);
    // Enviar respuesta al cliente
    res.send("Registro recibido exitosamente.");
});

// Iniciar el servidor
app.listen(port, () => {
    console.log(`Servidor ejecutándose en http://localhost:${port}`);
});
