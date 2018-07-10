public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!!");

        String name = "Steve";
        int n = 4242;
        boolean isOdd = true;

        float ff = .123243545454545454545454f;
        double dd = .123243545454545454545454;

        System.out.println("ff" + ff);
        System.out.println("dd" + dd);

        for (int i = 0; i < 10; i++) {
            System.out.println("is " + i + " even? " + isEven(i));
        }
    }

    public static int doubler(int n) {
        return n * 2;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
