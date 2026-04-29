import java.util.Scanner;

public class MusicOrganizerMain {

    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the song to start playing, " +
                "or 's' to stop playing, or 'q' to quit.");

        while (true) {
            String input = scanner.next();
            if (input.equals("q")) {
                organizer.stopPlaying();
                break;
            } else if (input.equals("s")) {
                organizer.stopPlaying();
            } else {
                int index = Integer.parseInt(input);
                organizer.startPlaying(index);
            }
        }

    }
}
