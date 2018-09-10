public class SolveEightQueens {
    static class Counter {
        int count = 0;
    }
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        System.out.println(board);

        Counter count = new Counter();
        boolean isSolved = explore(board, count);
        System.out.println("count: " + count.count);
        if (isSolved) {
            System.out.println("Solved");
        } else {
            System.out.println("Unsolved");
        }
        System.out.println(board);
    }

    public static boolean explore(ChessBoard board, Counter count) {
        if (board.numQueens() == ChessBoard.SIZE) {
            return true;
        }

        for (int row = 0; row < ChessBoard.SIZE; row++) {
            for (int col = 0; col < ChessBoard.SIZE; col++) {
                count.count++;
                boolean isSet = board.setIfValid(row, col);
                if (isSet) {
                    if (explore(board, count)) {
                        return true;
                    }
                    board.unset(row, col);
                }
            }
        }

        return false;
    }
}
