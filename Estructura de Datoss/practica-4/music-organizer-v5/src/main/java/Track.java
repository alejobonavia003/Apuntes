/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    
    /**
     * Create a track with the given data.
     */
    public Track(String artist, String title, String filename)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }
    
    /**
     * @post Return the artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * @post Return the title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @post Return the file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * @post Return details of the track as a String.
     */
    public String getDetails()
    {
        return artist + ": " + title + "  (file: " + filename + ")";
    }
    
}
