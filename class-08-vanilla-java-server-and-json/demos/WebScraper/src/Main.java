import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static String STATE_LIST_URL = "https://en.wikipedia.org/wiki/List_of_states_and_territories_of_the_United_States#States";

  public static void main(String[] args) {
    try {
      long start = System.currentTimeMillis();

      List<String> statePageUrls = scrapeStateListForStatePageUrl(STATE_LIST_URL);
      List<Integer> populations = scrapeStagePages(statePageUrls);

      int totalPopulation = sum(populations);
      System.out.println("Total population: " + totalPopulation);


      long end = System.currentTimeMillis();
      long delta = end - start;
      System.out.println("Program took: " + (delta / 1000) + "." + (delta % 1000) + "s");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("ERROR: problem connecting to " + STATE_LIST_URL);
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

  public static List<Integer> scrapeStagePages(List<String> urls) {
    List<Integer> populations = new ArrayList<>();

    for (String url : urls) {
      try {
        int population = scrapeStatePopulation(url);
        populations.add(population);
      } catch (IOException e) {
        System.out.println("ERROR: problem fetching population from " + url);
      }
    }

    return populations;
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
