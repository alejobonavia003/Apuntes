/**
 * Clase que modela a una persona
 */
public class Person
{
    private final String name;

    /**
     * @post Una persona es creada.
     */
    public Person(String name)
    {
        this.name = name;
    }

    /**
     * @post El nombre de la persona es devuelto.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @post Un String con el nombre de la persona es retornado.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
