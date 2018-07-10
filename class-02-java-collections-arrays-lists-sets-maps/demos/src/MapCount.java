import java.util.*;

public class MapCount {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int randomNumber = (int) Math.floor(50 * Math.random());
            numbers.add(randomNumber);
        }

        System.out.println(numbers);

        // JavaScript equivalent
        // jsmap = {};
        // if (!jsmap["odd"]) {
        //   jsmap["odd"] = 0;
        // }
        // jsmap["odd"] = jsmap["odd"] + 1;

        // create a map to store how many times we've seen
        // each type of number (even or odd)
        Map<String, Integer> tally = new HashMap<>();

        // go through the list of random numbers
        // and tally up how many there are of each type even/odd
        for (int i = 0; i < numbers.size(); i++) {
            String key;
            int value = numbers.get(i);
            if (value % 2 == 0) {
                key = "even";
            } else {
                key = "odd";
            }

            // initialize the value of the key to zero
            // before we try to increment for the first time.
            if(!tally.containsKey(key)) {
               tally.put(key, 0);
            }

            int votesSoFar = tally.get(key);
            tally.put(key, votesSoFar + 1);
        }

        System.out.println("Total even: " + tally.get("even"));
        System.out.println("Total odd: " + tally.get("odd"));
    }
}
