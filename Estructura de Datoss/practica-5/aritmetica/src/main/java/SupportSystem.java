import MyArrayList.*;

/**
 * esta es una clase para iniciar usar y cerrar 
 * el sistema de la calculadora
 */
public class SupportSystem
{
    private InputReader reader;
    private Calculadora calculadora;
    
    /**
     * @post crear el constructor del sistema.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        calculadora = new Calculadora();
    }

    /**
     * @post Iniciar sistema de calculadora.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            ArrayStack<String> input = reader.getInput();

            System.out.println("En el sistema llega : "+input);

            if(input.top() == "cerrar") {
                finished = true;
            }
            else {
                System.out.println("El resultado es :: "+calculadora.calcular(input));
                //System.out.println("el resultado es :: " + response);
            }
        }
        printGoodbye();
    }

    /**
     * @post Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("bienvenidos a la calculadora de alejo.");
        System.out.println();
        System.out.println("por favor escriba un calculo simple.");
        System.out.println("operadores :: + - * /.");
        System.out.println("(numero) (operador) (numero).");
    }

    /**
     * @post Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("cerrando calculadora y guardando historial...");
    }
}
