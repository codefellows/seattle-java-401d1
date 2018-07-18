import java.util.HashSet;
import java.util.Set;

public class HasDuplicates {
    // time: O(N^2)
    // space: O(1)
    public boolean hasDuplicates(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // the same number appears at two different indexes.
                if (i != j && numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // time: O(N) we only have to iterate through the numbers once
    // space: O(N) we have to add all numbers to the Set
    public boolean hasDuplicates2(int[] numbers) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (seen.contains(numbers[i])) {
                return true;
            }
            seen.add(numbers[i]);
        }

        return false;
    }
}
