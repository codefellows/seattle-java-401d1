import java.util.Date;

public class Arrays {
    public static void main(String[] args) {
        // investiateTypes();
        //investigateRearrangements();
        maxArray();
    }

    public static void maxArray() {
        //     MAX_VALUE: java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        // MAX_VALUE - 5: java.lang.OutOfMemoryError: Java heap space
        // integers have 32 bits
        // 32 * 2_147_483_647 => 64 billion bits => 8,000 megabytes => 8 gigabytes
        int[] max = new int[Integer.MAX_VALUE - 6];
        for (int i = 0; i < max.length; i++) {
            max[i] = i;
            System.out.println(i);
        }
    }

    public static void investigateRearrangements() {
        String[] stooges = new String[10];
        investigate(stooges);

        stooges[0] = "Larry";
        investigate(stooges);

        stooges[1] = stooges[0];
        investigate(stooges);

        stooges[0] = "Larry";
        stooges[1] = "Moe";
        stooges[2] = "Curly";
        investigate(stooges);

        stooges[3] = "Shemp";
        investigate(stooges);
    }

    public static void investiateTypes() {
        // These are all primitive values (which aren't references)
        // so they actually get default values like 0, 0.0, false.
        // https://en.wikibooks.org/wiki/Java_Programming/Primitive_Types
        int[] aa = new int[6];
        investigate(aa);

        char[] cc = new char[6];
        investigate(cc);

        float[] ff = new float[6];
        investigate(ff);

        double[] dd = new double[6];
        investigate(dd);

        boolean[] bb = new boolean[6];
        investigate(bb);

        // Strings are objects, not primitives so the array
        // starts with null references.
        String[] ss = new String[6];
        investigate(ss);

        Date[] dates = new Date[6];
        investigate(dates);
    }

    public static void investigate(int[] aa) {
        System.out.println("ah, an integer array!");
        for (int i = 0; i < aa.length; i++) {
            System.out.println("index " + i + ": " + aa[i]);
        }
    }

    public static void investigate(char[] aa) {
        System.out.println("ah, a character array!");
        for (int i = 0; i < aa.length; i++) {
            System.out.println("index " + i + ": " + aa[i]);
        }
    }
    public static void investigate(float[] aa) {
        System.out.println("ah, a float array!");
        for (int i = 0; i < aa.length; i++) {
            System.out.println("index " + i + ": " + aa[i]);
        }
    }
    public static void investigate(double[] aa) {
        System.out.println("ah, a double array!");
        for (int i = 0; i < aa.length; i++) {
            System.out.println("index " + i + ": " + aa[i]);
        }
    }
    public static void investigate(boolean[] aa) {
        System.out.println("ah, a boolean array!");
        for (int i = 0; i < aa.length; i++) {
            System.out.println("index " + i + ": " + aa[i]);
        }
    }

    public static void investigate(String[] aa) {
        System.out.println("ah, an String array!");
        int i = 0;
        while (i < aa.length && aa[i] != null) {
            System.out.println("index " + i + ": " + aa[i]);
            i++;
        }
        System.out.println();
    }

    public static void investigate(Date[] aa) {
        System.out.println("ah, a Date array!");
        for (int i = 0; i < aa.length; i++) {
            System.out.println("index " + i + ": " + aa[i]);
        }
    }
}
