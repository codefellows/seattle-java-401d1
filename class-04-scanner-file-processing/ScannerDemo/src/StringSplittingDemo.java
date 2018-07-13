import java.util.Arrays;

public class StringSplittingDemo {
    public static void main(String[] args) {
        String input = "navfz (187) -> jviwcde, wfwor, vpfabxa";
        String[] cells = input.split(" -> ");
        System.out.println(Arrays.toString(cells));

        String[] cells2 = input.split(" ");
        System.out.println(Arrays.toString(cells2));
        System.out.println();

        String person1 = "Sir Rygnand Reginald the Third";
        String person2 = "Queen Victoria the Magnificient";
        String person3 = "Charlie";

        String[] persons = {person1, person2, person3};
        for (String person : persons)
            if (person.contains("the")) System.out.println("Royalty: " + person);
            else System.out.println("petty commoner: " + person);
        System.out.println("This line executes once after the for loop.");
    }
}
