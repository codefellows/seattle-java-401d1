public class Main {
    public static void main(String[] args) {
       Fiver<String> cheeses = new Fiver<>(
               "cheddar", "feta", "pepper jack", "mozarella", "swiss"
       );

       // oops, this shouldn't start at zero!
       // off-by-one-error!
       // for (int i = 0; i < Fiver.FIVE; i++) {
       //     System.out.println(cheeses.get(i));
       // }
       // System.out.println();

       // prefer for-each loops to prevent silly errors.
       for (String cheese : cheeses) {
           System.out.println(cheese);
       }
    }
}
