package day04;

public class LargestProduct {
    // assumes all the integers are non-negative.
    // if negative numbers are present then starting max at zero
    // will be problematic if the maximum product in the entire data
    // turns out to be a negative number.
    //
    // {1, 2, 1},
    // {2, 4, 2},
    // {3, 6, 8},
    // {7, 8, 1}
    public static int largestProduct(int[][] aa) {
        int max = 0;
        for (int row = 0; row < aa.length; row++) {
            for (int col = 0; col < aa[row].length; col++) {
                int product = checkBestNeighbor(aa, row, col);
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    // returns the largest product from the perspective of one cell.
    // only checks in four of eight directions, as the rest of the
    // directions will be checked as the outer for loops move through
    // all the cells.
    //
    // xxx  c - the center cell
    // xcy  x - no this direction is not checked from the center cell
    // yyy  y - yes this direction is checked from the center cell
    private static int checkBestNeighbor(int[][] aa, int row, int col) {
        int cell = aa[row][col];
        int max = 0;

        // check right, bottom right, bottom, bottom left
        max = Math.max(max, cell * getCellValue(aa, row, col + 1));
        max = Math.max(max, cell * getCellValue(aa, row + 1, col + 1));
        max = Math.max(max, cell * getCellValue(aa, row + 1, col));
        max = Math.max(max, cell * getCellValue(aa, row + 1, col - 1));
        return max;
    }

    // one method that does all bound-checking.
    // returns the actual value at the row col,
    // or returns 0 if the row col is out of bounds.
    private static int getCellValue(int[][] aa, int row, int col) {
        // check all bounds to make sure it doesn't run off
        // the top, the left, the bottom or the right.
        if (row < 0 || col < 0 || row >= aa.length || col >= aa[row].length) {
            return 0;
        }

        // must be a safe access! return the actual value in the array.
        return aa[row][col];
    }
}
