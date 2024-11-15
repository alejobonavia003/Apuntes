// immportamos librerias que vamos a usar 
import express from "express";
import axios from "axios";
import bodyParser from "body-parser";


const app = express();//definimos la app 
const port = 3000;//definimos el puerto 
const API_URL = "https://api.openweathermap.org/data/2.5/weather";//definiimos el linnk de la api
const API_KEY = "9eef7ba2f074dbd504e8be1fce1c0a5f";//definimos el token 

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("public")); //añado la carpeta public donde voy a alojar los stilos y las fotos 

app.get("/", async (req, res) => {
try{
const datos = await axios.get(API_URL+"?q=Rio%20Cuarto&appid="+API_KEY+"&units=metric&lang=es");
const viento = direccionDelViento(datos.data.wind.deg);
res.render("index.ejs", {datosMeteorologicos: datos.data, direcciondelviento: viento });
} catch (error) {
res.render("index.ejs",{datos: JSON.stringify(error.response.data)});
}
});

app.post("/", async (req, res) => {
    try {
    const datos = await axios.get(API_URL+"?q=Rio%20Cuarto&appid="+API_KEY+"&units=metric&lang=es");
    const deg = datos.data.wind.deg;
    const viento = direccionDelViento(datos.data.wind.deg);

    const origen = (req.body.origen);
    const destino = (req.body.destino);

    let resultado = "indefinido";

    if (origen == "centro" && destino == "universidad"){
        if((deg >= 337.5 && deg < 360) || (deg >= 0 && deg < 22.5) || (deg >= 247.5 && deg < 292.5) || (deg >= 292.5 && deg < 337.5)){
            resultado = "viento a favor";
        } else  {
            resultado = "viento en contra";
        }
    }else if(origen == "universidad" && destino == "centro"){
        if((deg >= 67.5 && deg < 112.5) || (deg >= 112.5 && deg < 157.5) || (deg >= 157.5 && deg < 202.5)){
            resultado = "viento a favor";
        }else{
            resultado = "viento en contra";
        }
    }else {
        resultado = "no entiendo";
    }
    res.render("index.ejs", {fOnf: resultado, datosMeteorologicos: datos.data, direcciondelviento: viento});
}catch(error) {
    res.render("index.ejs",{datos: JSON.stringify(error.response.data)});
}
});


app.listen(port, () => {
    console.log(`Corriendo en el puerto: ${port}`);
});


function direccionDelViento(deg) {
if ((deg >= 337.5 && deg < 360) || (deg >= 0 && deg < 22.5)) return "Norte";
if (deg >= 22.5 && deg < 67.5) return "Noreste";
if (deg >= 67.5 && deg < 112.5) return "Este";//
if (deg >= 112.5 && deg < 157.5) return "Sureste";//
if (deg >= 157.5 && deg < 202.5) return "Sur";//
if (deg >= 202.5 && deg < 247.5) return "Suroeste";
if (deg >= 247.5 && deg < 292.5) return "Oeste";
if (deg >= 292.5 && deg < 337.5) return "Noroeste";

}