public class ChessBoard {
    public static final int SIZE = 8;
    private Character[][] board;
    private int queens;

    public class Coord {
        public int row;
        public int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public ChessBoard() {
        queens = 0;
        this.board = new Character[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                this.board[row][col] = '.';
            }
        }
    }

    public void set(int row, int col) {
        this.board[row][col] = ("" + (this.numQueens() + 1)).charAt(0);
        this.queens++;
    }

    public void unset(int row, int col) {
        this.board[row][col] = '.';
        this.queens--;
    }

    public Character get(int row, int col) {
        return board[row][col];
    }

    public int numQueens() {
        return this.queens;
    }

    public boolean setIfValid(int row, int col) {
        if (this.board[row][col] != '.') {
            return false;
        }

        set(row, col);
        if (!isValid()) {
            unset(row, col);
            return false;
        }
        return true;
    }

    public boolean isValid() {
        // check rows for dupes
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (this.board[row][col] != '.') {
                    if (!isValid(row, col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValid(int row, int col) {
        // check columns on row
        for (int iCol = 0; iCol < SIZE; iCol++) {
            if (iCol != col && this.board[row][iCol] != '.') {
                return false;
            }
        }

        // check rows on column
        for (int iRow = 0; iRow < SIZE; iRow++) {
            if (iRow != row && this.board[iRow][col] != '.') {
                return false;
            }
        }

        int iRow = row - 1;
        int iCol = col - 1;
        while (iRow >= 0 && iCol >= 0) {
            if (this.board[iRow][iCol] != '.') {
                return false;
            }
            iRow--;
            iCol--;
        }

        iRow = row + 1;
        iCol = col + 1;
        while (iRow < SIZE && iCol < SIZE) {
            if (this.board[iRow][iCol] != '.') {
                return false;
            }
            iRow++;
            iCol++;
        }

        iRow = row - 1;
        iCol = col + 1;
        while (iRow >= 0 && iCol < SIZE) {
            if (this.board[iRow][iCol] != '.') {
                return false;
            }
            iRow--;
            iCol++;
        }

        iRow = row + 1;
        iCol = col - 1;
        while (iRow < SIZE && iCol >= 0) {
            if (this.board[iRow][iCol] != '.') {
                return false;
            }
            iRow++;
            iCol--;
        }

        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                builder.append(this.board[row][col]);
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}
