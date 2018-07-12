package day04;

public class ManyIfLargestProduct {
  public static int largestProduct(int[][] aa) {
    int max = aa[0][0] * aa[0][1];
    for (int row = 0; row < aa.length; row++) {
      for (int col = 0; col < aa.length; col++) {
        int product = localProduct(aa, row, col);
        if (product > max) {
          max = product;
        }
      }
    }
    return max;
  }

  public static int localProduct(int[][] aa, int row, int col) {
    int cell = aa[row][col];
    int max = 0;
    // right
    if ((col + 1) < aa[row].length) {
      max = Math.max(max, cell * aa[row][col + 1]);
    }
    // bottom right
    if ((col + 1) < aa[row].length && (row + 1) < aa.length) {
      max = Math.max(max, cell * aa[row + 1][col + 1]);
    }
    // bottom
    if ((row + 1) < aa.length) {
      max = Math.max(max, cell * aa[row + 1][col]);
    }
    // bottom left
    if (row + 1 < aa.length && col - 1 > 0) {
      max = Math.max(max, cell * aa[row + 1][col - 1]);
    }
    return max;
  }
}
