/**
 * Store details of club memberships.
 */
import java.util.Iterator;
import MyArrayList.MyArrayList;
public class Club
{
    // Define any necessary fields here ...
    private MyArrayList<Membership> list_Club;
    /**
     * @post Create a Club.
     */
    public Club()
    {
        list_Club = new MyArrayList<>(); 
    }

    /**
     * @post Add a new member to the club's list of members.
     */
    public void join(Membership member)
    {
        list_Club.add(member);   
    }

    /**
     * @post Returns the number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    { 
        return list_Club.size();
    }
    /**@pre 1<= months <= 12
     * @post Retunrs the numeber of members who joined in the given month 
     */
    public int joinedInMonth(int months)
    {
        int count = 0;
       
        if (1<= months && months <= 12) {
            for(Membership member:list_Club){ 
                if(member.getMonth() == months){
                    count++;
                }
            }
            return count;           
        }else{
            System.out.println("el mes ingresado es incorrecto");
            return count;
        }
        
    }

    /**
     * @pre {@code 1 <= month <= 12 && year >= 1900}
     * @post lista con los elementos borrados y lista nueva donde se almacenan los eliminados
     */
    public MyArrayList<Membership> purge(int month, int year) {
        MyArrayList<Membership> listaux = new MyArrayList<>();

        if (1 <= month && month <= 12 && year >= 1900) {
            Iterator<Membership> member = list_Club.iterator();
            while (member.hasNext()) {
                Membership m = member.next(); // Obtener el elemento actual
                System.out.println("comparando: " + m);
                // Comparar el mes y el año
                if (m.getMonth() == month && m.getYear() == year) {
                    listaux.add(m); // Guardar en la lista auxiliar
                    list_Club.remove(m); // Eliminar el elemento de list_Club
                    System.out.println("eliminando: " + m);
                }
            }
        } else {
            System.out.println("Error: año o mes fuera de rango");
        }
        return listaux; // Devolver los elementos eliminados
    }

}

