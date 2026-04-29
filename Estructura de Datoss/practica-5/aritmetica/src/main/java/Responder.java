import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.Random;

//manejo de archivos 
import java.io.File;
import java.util.Scanner;



public class Responder
{
    // Used to map key words to responses.
    private HashMap<String, String> responseMap;
    // Default responses to use if we don't recognise a word.
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;
    private HashMap<String, HashSet<String>> sinonimosMap;
    private String archivo = "src/main/java/DefaultResponse.txt";

    /**
     * @post Construct a Responder.
     */
    public Responder()
    {
        responseMap = new HashMap<>();
        sinonimosMap = new HashMap<>();
        fillResponseMap();
        defaultResponses = new ArrayList<>();
        fillDefaultResponses();
        randomGenerator = new Random();

    }

    /**
     * @post Generate a response based on the provided 'words'.
     *   If none of the words can be matched to an appropriate 
     *   response, generate a random response.
     */
    public String generateResponse(HashSet<String> words)
    {


        System.out.println("------------< Generando Respuesta >------------");
        for (String word : words) {
            String response = responseMap.get(word);
            if (response == null){
                //buscar si la palabra esta dentro de un sinonimo 
                if (responseMap.get(getSinonimos(word)) != null){
                    response = responseMap.get(getSinonimos(word));
                    System.out.println("------------< Respuesta por sinónimos >------------");
                    return response;
                }
            }else{
                System.out.println("------------< Respuesta sin ver sinonimos >------------");
                return response;
            }
        }
        return pickBrainResponse(words);
    }

    /**
     * @post Introducir todas las palabras clave conocidas y sus respuestas asociadas
     * en nuestro mapa de respuestas.
     */
    private void fillResponseMap()
    {
        responseMap.put("crash", 
                        "Bueno, nunca se bloquea en nuestro sistema. Debe tener algo\n" +
                        "que ver con tu sistema. Cuéntame más sobre tu configuración.");
        setSinonimos("crasheo fallo error", "crash");

        responseMap.put("slow", 
                        "Creo que esto tiene que ver con tu hardware. Actualizar tu procesador\n" +
                        "debería resolver todos los problemas de rendimiento. ¿Tienes algún\n" +
                        "problema con nuestro software?");
        setSinonimos("lento despacio retraso", "slow");

        responseMap.put("performance", 
                        "El rendimiento fue bastante adecuado en todas nuestras pruebas. ¿Estás\n" +
                        "ejecutando otros procesos en segundo plano?");
        setSinonimos("rendimiento eficiencia velocidad", "performance");

        responseMap.put("bug", 
                        "Bueno, ya sabes, todo software tiene algunos errores. Pero      nuestros\n" +
                        "ingenieros de software están trabajando muy duro para solucionarlos.\n" +
                        "¿Puedes describir el problema un poco más?");
        setSinonimos("error fallo defecto", "bug");

        responseMap.put("windows", 
                        "Este es un error conocido relacionado con el sistema operativo Windows.\n" +
                        "Por favor, repórtalo a Microsoft. No hay nada que podamos hacer al respecto.");
        setSinonimos("ventanas sistema operativo microsoft", "windows");

        responseMap.put("mac", 
                        "Este es un error conocido relacionado con el sistema operativo Mac.\n" +
                        "Por favor, repórtalo a Apple. No hay nada que podamos hacer al respecto.");
        setSinonimos("apple sistema operativo macos", "mac");

        responseMap.put("expensive", 
                        "El costo de nuestro producto es bastante competitivo. ¿Has comparado\n" +
                        "nuestras características con las de otros productos?");
        setSinonimos("caro costoso elevado", "expensive");

        responseMap.put("installation", 
                        "La instalación es realmente muy sencilla. Tenemos muchos asistentes\n" +
                        "que hacen todo el trabajo por ti. ¿Has leído las instrucciones de instalación?");
        setSinonimos("instalación configurar montar", "installation");

        responseMap.put("memory", 
                        "Si lees los requisitos del sistema cuidadosamente, verás que los\n" +
                        "requisitos de memoria especificados son de 1.5 gigabytes. Realmente\n" +
                        "deberías actualizar tu memoria. ¿Algo más que quieras saber?");
        setSinonimos("memoria ram almacenamiento", "memory");

        responseMap.put("linux", 
                        "Nos tomamos muy en serio el soporte para Linux. Pero hay algunos problemas.\n" +
                        "La mayoría tienen que ver con versiones incompatibles de glibc. ¿Puedes ser\n" +
                        "un poco más preciso?");
        setSinonimos("gnu sistema operativo kernel", "linux");

        responseMap.put("bluej", 
                        "Ahhh, BlueJ, sí. Intentamos comprar a esos chicos hace tiempo, pero\n" +
                        "simplemente no quieren vender... Son personas tercas. No hay nada que\n" +
                        "podamos hacer al respecto.");
        setSinonimos("bluej software herramienta", "bluej");

        responseMap.put("actualización", 
                        "Siempre estamos trabajando en nuevas actualizaciones. ¿Has revisado\n" +
                        "la última versión disponible?");
        setSinonimos("update mejora versión", "actualización");

        responseMap.put("soporte", 
                        "Nuestro equipo de soporte está disponible las 24 horas. ¿Ya intentaste\n" +
                        "contactarlos?");
        setSinonimos("ayuda asistencia soporte", "soporte");

        responseMap.put("error", 
                        "Lamentamos el inconveniente. Por favor, proporciona más detalles para\n" +
                        "que podamos ayudarte.");
        setSinonimos("fallo problema inconveniente", "error");

        responseMap.put("compatibilidad", 
                        "Nuestro software es compatible con la mayoría de los sistemas. ¿Qué\n" +
                        "sistema estás utilizando?");
        setSinonimos("compatible integración soporte", "compatibilidad");

        responseMap.put("licencia", 
                        "Puedes encontrar información sobre las licencias en nuestra página web.\n" +
                        "¿Necesitas ayuda para encontrarla?");
        setSinonimos("permiso autorización contrato", "licencia");

        responseMap.put("seguridad", 
                        "La seguridad es nuestra prioridad. ¿Puedes describir el problema\n" +
                        "relacionado con la seguridad?");
        setSinonimos("protección privacidad integridad", "seguridad");

        responseMap.put("configuración", 
                        "Por favor, verifica que tu configuración cumpla con los requisitos\n" +
                        "mínimos del sistema.");
        setSinonimos("ajustes opciones parámetros", "configuración");

        responseMap.put("documentación", 
                        "Toda la documentación está disponible en línea. ¿Necesitas un enlace\n" +
                        "directo?");
        setSinonimos("manual guía instrucciones", "documentación");

        responseMap.put("precio", 
                        "Ofrecemos precios competitivos. ¿Estás buscando alguna promoción\n" +
                        "específica?");
        setSinonimos("costo valor tarifa", "precio");

        responseMap.put("interfaz", 
                        "Estamos trabajando constantemente para mejorar la interfaz. ¿Qué\n" +
                        "aspecto te gustaría que mejoráramos?");
        setSinonimos("diseño pantalla visual", "interfaz");
    }

