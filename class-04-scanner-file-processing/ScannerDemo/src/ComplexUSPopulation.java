import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComplexUSPopulation {
    public static void main(String[] args) {
        String filename = "/Users/moonmayor/Fellows/one-java/seattle-java-401d1/class-04-scanner-file-processing/ScannerDemo/src/complex_state_data.txt";
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            int totalPopulation = 0;
            int totalCounties = 0;

            // skip the first line because we know it's just header information
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                // we know every line has a state with maybe a few words
                // and then it ultimately has a number
                // use .next to skip through words on the line
                // until we find the number in the line
                String line = scanner.nextLine();
                try (Scanner lineScanner = new Scanner(line)) {
                    // eats through the tokens making up the state name
                    while (!lineScanner.hasNextInt()) {
                        lineScanner.next();
                    }
                    // snag the one int with the population
                    totalPopulation += lineScanner.nextInt();

                    // eats through the tokens making up the state motto
                    while (!lineScanner.hasNextInt()) {
                        lineScanner.next();
                    }
                    // snag the number of counties
                    totalCounties += lineScanner.nextInt();
                }
            }
            System.out.println("Total Population: " + totalPopulation);
            System.out.println("Total Counties: " + totalCounties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
