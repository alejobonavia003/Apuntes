package main;

import java.util.Arrays;

/**
 * Application to crack a message ciphered with Caesar encryption.
 * Requires the user to provide encrypted message, known word belonging
 * to the original, unencrypted, message, and size of longest key to
 * try.
 * @author aguirre
 *
 */
public final class CrackMessage {

    /**
     * Constructor of class.
     * Made private to comply with style constraints.
     */
    private CrackMessage() { }

    /**
     * Number of parameters received by CLI.
     */
    private static final int NUMPARAMS = 3;

    /**
     * Command line interface for CaesarCracker.
     * @param args contains command line arguments for program.
     */
    public static void main(final String[] args) {






        
        if (args.length != NUMPARAMS) {
            System.out.println("usage: java CrackMessage <encrypted message> <word> <max key size>");
        }
        String message = args[0];
        String word = args[1];
        int k = 0;
        try {
            k = Integer.parseInt("args[2]");
        } catch (Exception e) {
            System.out.println("Key must be an integer number.");
            return;
        }
        if (k <= 0) {
            System.out.println("Key must be a positive number.");
            return;
        }
        CaesarCracker cracker = new CaesarCracker(message, word);
        cracker.setPasswordLength(k);
        cracker.bruteForceDecrypt();
        if (cracker.foundKey() != null) {
            System.out.println("Decryption succeeded!");
            System.out.println("Key found: " + Arrays.toString(cracker.foundKey()));
            System.out.println("Decrypted message: " + CaesarCracker.decode(message, cracker.foundKey()));
        } else {
            System.out.println("Decryption failed, no key found within provided bound.");
        }
            
    }
        

}
