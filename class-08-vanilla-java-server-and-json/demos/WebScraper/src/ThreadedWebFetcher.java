import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadedWebFetcher implements Callable {
  String url;

  public static void main(String[] args) {
    try {
      long start = System.currentTimeMillis();
      List<String> statePageUrls = scrapeStateListForStatePageUrl(Main.STATE_LIST_URL);

      //  1  thread: 6.836s
      // 10 threads: 5.888s
      // 25 threads: 3.218s
      // 50 threads: 2.783s
      int numThreads = 50;
      ExecutorService pool = Executors.newFixedThreadPool(numThreads);

      List<Future<Integer>> futures = new ArrayList<>();
      for (String url : statePageUrls) {
        ThreadedWebFetcher thread = new ThreadedWebFetcher(url);
        Future<Integer> future = pool.submit(thread);
        futures.add(future);
      }

      int totalPopulation = 0;
      for (Future<Integer> future : futures) {
        try {
          totalPopulation += future.get();
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
      }

      long end = System.currentTimeMillis();
      long delta = end - start;

      System.out.println("Total population: " + totalPopulation);
      System.out.println("Threaded program took: " + (delta / 1000) + "." + (delta % 1000) + "s");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ThreadedWebFetcher(String url) {
    this.url = url;
  }

  public Object call() {
    try {
      return scrapeStatePopulation(this.url);
    } catch (IOException e) {
      return 0;
    }
  }

  public static int sum(List<Integer> values) {
    int total = 0;
    for (int n : values) {
      total += n;
    }
    return total;
  }

  public static List<String> scrapeStateListForStatePageUrl(String url) throws IOException {
    String expectedTableCaption = "States of the United States of America";

    Document doc = Jsoup.connect(url).get();
    Elements tables = doc.select("table");

    for (Element table : tables) {
      Elements captionEls = table.select("caption");
      if (captionEls.size() == 1) {
        String caption = captionEls.get(0).text();
        if (caption.equals(expectedTableCaption)) {
          return getStateLinks(table);
        }
      }
    }

    return new ArrayList<>();
  }

  public static List<String> getStateLinks(Element table) {
    Elements rows = table.select("tr");

    List<String> statePageUrls = new ArrayList<>();
    for (Element row : rows) {
      Element link = row.select("a").get(0);
      String url = link.absUrl("href");

      // exclude some specific known not-state URLs
      String nope1 = "https://en.wikipedia.org/wiki/List_of_U.S._state_abbreviations";
      String nope2 = "https://en.wikipedia.org/wiki/Capital_city";

      if (!url.equals(nope1) && !url.equals(nope2)) {
        statePageUrls.add(url);
      }
    }
    return statePageUrls;
  }

  public static int scrapeStatePopulation(String url) throws IOException {
    Document doc = Jsoup.connect(url).get();
    Element infoPanel = doc.select("table.vcard").get(0);

    Elements rows = infoPanel.select("tr");
    for (Element row : rows) {
      if (row.text().contains("Population")) {
        Element nextRow = row.nextElementSibling();
        Element td = nextRow.selectFirst("td");

        String[] urlPaths = url.split("/");
        String stateName = urlPaths[urlPaths.length - 1];

        try {
          String popText = td.text().split(" ")[0].replace(",", "");

          // one-off case for dealing with muddy text on Minnesota's page
          popText = popText.replace("(2017)", "");

          int pop = Integer.parseInt(popText, 10);
          System.out.println(stateName + ": " + pop);
          return pop;
        } catch (NumberFormatException e) {
          System.out.println(stateName + ": error");
          return 0;
        }
      }
    }
    return 0;
  }
}
