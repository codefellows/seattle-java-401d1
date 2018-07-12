import java.util.Arrays;

public class Stutter {

    // doubles the length of an array
    // and fills the new array so each original element
    // appears twice in the new array.
    public static int[] stutter(int[] aa) {
        int[] result = new int[aa.length * 2];

        int index = 0;
        for (int val : aa) {
            result[index] = val;
            result[index + 1] = val;
            index += 2;
        }

        return result;
    }

    // removes the last element of an array
    public static int[] pop(int[] aa) {
        int[] result = new int[aa.length - 1];
        for (int i = 0; i < aa.length - 1; i++) {
            result[i] = aa[i];
        }
        return result;
    }
}
