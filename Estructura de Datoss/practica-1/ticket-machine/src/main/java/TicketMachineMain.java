import java.util.Arrays;

public class TicketMachineMain {

    public static void main(String[] args) {
        //imprime por pantalla los argumentos de la funcion (en la terminal se argan los argumentos)
        System.out.println("Arguments: " + Arrays.toString(args));

        // crea un objeto tipo tiketmachine
        TicketMachine machine1 = new TicketMachine(10);
        TicketMachine machine2 = new TicketMachine(20);
        TicketMachine machine3 = new TicketMachine();

        //inserta money a la machine
        machine1.insertMoney(10);
        machine2.insertMoney(50);
        machine3.insertMoney(1100);

        //muestro el balanze
        System.out.println("Remaining money machine 1: " + machine1.getBalance());
        System.out.println("Remaining money machine 2: " + machine2.getBalance());
        System.out.println("Remaining money machine 3: " + machine3.getBalance());

        //devuelve true si el balanze alcanza para comprar un tiket
        machine1.printTicket();
        machine2.printTicket();
        machine3.printTicket();
        //muestra el tiket y devuelve true si alcanza el balanze para comprarlo


        //muestro el balanze
        System.out.println("Remaining money machine 1: " + machine1.getBalance());
        System.out.println("Remaining money machine 2: " + machine2.getBalance());
        System.out.println("Remaining money machine 3: " + machine3.getBalance());

        machine1.empty();
        machine2.empty();
        machine3.empty();

        //muestro el balanze
        System.out.println("Remaining money machine 1: " + machine1.getBalance());
        System.out.println("Remaining money machine 2: " + machine2.getBalance());
        System.out.println("Remaining money machine 3: " + machine3.getBalance());
    }

}
