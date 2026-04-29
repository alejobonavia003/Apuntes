
import org.junit.jupiter.api.Test;

/**
 * The test class PhotoPostTest.
 */
public class PhotoPostTest
{
    @Test
    public void testToString() {
        PhotoPost photoPost = new PhotoPost("Alexander Graham Bell", 
          "experiment.jpg",
        "I think I might call this thing ’telephone’.");
        System.out.println(photoPost.toString());
    }
}
