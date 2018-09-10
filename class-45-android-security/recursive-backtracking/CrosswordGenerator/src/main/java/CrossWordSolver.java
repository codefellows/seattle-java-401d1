import java.io.File;
import java.util.List;
import java.util.Map;

public class CrossWordSolver {
    public static void main(String[] args) {
        String dictionary = CrossWordSolver.class.getClassLoader().getResource("dictionary.txt").getFile();
        Map<Integer, List<String>> words = DictionaryReader.wordsByLength(dictionary);

        CrossWord crossWord = new CrossWord(CrossWordInputs.small);

        boolean result = explore(crossWord, words);
        if (result) {
            System.out.println("Solved!");
        } else {
            System.out.println("unsolved");
        }
        System.out.println(crossWord);
    }

    public static boolean explore(CrossWord puzzle, Map<Integer, List<String>> words) {
        if (puzzle.isSolved()) {
            System.out.println(puzzle);
            return false;
        }

        Clue clue = puzzle.getUnsolvedClue();
        if (clue != null) {
            if (clue.isAcross() && !clue.isSolvedAcross()) {
                List<String> wordsOfLength = words.get(clue.getLengthAcross());
                for (String word : wordsOfLength) {
                    boolean isValid = puzzle.attemptClueAcross(clue, word);
                    if (isValid) {
                        if (explore(puzzle, words)) {
                            return true;
                        }
                        puzzle.unsetClueAcross(clue);
                    }
                }

            }

            if (clue.isDown() && !clue.isSolvedDown()) {
                List<String> wordsOfLength = words.get(clue.getLengthDown());
                for (String word : wordsOfLength) {
                    boolean isValid = puzzle.attemptClueDown(clue, word);
                    if (isValid) {
                        if (explore(puzzle, words)) {
                            return true;
                        }
                        puzzle.unsetClueDown(clue);
                    }
                }
            }
        }
        return false;
    }
}
