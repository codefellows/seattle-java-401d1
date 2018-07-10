public class TwoDimensionalArrays {
    public static void main(String[] args) {
        int[][] luckyNumbers = {
                {67, 68, 69, 69, 53},
                {2, 64, 7, 4312, 56},
                {43, 65, 2, 42, 73},
                {43, 99},
                {54, 65, 76, 43, 235, 23, 1}
        };

        int total = addLuckyNumbers(luckyNumbers);
        System.out.println(total);
    }

    public static int addLuckyNumbers(int[][] aa) {
        int total = 0;

        for (int row = 0; row < aa.length; row++) {
            for (int col = 0; col < aa[row].length ; col++) {
                int value = aa[row][col];
                if (value % 2 == 0) {
                    total += value;
                }
            }
        }

        return total;
    }
}
