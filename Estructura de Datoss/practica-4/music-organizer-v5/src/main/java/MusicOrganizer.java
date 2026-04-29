import java.io.IOException;
import java.util.ArrayList;

/**
 * Stores a sequence of audio tracks. It allows
 * to reproduce the tracks in the collection, and 
 * to search for tracks under different criteria.
 */
public class MusicOrganizer
{
    // An ArrayList for storing music files.
    private ArrayList<Track> tracks;
    // A player for the music files.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;

    /**
     * Create an empty MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }

    /**
     * @pre 'track' represents a valid .mp3 file.
     * @post Add a track to the end of the collection.
     */
    public void addTrack(Track track)
    {
        if (track == null) {
            throw new IllegalArgumentException("el track no puede ser null");
        }
        tracks.add(track);
    }

    /**
     * @post Returns the number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * @pre 0 <= 'index' < getNumberOfTracks()
     * @post Prints the details of the track in position 'index' 
     * to the terminal.
     */
    public void listTrack(int index)
    {

        if(index >= 0 && index < tracks.size()) {
            Track track = tracks.get(index);
            System.out.println(track.getDetails());
        }
        else {
            throw new IllegalArgumentException("indice incorrecto");
        }
    }

    /**
     * @post Print the list of tracks in the collection.
     */
    public void listAllTracks()
    {
        for (int i = 0; i < tracks.size(); i++) {
            Track track = tracks.get(i);
            System.out.println(track.getDetails());
        }
    }

    /**
     * @post Print the names of the tracks with title 
     *   matching 'searchString'.
     */
    public void listByTitle(String searchString)
    {

        if (searchString == null) {
            throw new IllegalArgumentException("la busqueda no puede ser null");
        }
        for (int i = 0; i < tracks.size(); i++) {
            Track track = tracks.get(i);
            String title = track.getTitle();
            if(title.contains(searchString)) {
                // A match.
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * @post Print the names of the tracks with title 
     *   matching 'artist'.
     */
    public void listByArtist(String artist)
    {

        if (artist == null) {
            throw new IllegalArgumentException("la busqueda no puede ser null");
        }
        for (int i = 0; i < tracks.size(); i++) {
            Track track = tracks.get(i);
            String art = track.getArtist();
            if(art.contains(artist)) {
                // A match.
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * @post Find the index of the first track with title
     *   matching 'searchString'. Return the index of the  
     *   first occurrence, or -1 if no match is found.
     */
    public int findFirstByTitle(String searchString)
    {
        int index = 0;
        // Record that we will be searching until a match is found.
        boolean searching = true;

        while(searching && index < tracks.size()) {
            Track track = tracks.get(index);
            String title = track.getTitle();
            if(title.contains(searchString)) {
                // A match. We can stop searching.
                searching = false;
            }
            else {
                // Move on.
                index++;
            }
        }
        if(searching) {
            // We didn't find it.
            return -1;
        }
        else {
            // Return where it was found.
            return index;
        }
    }

    /**
     * @pre 0 <= 'index' < getNumberOfTracks()
     * @post Removes the track in position 'index' from the 
     * collection.
     */
    public void removeTrack(int index)
    {
        if(index >= 0 && index < tracks.size()) {
            tracks.remove(index);
        }
        else {
            throw new IllegalArgumentException("indice incorrecto");
        }
    }

    /**
     * @pre 0 <= 'index' < getNumberOfTracks() && 
     *      the track in position 'index' is a valid .mp3.
     * @post Start playing the track in position 'index'.
     */
    public void startPlaying(int index)
    {
        if (index >=0 && index < tracks.size()) { //CONSULTAR
            try{
                Track track = tracks.get(index);
                String filename = track.getFilename();
                player.startPlaying(filename);
            } catch(Exception e){
                System.out.println("Error al reproducir el archivo: " + e.getMessage());
                throw new RuntimeException("Error al reproducir el archivo");
            }

        }
        else {
            throw new IllegalArgumentException("indice incorrecto");
        }

    }

    /**
     * @post Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * @pre The format of all the filenames in 'folderName'
     *   is: artist-title.mp3
     * @post Read the tracks in 'folderName' and loads all of 
     *   them in the organizer.
     */     
    private void readLibrary(String folderName)
    {
        try{
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");
        // Put all the tracks into the organizer.
        for(Track track: tempTracks) {
            addTrack(track);
        }
    } catch (Exception e) {//PREGUNTAR QUE ESTA MAL
        System.out.println("Error al leer archivos: " + e.getMessage());
        throw new RuntimeException(folderName + " no existe");
    }
}
}
