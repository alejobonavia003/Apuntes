import java.io.*;
import java.util.*;

/**
 * A class for creating log files of random data.
 */
public class LogfileCreator
{
    private Random rand;

    /**
     * Create log files.
     */
    public LogfileCreator()
    {
        rand = new Random();
    }
    
    /**
     * @pre 'numEntries' > 0 && 
     *   'filename' is a valid filename.
     * @post Create a file of random log with name 'filename' and
     *   'numEntries' entries. Throws an IOException if there are errors 
     *   when trying to write to 'filename'.
     */
    public void createFile(String filename, int numEntries) throws IOException
    {
        if (numEntries <= 0)
            throw new IllegalArgumentException("numEntries should be greater than 0.");
        
            FileWriter writer = new FileWriter(filename);
            LogEntry[] entries = new LogEntry[numEntries];
            for(int i = 0; i < numEntries; i++) {
                entries[i] = createEntry();
            }
            Arrays.sort(entries);
            for(int i = 0; i < numEntries; i++) {
                writer.write(entries[i].toString());
                writer.write('\n');
            }
            
            writer.close();
    }
    
    /**
     * @post Create a single (random) entry for a log file.
     * A log entry containing random data.
     */
    private LogEntry createEntry()
    {
        int year = 2016;
        int month = 1 + rand.nextInt(12);
        // Avoid the complexities of days-per-month.
        int day = 1 + rand.nextInt(28);
        int hour = rand.nextInt(24);
        int minute = rand.nextInt(60);
        return new LogEntry(year, month, day, hour, minute);
    }

}
