import java.awt.*;

public class ThreadRaces {
  public static String winner = null;

  public static void main(String[] args) {
    String usain = "Usain Bolt";
    String prefontaine = "Steve Prefontaine";

    RandomWaiter r1 = new RandomWaiter(usain);
    RandomWaiter r2 = new RandomWaiter(prefontaine);

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();

    while (t1.isAlive() || t2.isAlive()) {
      // wait
    }

    System.out.println(winner + " won the race!");
  }

  public static class RandomWaiter implements Runnable {
    // wait a maximum of ten seconds
    int maxWait = 5_000;

    String name;

    public RandomWaiter(String name) {
      this.name = name;
    }

    public void run() {
      try {
        // wait a random amount
        long wait = (long) (Math.random() * this.maxWait);
        System.out.println(this.name + " running for " + wait);
        Thread.sleep(wait);

        System.out.println(this.name + " just finished");

        // try to set yourself as the winner
        if (winner == null) {
          winner = this.name;
        }
      } catch(InterruptedException e) {

      }
    }
  }
}
