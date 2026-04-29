/**
 * This class stores information about a post in a social network news feed.
 * The main part of the post consists of a photo and a caption.
 * Other data, such as author and time, are also stored.
 */
public class PhotoPost extends Post
{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption

    /**
     * @post Constructs a PhotoPost object with the given 'author',
     * the 'filename' of the image, and the 'caption'.
     */
    public PhotoPost(String author, String filename, String caption)
    {
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

    /**
     * @post Return the file name of the image in this post.
     */
    public String getImageFile()
    {
        return filename;
    }

    /**
     * Return the caption of the image of this post.
     * 
     * @return The image's caption.
     */
    public String getCaption()
    {
        return caption;
    }
    
    /**
     * @post Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        System.out.println("[" + filename + "]");
        System.out.println(caption);
        super.display();
    }
}
