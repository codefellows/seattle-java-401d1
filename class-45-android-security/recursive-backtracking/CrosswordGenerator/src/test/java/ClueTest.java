import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ClueTest {
    @Test
    public void testIsAcrossClue() {
        Clue c1 = new Clue(0, 0, 1, true, true);
        String expected = "#1 (0,0) up: true down: true";
        String actual = c1.toString();

        assertEquals(expected, actual);
    }
}