public class RandomChooser {
    public static void main(String[] args) {
        int choice = (int) Math.floor(args.length * Math.random());
        System.out.println(args[choice]);
    }
}
