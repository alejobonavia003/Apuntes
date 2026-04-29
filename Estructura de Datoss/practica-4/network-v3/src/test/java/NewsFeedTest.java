import org.junit.jupiter.api.Test;


/**
 * The test class NewsFeedTest.
 */
public class NewsFeedTest
{
    @Test
    public void testShow() {
        MessagePost messagePost = new MessagePost("Leonardo da Vinci", 
          "Had a great idea this morning.\n" + 
          "But now I forgot what it was. Something to do with flying...");
        messagePost.like();
        messagePost.like();
        PhotoPost photoPost = new PhotoPost("Alexander Graham Bell", 
          "experiment.jpg", 
        "I think I might call this thing ’telephone’.");
        photoPost.like();
        photoPost.like();
        photoPost.like();
        photoPost.like();
        NewsFeed feed = new NewsFeed();
        feed.addPost(messagePost);
        feed.addPost(photoPost);
        feed.show();
    }
}