    /**
     * @pre sinonimos != null && palabra != null
     * @post Introducir sinónimos en el hashmap de sinónimos
     */
    private void setSinonimos(String sinonimos, String palabra){

        String[] wordArray = sinonimos.split(" ");
        // Crear un nuevo conjunto de palabras
        HashSet<String> wordSet = new HashSet<>();
        // Dividir la cadena de sinónimos en palabras individuales
        for (String word : wordArray) {
            // Agregar cada palabra al conjunto
            wordSet.add(word.toLowerCase());
        }
        if(!sinonimosMap.containsKey(palabra)){
            sinonimosMap.put(palabra, wordSet);
        }else {
            // Si la palabra ya existe, agregar los sinónimos al conjunto existente
            sinonimosMap.get(palabra).addAll(wordSet);
        }

    }



    /**
 * Muestra todos los sinónimos de una palabra clave.
 * 
 * @param palabra La palabra clave para la cual se quieren mostrar los sinónimos.
 */
public void mostrarSinonimos(String palabra) {
    if (sinonimosMap.containsKey(palabra)) {
        HashSet<String> sinonimos = sinonimosMap.get(palabra);
        System.out.println("Sinónimos para '" + palabra + "': " + sinonimos);
    } else {
        System.out.println("No se encontraron sinónimos para la palabra: '" + palabra + "'.");
    }
}



/**
 * 
 * @param palabra
 */
    public String getSinonimos (String palabra){
        Set <String> keys = sinonimosMap.keySet();
        Iterator<String> it = keys.iterator();


        System.out.println("------------< Buscando sinónimos >------------");
        while (it.hasNext()) {
            String keyA = it.next();
            //System.out.println("------------< sinonimos para palabra: "+keyA+" >------------");
            if(sinonimosMap.get(keyA).contains(palabra)){
                return keyA;
            }
        }
        return null; // Return null if no match is found
    }

    /**
     * @post Construir una lista de respuestas predeterminadas de las cuales podemos elegir
     * si no sabemos qué más decir.
     */
    private void fillDefaultResponses()
    {
        try {
            Scanner scanner = new Scanner(new File(archivo));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                defaultResponses.add(linea);
                
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    /**
     * @post Randomly select and return one of the default responses.
     
    private String pickDefaultResponse()
    {
        System.out.println("------------< Respuesta por defecto >------------");

        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }*/

        /**
     * @post Randomly select and return one of the default responses.
     */
    private String pickBrainResponse(HashSet<String> words)
    {


        for (String word: words){
            for (int i=0; i < defaultResponses.size(); i++){
                String[] palabras = defaultResponses.get(i).split(" ");
                for(String palabra: palabras){
                    if (palabra.equals(word)){
                        System.out.println("------------< Respuesta razonada >------------");
                        return defaultResponses.get(i);
                    }
                }
            }   
        }

        System.out.println("------------< Respuesta por defecto >------------");
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }


    public Set<String> keyResponses(){
        return responseMap.keySet();
    }

}
