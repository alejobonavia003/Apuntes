/*  
    NPM es una biblioteca gigante de herramientas que son proyectos de node.js 
    que podemos descargar y usar en nuestros proyectos

    NPM viene incluido con la instalacion de node.js


    // COMANDOS (bash)
    >npm init Este comando es para iniciar un nuevo proyecto que es necesario para poder descargar librerias 
    (El proyecto se creara en la ubicacion del bash al momento de cargar el comando)
    
    >npm install "nombre de paquete" sirve para instalar un paquete )
    >npm i "nombre de paquete" i es install (los pquetes estan en la pagina de npm)

||==-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    NUEVA VERCION DE NPM (ESM)
        en esta nueva vercion cambian la forma de importar paquetes y funciones para que sea mas adaptable al front end
        para ver los codigos esm o cjs de la pagina de paquetes podemos usar la opcion de la derecha para cambiar el tipo de codigo 

    COMO CAMBIAR EL ARCHIVO DE CJS A ESM
        en el archivo package.js vamos a agregar una linea de codigo. o modificarla si esta
                CJS
            type: "common.js",
                ESM
            type: "module",
    IMPORTAR LIBRERIAS 
            CJS
        const fs = require('fs'); fs es la lbreria de manejo de archivos 
            ESM
        import generateName from "sillyname"; importamos la funcion generateName(); de la libreria sillyname 

    

*/

