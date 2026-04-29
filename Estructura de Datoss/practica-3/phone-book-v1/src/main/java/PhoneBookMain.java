
/**
 * Main class for the TechSupport project.
 */
public class PhoneBookMain
{
    public static void main(String[] args) {
        System.out.println("¿Que sucede cuando agregas dos entradas a un Map con el mismo valor y dos claves diferentes?.");
        PhoneBook listado = new PhoneBook();


        boolean attempt = listado.addEntry("lauti", "3385443705");
        boolean attempt2 = listado.addEntry("alejo", "3385443705");
        boolean attempt3 = listado.addEntry("asd", "3385443705");
        listado.addEntry("alejasddo", "3385443705");
        listado.addEntry("saddas", "3385443705");
        listado.addEntry("luchi", "3385443705");
        

        System.out.println("agrego una entrada: " + attempt);
        System.out.println("agrego otra entrada con diferente valo y misma clave: " + attempt2);
        System.out.println("total de entradas: " + listado.entradas());
        System.out.println("SE GUARDAN LAS DOS ENTRADAS" );
        System.out.println("¿C ́omo verificas si una clave dada est ́a contenida en un Map?." );
        System.out.println("agrego otra entrada con mismo valor y misma clave: " + attempt3);
        System.out.println("primero verifica que la clave no exista y si existe devuelve falso y no guarda nada" );

 
        System.out.println("que sucede cuando intentas buscar un valor y la clave no existe en el Map?" );
        System.out.println("buscando un valor de una clave que no existe, resultado: "+listado.lookupNumber("luchi"));

        System.out.println("la cantidad total de claves es: "+listado.getAllContacts().size());
        listado.listarClaves();

    }
}
