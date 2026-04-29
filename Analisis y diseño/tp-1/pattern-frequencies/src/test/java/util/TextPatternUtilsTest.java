package util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Set;


/**
 * Tests for methods in class TextPatternUtils.
 *
 */
public final class TextPatternUtilsTest {

    /**
     * Tests mostFrequentPatterns on invalid text.
     */
    @Test
    public final void testMostFrequentWordsInvalidText() {
        String text = null;
        int k = 1;
        assertThrows(IllegalArgumentException.class, () -> TextPatternUtils.mostFrequentPatterns(text, k));
    }

    /**
     * Tests mostFrequentPatterns on invalid pattern size.
     */
    @Test
    public final void testMostFrequentWordsInvalidSize() {
        String text = "";
        int k = -1;

        assertThrows(IllegalArgumentException.class, () -> TextPatternUtils.mostFrequentPatterns(text, k));
    }

    /**
     * Tests mostFrequentPatterns on emptyText.
     */
    @Test
    public final void testMostFrequentWordsEmptyText() {
        String text = "";
        int k = 0;
        
        Set<String> mostFreqPatterns = TextPatternUtils.mostFrequentPatterns(text, k);

        assertEquals(1, mostFreqPatterns.size(), "empty list is the only most frequent pattern");
    }
    
    /**
     * Tests mostFrequentPatterns on simple text, single output.
     */
    @Test
    public final void testMostFrequentWordsSimpleTextSingleOutput() {
        String text = "ACAACTATGCATACTATCGGGAACTATCCT";
        int k = 5;
        
        Set<String> mostFreqPatterns = TextPatternUtils.mostFrequentPatterns(text, k);
        
        assertEquals(1, mostFreqPatterns.size());
        assertTrue(mostFreqPatterns.contains("ACTAT"));
    }
    
    /**
     * Tests mostFrequentPatterns on simpler text, single output.
     */
    @Test
    public final void testMostFrequentWordsSimplerTextSingleOutput() {
        String text = "CGATATATCCATAG";
        int k = 3;
        
        Set<String> mostFreqPatterns = TextPatternUtils.mostFrequentPatterns(text, k);
        
        assertEquals(1, mostFreqPatterns.size());
        assertTrue(mostFreqPatterns.contains("ATA"));
    }
    
    /**
     * Tests mostFrequentPatterns on simple text, two outputs.
     */
    @Test
    public final void testMostFrequentWordsSimpleTextDoubleOutput() {
        String text = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        
        Set<String> mostFreqPatterns = TextPatternUtils.mostFrequentPatterns(text, k);
        
        assertEquals(2, mostFreqPatterns.size());
        assertTrue(mostFreqPatterns.contains("CATG"));
        assertTrue(mostFreqPatterns.contains("GCAT"));
    }
    
    /**
     * Tests mostFrequentPatterns on text from line in file.
     */
    @Test
    public final void testMostFrequentWordsBiggerInput() throws IOException {
        String content;
        try (InputStream is = this.getClass().getResourceAsStream("dataset_2_10.txt")) {
            content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
        String[] lines = content.split("\\R");
        String text = lines[0];
        int k = Integer.parseInt(lines[1]);

        assertTimeout(Duration.ofSeconds(10), () -> {
            Set<String> mostFreqPatterns = TextPatternUtils.mostFrequentPatterns(text, k);
            assertEquals(1, mostFreqPatterns.size());
            assertTrue(mostFreqPatterns.contains("TGATGGCTTGG"));
        });
    }
    
    /**
     * Tests mostFrequentPatterns on text from file.
     */
    @Test
    public final void testMostFrequentWordsVibrioCholerae() throws IOException {
        String text;
        try (InputStream is = this.getClass().getResourceAsStream("Vibrio_cholerae.txt")) {
            text = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
        int k = 9;
        assertTimeout(Duration.ofSeconds(10), () -> {
            Set<String> mostFreqPatterns = TextPatternUtils.mostFrequentPatterns(text, k);
            assertEquals(1, mostFreqPatterns.size());
        });
    }
    
}
