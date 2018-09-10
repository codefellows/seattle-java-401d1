import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CrossWordTest {
    @Test
    public void testIsAcrossClue() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);

        assertEquals(true,  puzzle.isAcrossStart(0, 0));
        assertEquals(false, puzzle.isAcrossStart(0, 1));
        assertEquals(false, puzzle.isAcrossStart(0, 2));
        assertEquals(false, puzzle.isAcrossStart(0, 3));
        assertEquals(false, puzzle.isAcrossStart(0, 4));

        assertEquals(false, puzzle.isAcrossStart(1, 0));
        assertEquals(false, puzzle.isAcrossStart(1, 2));
        assertEquals(false, puzzle.isAcrossStart(1, 4));

        assertEquals(true,  puzzle.isAcrossStart(2, 0));
        assertEquals(false, puzzle.isAcrossStart(2, 1));
        assertEquals(false, puzzle.isAcrossStart(2, 2));
        assertEquals(false, puzzle.isAcrossStart(2, 3));
        assertEquals(false, puzzle.isAcrossStart(2, 4));

        assertEquals(false, puzzle.isAcrossStart(3, 0));
        assertEquals(false, puzzle.isAcrossStart(3, 2));
        assertEquals(false, puzzle.isAcrossStart(3, 4));

        assertEquals(true,  puzzle.isAcrossStart(4, 0));
        assertEquals(false, puzzle.isAcrossStart(4, 1));
        assertEquals(false, puzzle.isAcrossStart(4, 2));
        assertEquals(false, puzzle.isAcrossStart(4, 3));
        assertEquals(false, puzzle.isAcrossStart(4, 4));
    }

    @Test
    public void testIsDownClue() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);

        assertEquals(true,  puzzle.isDownStart(0, 0));
        assertEquals(false, puzzle.isDownStart(0, 1));
        assertEquals(true,  puzzle.isDownStart(0, 2));
        assertEquals(false, puzzle.isDownStart(0, 3));
        assertEquals(true,  puzzle.isDownStart(0, 4));

        assertEquals(false, puzzle.isDownStart(1, 0));
        assertEquals(false, puzzle.isDownStart(1, 2));
        assertEquals(false, puzzle.isDownStart(1, 4));

        assertEquals(false, puzzle.isDownStart(2, 0));
        assertEquals(false, puzzle.isDownStart(2, 1));
        assertEquals(false, puzzle.isDownStart(2, 2));
        assertEquals(false, puzzle.isDownStart(2, 3));
        assertEquals(false, puzzle.isDownStart(2, 4));

        assertEquals(false, puzzle.isDownStart(3, 0));
        assertEquals(false, puzzle.isDownStart(3, 2));
        assertEquals(false, puzzle.isDownStart(3, 4));

        assertEquals(false, puzzle.isDownStart(4, 0));
        assertEquals(false, puzzle.isDownStart(4, 1));
        assertEquals(false, puzzle.isDownStart(4, 2));
        assertEquals(false, puzzle.isDownStart(4, 3));
        assertEquals(false, puzzle.isDownStart(4, 4));
    }

    @Test
    public void findStarts() throws Exception {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        Set<Clue> clues = puzzle.clues;

        Clue c1 = new Clue(0, 0, 1, true, true);
        Clue c2 = new Clue(0, 2, 2, false, true);
        Clue c3 = new Clue(0, 4, 3, false, true);
        Clue c4 = new Clue(2, 0, 4, true, false);
        Clue c5 = new Clue(4, 0, 5, true, false);

        Set<Clue> expectedClues = new HashSet<>();
        expectedClues.add(c1);
        expectedClues.add(c2);
        expectedClues.add(c3);
        expectedClues.add(c4);
        expectedClues.add(c5);

        assertEquals(expectedClues, clues);
    }

    @Test
    public void testLengthAcross() throws Exception {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);

        Clue c1 = puzzle.getClueAt(0, 0);
        Clue c4 = puzzle.getClueAt(2, 0);
        Clue c5 = puzzle.getClueAt(4, 0);

        assertEquals(5, c1.getLengthAcross());
        assertEquals(5, c4.getLengthAcross());
        assertEquals(5, c5.getLengthAcross());
    }

    @Test
    public void testLengthDown() throws Exception {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);

        Clue c1 = puzzle.getClueAt(0, 0);
        Clue c2 = puzzle.getClueAt(0, 2);
        Clue c3 = puzzle.getClueAt(0, 4);

        assertEquals(5, c1.getLengthDown());
        assertEquals(5, c2.getLengthDown());
        assertEquals(5, c3.getLengthDown());
    }

    @Test
    public void testToString() throws Exception {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        String actual = puzzle.toString();
        String expected =
                "     \n" +
                " # # \n" +
                "     \n" +
                " # # \n" +
                "     \n";

        assertEquals(expected, actual);
    }

    @Test
    public void testAttemptClueDown() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        Clue c1 = puzzle.getClueAt(0, 0);

        boolean b1 = puzzle.attemptClueAcross(c1, "hello");
        assertEquals(true, b1);
        assertEquals(false, c1.isSolved());

        boolean b2 = puzzle.attemptClueDown(c1, "habit");
        assertEquals(true, b2);
        assertEquals(true, c1.isSolved());
    }

    @Test
    public void testPuzzleSolved() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        Clue c1 = puzzle.getClueByNumber(1);
        Clue c2 = puzzle.getClueByNumber(2);
        Clue c3 = puzzle.getClueByNumber(3);
        Clue c4 = puzzle.getClueByNumber(4);
        Clue c5 = puzzle.getClueByNumber(5);

        // hello
        // a e z
        // bimbo
        // i m n
        // trace
        puzzle.attemptClueAcross(c1, "hello");
        puzzle.attemptClueDown(c1, "habit");
        assertEquals(false, puzzle.isSolved());

        puzzle.attemptClueDown(c2, "lemma");
        puzzle.attemptClueDown(c3, "ozone");
        assertEquals(false, puzzle.isSolved());

        puzzle.attemptClueAcross(c4, "bimbo");
        puzzle.attemptClueAcross(c5, "trace");
        assertEquals(true, puzzle.isSolved());
    }

    @Test
    public void testWordWritten() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        Clue c1 = puzzle.getClueByNumber(1);

        puzzle.attemptClueAcross(c1, "hello");

        String actual = puzzle.toString();
        String expected =
                "hello\n" +
                " # # \n" +
                "     \n" +
                " # # \n" +
                "     \n";

        assertEquals(expected, actual);
    }

    @Test
    public void testWordUnwritten() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        Clue c1 = puzzle.getClueByNumber(1);

        puzzle.attemptClueAcross(c1, "hello");

        String actual = puzzle.toString();
        String expected =
                "hello\n" +
                " # # \n" +
                "     \n" +
                " # # \n" +
                "     \n";

        puzzle.unsetClueAcross(c1);

        actual = puzzle.toString();
        expected =
            "     \n" +
            " # # \n" +
            "     \n" +
            " # # \n" +
            "     \n";

        assertEquals(expected, actual);
    }

    @Test
    public void testWordUnwrittenContested() {
        CrossWord puzzle = new CrossWord(CrossWordInputs.small);
        Clue c1 = puzzle.getClueByNumber(1);

        puzzle.attemptClueAcross(c1, "hello");
        puzzle.attemptClueDown(c1, "habit");

        String actual = puzzle.toString();
        String expected =
                "hello\n" +
                "a# # \n" +
                "b    \n" +
                "i# # \n" +
                "t    \n";
        assertEquals(expected, actual);

        puzzle.unsetClueAcross(c1);

        // make sure the "h" in habit remains
        // after "hello" is removed
        actual = puzzle.toString();
        expected =
                "h    \n" +
                "a# # \n" +
                "b    \n" +
                "i# # \n" +
                "t    \n";
        assertEquals(expected, actual);
    }
}