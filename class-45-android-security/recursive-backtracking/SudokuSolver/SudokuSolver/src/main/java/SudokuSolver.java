import java.util.Scanner;

public class SudokuSolver {
    public static int COUNT = 0;
    public static Scanner input = new Scanner(System.in);

    public static class Coord {
        public int row;
        public int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        SudokuBoard board = Puzzles.initializeBoard(Puzzles.EXAMPLE2);

        explore(board);
        System.out.println(board);

        long end = System.currentTimeMillis();
        long delta = end - start;
        System.out.println(delta);
    }

    public static Coord findEmptyCoord(SudokuBoard board) {
        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            for (int col = 0; col < SudokuBoard.SIZE; col++) {
                if (board.get(row, col) == 0) {
                    return new Coord(row, col);
                }
            }
        }
        return null;
    }


    // Find row, col of an unassigned cell
    // If there is none, return true
    // For digits from 1 to 9
    //  a) If there is no conflict for digit at row,col
    //     assign digit to row,col and recursively try fill in rest of grid
    //  b) If recursion successful, return true
    //  c) Else, remove digit and try another
    // If all digits have been tried and nothing worked, return false
    public static boolean explore(SudokuBoard board) {
        // finish exploration if there's no empty coordinates
        Coord coord = findEmptyCoord(board);
        if (coord == null) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            boolean isSet = board.setIfSafe(coord.row, coord.col, i);
            if (isSet) {
//                System.out.println(coord.row + " " + coord.col + " " + i);
//                System.out.println(board);
//                try {
//                    //Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (explore(board)) {
                    return true;
                }
                board.unset(coord.row, coord.col);
            }
        }
        return false;
    }
}
