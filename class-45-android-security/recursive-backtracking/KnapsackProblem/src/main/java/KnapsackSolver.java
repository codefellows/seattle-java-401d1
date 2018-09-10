import java.util.HashSet;
import java.util.Set;

public class KnapsackSolver {
    public static void main(String[] args) {
        // Solution: Solution:
        // if any number of each box is available, then
        // three yellow boxes and three gray boxes
        //
        // if only the shown boxes are available,
        // then all but the green box.
        Set<Item> items = new HashSet<>();
        items.add(new Item(4, 12, "green"));
        items.add(new Item(2, 2, "blue"));
        items.add(new Item(2, 1, "gray"));
        items.add(new Item(1, 1, "red"));
        items.add(new Item(10, 4, "yellow"));

        int maxWeight = 15;
        Knapsack sack = new Knapsack(maxWeight, items);
        Solutions solutions = new Solutions();

        System.out.println("Start:");
        System.out.println(sack);

        explore(sack, items, solutions);

        System.out.println("Solutions:");
        for (Knapsack solution : solutions.getBestSolutions()) {
            System.out.println(solution.toString());
        }
    }

    public static void explore(Knapsack sack, Set<Item> items, Solutions solutions) {
        solutions.addIfBetter(sack);

        for (Item item : items) {
            boolean isAdded = sack.addIfRoom(item);
            if (isAdded) {
                //System.out.println(sack);
                explore(sack, items, solutions);
                sack.remove(item);
            }
        }
    }
}
