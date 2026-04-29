import java.util.HashSet;

/**
 * Esta clase le permite a los usuarios ejecutar un evento comun
 */

public class EventPost extends Post {
    
    private HashSet<String> friends;


    public EventPost(String author) {
        super(author);
        this.friends = new HashSet<>();
    }


/**
 * @post Agrega un amigo a la lista de amigos
 * @param friend
 */
    public void addFriend(String friend) {
        friends.add(friend);
    }
    /**
     * @post elimina un amigo de la lista
     * @param friend
     */
    public void removeFriend(String friend) {
        friends.remove(friend);
    }

    /**
     * @post muestra la lista de amigos por pantalla
     * @return lista de amigos 
     */
    public HashSet<String> showFriends () {
        System.out.println("Lista de amigos: ");
        for (String friend : friends) {
            System.out.println(friend);
        }
        return friends;
    }

}
