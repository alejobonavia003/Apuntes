
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * The test class WordCounterTest.
 * Agregar test para cubrir todos los metodos de WordCounter.
 */
public class WordCounterTest
{   
    
    @Test
    public void test0()
    {
        WordCounter counter = new WordCounter();
        SortedSet<String> words = new MyBinarySearch<>();
        words.add("hola");
        words.add("mundo");
        counter.addWords(words);
        assertEquals(1, counter.getRepetitions("hola"));
    }
    
    @Test
    public void test1()
    {
        WordCounter counter = new WordCounter();
        SortedSet<String> words = new MyBinarySearch<>();
        words.add("hola");
        words.add("mundo");
        counter.addWords(words);
        assertTrue(counter.belongsToSet("mundo"));
    }
    
    @Test
    public void test2()
    {
        WordCounter counter = new WordCounter();
        SortedSet<String> words = new MyBinarySearch<>();
        words.add("hola");
        words.add("mundo");
        counter.addWords(words);
        assertTrue(counter.getAllWords().equals(words));
    } 

    
}




