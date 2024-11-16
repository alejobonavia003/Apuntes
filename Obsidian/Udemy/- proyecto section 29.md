# Idea de la web 
La idea es poder crear una pagina web que yo le marque donde estoy y me de datos sobre al temperatura y el viento 
Hay ciertos puntos de la ciudad que yo suelo concurrir, deven ser 4 mas o menos mi idea es que yo en la pagina marque en que punto estoy y me diga ademas de los datos si voy a tener viento a favor o en contra para ir a tal lugar en bici  
# Api usada: 
**openweathermap**
# APIKEY 
``` get
9eef7ba2f074dbd504e8be1fce1c0a5f
```
# Llamada a la api 
``` get
https://api.openweathermap.org/data/2.5/weather?q=Rio%20Cuarto&appid=9eef7ba2f074dbd504e8be1fce1c0a5f&units=metric&lang=es
```
https://api.openweathermap.org/data/2.5/weather?q=Rio%20Cuarto&appid=9eef7ba2f074dbd504e8be1fce1c0a5f&lang=es
https://api.openweathermap.org/data/2.5/weather?q=Rio%20Cuarto&appid=9eef7ba2f074dbd504e8be1fce1c0a5f&units=metric&lang=es
# Respuesta esperada
``` json
{
  "coord": {
    "lon": -64.3504,
    "lat": -33.1333
  },
  "weather": [
    {
      "id": 802,
      "main": "Clouds",
      "description": "nubes dispersas",
      "icon": "03d"
    }
  ],
  "main": {
    "temp": 23.4,
    "feels_like": 22.7,
    "temp_min": 22.4,
    "temp_max": 24.8,
    "pressure": 1011,
    "humidity": 60
  },
  "wind": {
    "speed": 3.6,
    "deg": 250
  },
  "clouds": {
    "all": 35
  },
  "dt": 1624586355,
  "sys": {
    "type": 1,
    "id": 8506,
    "country": "AR",
    "sunrise": 1624574289,
    "sunset": 1624620733
  },
  "timezone": -10800,
  "id": 3839819,
  "name": "Río Cuarto",
  "cod": 200
}

```

