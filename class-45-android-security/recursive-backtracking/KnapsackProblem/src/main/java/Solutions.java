import java.util.HashSet;
import java.util.Set;

public class Solutions {
    public Set<Knapsack> solutions;
    int bestSoFar;

    public Solutions() {
        solutions = new HashSet<>();
        bestSoFar = 0;
    }

    public void addIfBetter(Knapsack sack) {
        int value = sack.value();
        if (value > bestSoFar) {
            solutions.add(sack.copy());
            bestSoFar = value;
        }
    }

    public Set<Knapsack> getBestSolutions() {
        int bestScore = 0;

        for (Knapsack sack : solutions) {
            bestScore = Math.max(bestScore, sack.value());
        }

        Set<Knapsack> bests = new HashSet<>();
        for (Knapsack sack : solutions) {
            if (sack.value() == bestScore) {
                bests.add(sack);
            }
        }

        return bests;
    }
}
