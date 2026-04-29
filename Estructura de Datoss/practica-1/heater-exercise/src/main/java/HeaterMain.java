import java.util.Arrays;

public class HeaterMain {

    

    public static void main(String[] args) {
        //imprime por pantalla los argumentos de la funcion (en la terminal se argan los argumentos)
        System.out.println("Arguments: " + Arrays.toString(args));

        Heater heater1 = new Heater(0, 200);

        heater1.setIncrement(5.0f);

        heater1.warmer();
        heater1.warmer();
        heater1.warmer();

        heater1.showTemperature();

    }

}
