// Importamos librerías
import express from "express";
import axios from "axios";
import bodyParser from "body-parser";
import pg from "pg";

const app = express(); // Definimos la app
const port = 3000; // Definimos el puerto


//Nos conectamos a la base de datos
const db = new pg.Client({
  user: "postgres",
  host: "localhost",
  database: "green_db",
  password: "12345",
  port: 5432,
});
db.connect();


// Middleware para analizar el cuerpo de las solicitudes
app.use(bodyParser.urlencoded({ extended: true }));

// Carpeta pública para estilos y fotos
app.use(express.static("public"));


// Rutas
app.get("/", async (req, res) => {
    res.render("index.ejs");
});

app.get("/nuevo", async (req, res) => {
    res.render("regis.ejs");
});

app.get("/Registros", async (req, res) => {
    try {
        const { rows: datos } = await db.query("SELECT * FROM public.seguimiento_cultivo");
        // Convertir los booleanos en "Sí"/"No" y formatear la fecha
        const registros = datos.map(dato => ({
            id: dato.id,
            fecha: dato.fecha.toISOString().split('T')[0], // Convertir la fecha a formato YYYY-MM-DD
            riego: dato.riego ? 'Sí' : 'No',
            fertilizacion: dato.fertilizacion ? 'Sí' : 'No',
            anomalias: dato.anomalias || '',
            foto: dato.foto || '',
            notas: dato.notas || '',
        }));
        res.render("historial.ejs", { registros });
    } catch (err) {
        console.error("Error al obtener registros:", err);
        res.status(500).send("Error interno del servidor.");
    }
});


app.set("view engine", "ejs");

app.get("/Estadisticas", async (req, res) => {
    try {
        // Consulta a la base de datos para obtener los registros
        const resultado = await db.query("SELECT fecha, riego, fertilizacion, anomalias FROM seguimiento_cultivo");
        const registros = resultado.rows; // Array con los registros
        console.log(registros);
        // Renderizar la plantilla y pasarle los datos
        res.render("estadisticas.ejs", { registros });
    } catch (error) {
        console.error("Error al obtener los datos:", error);
        res.status(500).send("Error al obtener los datos");
    }
});

app.get("/Gastos", async (req, res) => {
    try {
        const gastos = await db.query("SELECT * FROM historial_gastos ORDER BY fecha DESC");
        res.render("gastos.ejs", { gastos: gastos.rows }); // Pasa los datos a la plantilla
    } catch (err) {
        console.error("Error al obtener los gastos:", err);
        res.status(500).send("Error del servidor");
    }
});

app.post("/newGasto", async (req, res) => {
   // const { concepto, monto, responsable, fechaGasto } = req.body;

    const concepto = req.body.concepto;
    const monto = req.body.monto;
    const responsable = req.body.responsable;
    const fechaGasto = req.body.fechaGasto;


    try {
        await db.query(
            "INSERT INTO historial_gastos (concepto, monto, responsable, fecha) VALUES ($1, $2, $3, $4)",
            [concepto, monto, responsable, fechaGasto]
        );
        res.redirect("/Gastos"); // Redirige a la página de gastos después de guardar
    } catch (err) {
        console.error("Error al agregar un gasto:", err);
        res.status(500).send("Error del servidor");
    }
});


// Ruta POST 
app.post("/enviarRegistro", async (req, res) => {
    // Recuperamos los datos
    const fecha = req.body.fecha;
    const riego = req.body.riego.toLowerCase() === "si";
    const fertilizacion = req.body.fertilizacion.toLowerCase() === "si";
    const anomalias = req.body.anomalias;
    const notas = req.body.notas;
    //const foto = req.file ? req.file.filename : null;

    console.log("Fecha:", fecha);
    console.log("Riego:", riego);
    console.log("Fertilización:", fertilizacion);
    console.log("Anomalías:", anomalias);
    console.log("Notas:", notas);

    //Guardamos todo en la base de datos
    try {
        await db.query(
          "INSERT INTO seguimiento_cultivo (fecha, riego, fertilizacion, anomalias, notas) VALUES ($1, $2, $3, $4, $5)",
          [fecha, riego, fertilizacion, anomalias, notas]
        );
        res.send(`
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Registro Exitoso</title>
                </head>
                <body>
                    <h1>Registro recibido exitosamente</h1>
                    <button onclick="window.location.href='/'">Volver al Inicio</button>
                </body>
            </html>
        `);
      } catch (err) {
        console.log(err);
      }
});

// Iniciar el servidor
app.listen(port, () => {
    console.log(`Servidor ejecutándose en http://localhost:${port}`);
});
