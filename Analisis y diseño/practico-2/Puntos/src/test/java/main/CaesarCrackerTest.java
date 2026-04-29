package main;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;



import org.junit.Test;

/**
 * Tests for CaesarCracker class.
 *
 */
public class CaesarCrackerTest {

    /**
     * Checks basic properties of default constructor.
     */
    @Test
    public final void testDefaultConstructor() {
        CaesarCracker cracker = new CaesarCracker();
        assertEquals("default pass length is one", 1, cracker.getPasswordLength());
        assertEquals("message word is empty", "", cracker.getMessageWord());
        assertEquals("encrypted message is empty", "", cracker.getEncryptedMessage());
    }

    /**
     * Checks basic properties of parameterized constructor.
     */
    @Test
    public final void testConstructorWithWordAndMessage() {
        CaesarCracker cracker = new CaesarCracker("encrypted", "word");
        assertEquals("default pass length is one", 1, cracker.getPasswordLength());
        assertEquals("message word is correct", "word", cracker.getMessageWord());
        assertEquals("encrypted message is correct", "encrypted", cracker.getEncryptedMessage());
    }

    /**
     * Checks encrypted message setter.
     */
    @Test
    public final void testSettingEncryptedMessage() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setEncryptedMessage("abcd");
        assertEquals("encrypted message is correctly set", "abcd", cracker.getEncryptedMessage());
    }

    /**
     * Checks known word setter.
     */
    @Test
    public final void testSettingKnownWord() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setEncryptedMessage("asdfafasfas");
        cracker.setMessageWord("abcd");
        assertEquals("known word is correctly set", "abcd", cracker.getMessageWord());
    }

    /**
     * Checks encoding/decoding simple message on simple key.
     */
    @Test
    public final void testSimpleKey() {
        int[] key = {1};
        String output = CaesarCracker.encode("hola", key);
        assertEquals("ipmb", output);
        String output2 = CaesarCracker.decode("ipmb", key);
        assertEquals("hola", output2);
    }

    /**
     * Negative test on invalid encoding message.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidMessageEncode() {
        int[] key = {1};
        CaesarCracker.encode(null, key);
        // must break!
    }

    /**
     * Negative test on invalid encoding key.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidKeyEncode() {
        int[] key = null;
        CaesarCracker.encode("hola", key);
        // must break!
    }

    /**
     * Negative test on invalid encoding key.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidEmptyKeyEncode() {
        int[] key = {};
        CaesarCracker.encode("hola", key);
        // must break!
    }

    /**
     * Negative test on invalid decoding message.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidMessageDecode() {
        int[] key = {1};
        CaesarCracker.decode(null, key);
        // must break!
    }

    /**
     * Negative test on invalid decoding key (null).
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidKeyDecode() {
        int[] key = null;
        CaesarCracker.decode("hola", key);
        // must break!
    }

    /**
     * Negative test on invalid decoding key (empty).
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidEmptyKeyDecode() {
        int[] key = {};
        CaesarCracker.decode("hola", key);
        // must break!
    }

    /**
     * Testing encoding/decoding with two-valued key.
     */
    @Test
    public final void testComplexKey() {
        int[] key = {1, 0};
        String output = CaesarCracker.encode("hola", key);
        assertEquals("ioma", output);
        String output2 = CaesarCracker.decode("ioma", key);
        assertEquals("hola", output2);
    }

    /**
     * Testing encoding/decoding with three-valued key.
     */
    @Test
    public final void testMoreComplexKey() {
        int[] key = {20, 120, 101};
        String output = CaesarCracker.encode("hola que tal como andas", key);
        String output2 = CaesarCracker.decode(output, key);
        assertEquals("hola que tal como andas", output2);
    }

    /**
     * Negative test, invalid parameter for message setter.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidBruteForce() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setEncryptedMessage(null);
    }

    /**
     * Negative test, invalid parameter for word setter.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidBruteForce2() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setMessageWord(null);
    }

    /**
     * Negative test, invalid parameter for word setter.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidBruteForce3() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setMessageWord("hola");
        cracker.setEncryptedMessage("h");
    }

    /**
     * Negative test, invalid password length.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testInvalidBruteForce4() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setPasswordLength(0);
    }

    /**
     * Tests bruteForceDecrypt on decryptable message.
     */
    @Test
    public final void testSimpleBruteForce() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setEncryptedMessage("ipmbfasdfa");
        cracker.setMessageWord("hola");
        boolean isDecrypted = cracker.bruteForceDecrypt();
        assertTrue("message decrypted", isDecrypted);
    }

    /**
     * Tests bruteForceDecrypt on small decryptable message.
     */
    @Test
    public final void testLessSimpleBruteForce() {
        CaesarCracker cracker = new CaesarCracker();
        cracker.setEncryptedMessage("iomafasdfa");
        cracker.setMessageWord("hola");
        cracker.setPasswordLength(2);
        boolean isDecrypted = cracker.bruteForceDecrypt();
        assertTrue("message decrypted", isDecrypted);
    }

    /**
     * Tests bruteForceDecrypt on small undecryptable message.
     */
    @Test
    public final void testFailedComplexBruteForce() {
        CaesarCracker cracker = new CaesarCracker();
        int[] key = {1, 100, 101};
        cracker.setEncryptedMessage(CaesarCracker.encode("hola que tal", key));
        cracker.setMessageWord("hola");
        boolean isDecrypted = cracker.bruteForceDecrypt();
        // message not decrypted. 1-valued keys cannot decode message
        assertFalse("message decrypted", isDecrypted);
        assertTrue("key not found", cracker.foundKey() == null);
    }

    /**
     * Tests bruteForceDecrypt on larger decryptable message.
     */
    @Test
    public final void testComplexBruteForce() {
        CaesarCracker cracker = new CaesarCracker();
        int[] key = {1, 100, 101};
        cracker.setEncryptedMessage(CaesarCracker.encode("hola que tal", key));
        cracker.setMessageWord("hola");
        cracker.setPasswordLength(1);
        boolean isDecrypted = cracker.bruteForceDecrypt();
        assertFalse("message decrypted", isDecrypted);
        cracker.setPasswordLength(2);
        isDecrypted = cracker.bruteForceDecrypt();
        assertFalse("message decrypted", isDecrypted);
        cracker.setPasswordLength(3);
        isDecrypted = cracker.bruteForceDecrypt();
        assertTrue("message decrypted", isDecrypted);
        assertTrue("word found", CaesarCracker.decode(cracker.getEncryptedMessage(), cracker.foundKey()).contains(cracker.getMessageWord()));
    }

    /**
     * Tests bruteForceDecrypt on larger decryptable message. Key is correctly found.
     */
    @Test
    public final void testMoreComplexBruteForce() {
        CaesarCracker cracker = new CaesarCracker();
        int[] key = {20, 100, 101};
        cracker.setEncryptedMessage(CaesarCracker.encode("hola que tal como andas", key));
        cracker.setMessageWord("hola");
        cracker.setPasswordLength(1);
        boolean isDecrypted = cracker.bruteForceDecrypt();
        assertFalse("message decrypted", isDecrypted);
        cracker.setPasswordLength(2);
        isDecrypted = cracker.bruteForceDecrypt();
        assertFalse("message decrypted", isDecrypted);
        cracker.setPasswordLength(3);
        isDecrypted = cracker.bruteForceDecrypt();
        assertTrue("message decrypted", isDecrypted);
        assertTrue("word found", CaesarCracker.decode(cracker.getEncryptedMessage(), cracker.foundKey()).contains(cracker.getMessageWord()));
    }

    /**
     * Tests bruteForceDecrypt on even larger decryptable message. Key is correctly found.
     */
    @Test
    public final void testEvenMoreComplexBruteForce() {
        CaesarCracker cracker = new CaesarCracker();
        int[] key = {3, 23, 126, 103};
        cracker.setEncryptedMessage(CaesarCracker.encode("hola que tal como andas", key));
        cracker.setMessageWord("hola");
        cracker.setPasswordLength(1);
        boolean isDecrypted = cracker.bruteForceDecrypt();
        assertFalse("message decrypted", isDecrypted);
        cracker.setPasswordLength(2);
        isDecrypted = cracker.bruteForceDecrypt();
        assertFalse("message decrypted", isDecrypted);
        cracker.setPasswordLength(3);
        isDecrypted = cracker.bruteForceDecrypt();
        assertFalse("message decrypted", isDecrypted);
        cracker.setPasswordLength(4);
        isDecrypted = cracker.bruteForceDecrypt();
        assertTrue("message decrypted", isDecrypted);
        assertTrue("word found", CaesarCracker.decode(cracker.getEncryptedMessage(), cracker.foundKey()).contains(cracker.getMessageWord()));
    }

}