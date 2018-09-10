import java.io.File;
import java.io.IOException;
import java.util.*;

public class DictionaryReader {
    public static Map<Integer, List<String>> wordsByLength(String filepath) {
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(filepath));
            while (scanner.hasNextLine()) {
                // read word from dictionary
                String word = scanner.nextLine();

                // get it's length and look up words of same length
                int length = word.length();
                List<String> list = wordsByLength.get(length);

                // initialize list of words of same length
                if (list == null) {
                    list = new ArrayList<>();
                    wordsByLength.put(length, list);
                }

                // add word to list of words with same length
                list.add(word);
            }
        } catch (IOException e) {

        }
        return  wordsByLength;
    }
}
