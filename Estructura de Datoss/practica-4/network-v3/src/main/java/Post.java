import java.util.ArrayList;

/**
 * This class stores information about a news feed post in a 
 * social network. Posts can be stored and displayed. This class
 * serves as a superclass for more specific post types.
 */
public class Post 
{
    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    /**
     * @pre Should be only called by Post's subclasses.
     * @post Constructor for objects of class Post.
     */
    protected Post(String author)
    {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    /**
     * @post Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * @post Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * @post Add a comment to this post.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }

    /**
     * @post Return the time of creation of this post.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }

    /**
     * @post Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        System.out.println(username);
        System.out.print(timeString(timestamp));
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    
    /**
     * @post Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     */
    private String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
