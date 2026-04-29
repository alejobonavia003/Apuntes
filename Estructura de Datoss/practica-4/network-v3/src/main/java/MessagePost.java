/**
 * This class stores information about a post in a social network news feed. 
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 */
public class MessagePost extends Post
{
    private String message;  // an arbitrarily long, multi-line message

    /**
     * @post Constructs a MessagePost object with the given
     * 'author' and 'text'.
     */
    public MessagePost(String author, String text)
    {
        super(author);
        message = text;
    }

    /**
     * @post Return the text of this post.
     */
    public String getText()
    {
        return message;
    }
    
    /**
     * @post Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        System.out.println(message);
        super.display();
    }
}
