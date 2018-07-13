import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USPopulation {
    public static void main(String[] args) {
        String filename = "/Users/moonmayor/Fellows/one-java/seattle-java-401d1/class-04-scanner-file-processing/ScannerDemo/src/states.txt";
        File file = new File(filename);

        try {
            int total = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int statePopulation = scanner.nextInt();
                    System.out.println("nextInt: " + statePopulation);
                    total += statePopulation;
                } else {
                    String next = scanner.next();
                    System.out.println("next: " + next);
                }
            }
            System.out.println("Total: " + total);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
