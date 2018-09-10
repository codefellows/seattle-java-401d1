import java.util.HashSet;
import java.util.Set;

public class SudokuBoard {
    public static final int SIZE = 9;
    /*
    0,0 0,1 0,2  0,3 0,4 0,5  0,6 0,7 0,8
    1,0 1,1 1,2  1,3 1,4 1,5  1,6 1,7 1,8
    2,0 2,1 2,2  2,3 2,4 2,5  2,6 2,7 2,8

    3,0 3,1 3,2  3,3 3,4 3,5  3,6 3,7 3,8
    4,0 4,1 4,2  4,3 4,4 4,5  4,6 4,7 4,8
    5,0 5,1 5,2  5,3 5,4 5,5  5,6 5,7 5,8

    6,0 6,1 6,2  6,3 6,4 6,5  6,6 6,7 6,8
    7,0 7,1 7,2  7,3 7,4 7,5  7,6 7,7 7,8
    8,0 8,1 8,2  8,3 8,4 8,5  8,6 8,7 8,8
     */

    private int[][] board;

    public SudokuBoard() {
        this.board = new int[this.SIZE][this.SIZE];
    }

    public int get(int row, int col) {
        return this.board[row][col];
    }

    public void set(int row, int col, int val) {
        this.board[row][col] = val;
    }

    public void unset(int row, int col) {
        this.set(row, col, 0);
    }

    public boolean setIfSafe(int row, int col, int val) {
        if (rowContains(row, val)) {
            return false;
        }
        if (colContains(col, val)) {
            return false;
        }
        if (boxContains(row, col, val)) {
            return false;
        }

        this.board[row][col] = val;
        return true;
    }

    private boolean rowContains(int row, int val) {
        for (int col = 0; col < SIZE; col++) {
            if (this.board[row][col] == val) {
                return true;
            }
        }
        return false;
    }

    private boolean colContains(int col, int val) {
        for (int row = 0; row < SIZE; row++) {
            if (this.board[row][col] == val) {
                return true;
            }
        }
        return false;
    }

    private boolean boxContains(int row, int col, int val) {
        int minRow = (row / 3) * 3;
        int minCol = (col / 3) * 3;
        int maxRow = minRow + 3;
        int maxCol = minCol + 3;

        row = minRow;
        col = minCol;

        while (row < maxRow) {
            col = minCol;
            while(col < maxCol) {
                int cellVal = this.board[row][col];
                if (cellVal == val) {
                    return true;
                }
                col++;
            }
            row++;
        }
        return false;
    }

    public boolean isBoardComplete() {
        if (!isBoardValid()) {
           return false;
        }

        for (int row = 0; row < this.SIZE; row++) {
            for (int col = 0; col < this.SIZE; col++) {
                int val = this.board[row][col];
                if (val == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardValid() {
        for (int i = 0; i < this.SIZE; i++) {
            if (!isRowValid(i))  {
                return false;
            }
            if (!isColValid(i))  {
                return false;
            }
        }

        isBoxValid(0, 0, 0, 3);
        isBoxValid(0, 3, 0, 6);
        isBoxValid(0, 6, 0, 9);

        isBoxValid(3, 0, 3, 3);
        isBoxValid(3, 3, 3, 6);
        isBoxValid(3, 6, 3, 9);

        isBoxValid(6, 0, 6, 3);
        isBoxValid(6, 3, 6, 6);
        isBoxValid(6, 6, 6, 9);

        return true;
    }

    private boolean isBoxValid(int minRow, int minCol, int maxRow, int maxCol) {
        int row = minRow;
        int col = minCol;

        Set<Integer> seen = new HashSet<>();
        while (row < maxRow) {
            while (col < maxCol) {
                int val = this.board[row][col];
                if (val != 0) {
                    if (seen.contains(val)) {
                        return false;
                    }
                    seen.add(val);
                }
                col++;
            }
            row++;
        }
        return true;
    }

    private boolean isRowValid(int row) {
        Set<Integer> seen = new HashSet<>();
        for (int col = 0; col < this.SIZE; col++) {
            int val = this.board[row][col];
            if (val != 0) {
                if (seen.contains(val)) {
                    return false;
                }
                seen.add(val);
            }
        }
        return true;
    }

    private boolean isColValid(int col) {
        Set<Integer> seen = new HashSet<>();
        for (int row = 0; row < this.SIZE; row++) {
            int val = this.board[row][col];
            if (val != 0) {
                if (seen.contains(val)) {
                    return false;
                }
                seen.add(val);
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < this.SIZE; row++) {
            for (int col = 0; col < this.SIZE; col++) {
                int val = this.board[row][col];
                builder.append(val + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
 }
