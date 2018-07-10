import java.util.HashSet;
import java.util.Set;

public class Dice {
    public static void main(String[] args) {
        // use a set to keep track of rolls we've seen so far.
        Set<Integer> seen = new HashSet<>();
        int rolls = 0;

        while (seen.size() < 6) {
            int roll = (int) Math.ceil(6 * Math.random());
            System.out.println(roll);

            if (!seen.contains(roll)) {
                System.out.println("new roll!");
            }

            seen.add(roll);
            rolls++;
        }
        System.out.println("Took " + rolls + " to roll all rolls.");
    }
}
