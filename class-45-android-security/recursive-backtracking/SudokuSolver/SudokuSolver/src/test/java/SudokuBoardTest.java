import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuBoardTest {
    int[][] SOLUTION = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},


            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},

            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    int[][] BOX_TESTER = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},


            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},

            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public SudokuBoard getSolvedBoard() {
        return Puzzles.initializeBoard(SOLUTION);
    }

    @Test
    public void isEmptyBoardComplete() throws Exception {
        // an empty board is valid, but it's not considered complete.
        SudokuBoard board = new SudokuBoard();
        assertFalse(board.isBoardComplete());
    }

    @Test
    public void isEmptyBoardValid() throws Exception {
        // an empty board is considered valid because it doesn't break
        // and constraints. It's simply not finished yet.
        SudokuBoard board = new SudokuBoard();
        assertFalse(board.isBoardComplete());
    }

    @Test
    public void isFullBoardComplete() {
        SudokuBoard board = getSolvedBoard();
        assertTrue(board.isBoardComplete());
    }

    @Test
    public void isValidationCorrect() {
        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            for (int col = 0; col < SudokuBoard.SIZE; col++) {
                SudokuBoard board = getSolvedBoard();
                int val = board.get(row, col);
                if (val == 1) {
                    board.set(row, col, 2);
                } else {
                    board.set(row, col, 1);
                }

                assertFalse(board.isBoardValid());
                assertFalse(board.isBoardComplete());
            }
        }
    }

    @Test
    public void testSetIfSafe() {
        SudokuBoard board = getSolvedBoard();

        // unset two values
        board.unset(0, 0);
        board.unset(0, 1);

        assertEquals(board.get(0, 0), 0);
        assertEquals(board.get(0, 1), 0);

        // try to set five in two different spaces
        boolean isFirstFiveSet = board.setIfSafe(0, 0, 5);
        boolean isSecondFiveSet = board.setIfSafe(0, 1, 5);

        assertEquals(true, isFirstFiveSet);
        assertEquals(false, isSecondFiveSet);

        // the first five should be set
        assertEquals(board.get(0, 0), 5);
        // the second five should remain a zero
        assertEquals(board.get(0, 1), 0);
    }

    @Test
    public void testToString() {
        SudokuBoard board = getSolvedBoard();
        String ss = board.toString();
        String expected = "5 3 4 6 7 8 9 1 2 n\n" +
                "6 7 2 1 9 5 3 4 8 n\n" +
                "1 9 8 3 4 2 5 6 7 n\n" +
                "8 5 9 7 6 1 4 2 3 n\n" +
                "4 2 6 8 5 3 7 9 1 n\n" +
                "7 1 3 9 2 4 8 5 6 n\n" +
                "9 6 1 5 3 7 2 8 4 n\n" +
                "2 8 7 4 1 9 6 3 5 n\n" +
                "3 4 5 2 8 6 1 7 9 n\n";
        assertEquals(expected, ss);
    }

    @Test
    public void testBoxContains() {
        SudokuBoard board = Puzzles.initializeBoard(BOX_TESTER);

        // left
        int row = 0;
        int col = 0;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        row += 3;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        row += 3;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        // middle
        row = 0;
        col = 3;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        row += 3;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        row += 3;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        // right
        row = 0;
        col = 6;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        row += 3;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);

        row += 3;
        board.set(row, col, 1);
        assertEquals(false, board.setIfSafe(row + 1, col + 1, 1));
        assertEquals(false, board.setIfSafe(row + 2, col + 2, 1));
        board.unset(row, col);
    }

    @Test
    public void topRightBoxContains() {
        SudokuBoard board = Puzzles.initializeBoard(BOX_TESTER);
        boolean b1 = board.setIfSafe(1, 8, 3);
        boolean b2 = board.setIfSafe(2, 7, 3);

        assertEquals(true, b1);
        assertEquals(false, b2);
    }
}