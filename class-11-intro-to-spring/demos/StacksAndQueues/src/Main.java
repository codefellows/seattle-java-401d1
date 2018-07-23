import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> qq = new LinkedList<>();
        qq.add("Joe");
        qq.add("Curly");
        qq.add("Lisa");
        qq.add("Marge");
        qq.add("Trent");
        qq.add("Harry");

        int killNumber = 1000000;
        while (qq.size() > 1) {
            for (int count = 0; count < killNumber; count++) {
               String person = qq.remove();
               qq.add(person);
            }
            String removed = qq.remove();
            System.out.println("removed: " + removed);
        }

        System.out.println("Winner: " + qq.remove());
    }
}
