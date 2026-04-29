import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;

/**
 * PhoneBook is Book the numbers of phone o algo asi 
 */
public class PhoneBook
{
    private HashMap<String, String> booklist;
    /**
     * @post Create a new phoneBook
     */
    public PhoneBook()
    {
        booklist = new HashMap<>();
    }

    /**
     * 
     * @param name
     * @param contact
     * @return agrega una entrada al listado
     */
    public boolean addEntry(String clave, String valor)
    {
        if(!booklist.containsKey(clave)){
        booklist.put( clave, valor);
        return true;
        }else{
            return false;
        }
    }


    /**
     * 
     * @param name
     * @param contact
     * @return true si se cambio el numero false si no se encontro el numero 
     */
    public Boolean changePhone (String name, String contact) {
        if(booklist.containsKey(name)){
            booklist.put(name, contact);
            return true;
        }else {
            return false;
        }
    }

    
/**
 * 
 * @param name
 * @return Elimina el contacto
 */
    public boolean delContact (String name){
        if(booklist.containsKey(name)){
            booklist.remove( name);
            return true;
        }else {
            return false;
        }
    }


/**
 * 
 * @return set de todos los contactos
 */
    public Set<String> getAllContacts(){

        return booklist.keySet();
    } 

    /**
     * 
     * @param name
     * @return numero del contacto 
     */
    public String lookupNumber (String name){
        String numerito = booklist.get(name);
        return numerito;
    }

    /**
     * @return entradas telefonicas
     */

    public int entradas() {
        return booklist.size();
    }

    /**
     * @pos lista todas las claves 
     */
    public void listarClaves() {
        Iterator value = this.getAllContacts().iterator(); 
        System.out.println("Las claves son: "); 
        while (value.hasNext()) { 
            System.out.println(value.next()); 
        } 
    }

}
