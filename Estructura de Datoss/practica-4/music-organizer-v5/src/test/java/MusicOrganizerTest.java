import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicOrganizerTest
{

    @Test
    public void testStartPlaying() throws InterruptedException {
        MusicOrganizer organizer = new MusicOrganizer();
        int index = organizer.findFirstByTitle("EarlyMorningBlues");
        // We are finding the index of the track: "audio/BlindBlake-EarlyMorningBlues.mp3";
        organizer.startPlaying(index);
        TimeUnit.SECONDS.sleep(5);
        //organizer.stopPlaying();
    }

}
