import com.sun.org.apache.xpath.internal.operations.Bool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.jvm.hotspot.debugger.Page;

import java.io.IOException;
import java.util.*;

public class WikiRacer {
  // Nintendo_64 to Bread goes fast.
  // This one takes a while to find.
  // https://en.wikipedia.org/wiki/Bill Clinton
  // https://en.wikipedia.org/wiki/Al_Gore
  // https://en.wikipedia.org/wiki/Apple_Inc.
  // https://en.wikipedia.org/wiki/Alan_Turing
  //public static String START = "https://en.wikipedia.org/wiki/Bill Clinton";
  //public static String FINISH = "https://en.wikipedia.org/wiki/Alan_Turing";
  public static String START = "https://en.wikipedia.org/wiki/Nintendo 64";
  public static String FINISH = "https://en.wikipedia.org/wiki/Philisophy";
  public static boolean ALL_WEB = false;

  public static void main(String[] args) {
    PageLinkHistory page = explore(START);
    System.out.println();

    if (page == null) {
      System.out.println("No path found!");
    }

    List<String> path = page.history();
    for (String step : path) {
      System.out.println(step);
    }
  }

  public static PageLinkHistory explore(String current) {
    Queue<PageLinkHistory> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    PageLinkHistory page = new PageLinkHistory(current);
    q.add(page);

    return explore(q, visited);
  }

  public static PageLinkHistory explore(Queue<PageLinkHistory> q, Set<String> visited) {
    while (!q.isEmpty()) {
      PageLinkHistory current = q.remove();

      if (visited.contains(current.url)) {
        continue;
      }

      try {
        System.out.println("Exploring at depth " + current.depth + ": " + current);
        Document doc = Jsoup.connect(current.url).get();
        Elements links = doc.select("a");

        visited.add(current.url);

        // look and see if it's here
        for (Element a : links) {
          String url = a.absUrl("href");

          PageLinkHistory page = new PageLinkHistory(url, current);
          if (url.equals(FINISH)) {
            return page;
          } else if (isWiki(url)) {
            q.add(page);
          }
        }
      } catch (IOException e) {
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid URL: " + current.url);
      }
    }

    return null;
  }

  public static boolean isWiki(String url) {
    String[] badStuff = {"#", "png", "jpg"};
    for (String badThing : badStuff) {
      if (url.contains(badThing)) {
        return false;
      }
    }

    if (ALL_WEB) {
      return true;
    }

    String[] badWikiStuff = {
      "Special:", "Template:", "Wikipedia:", "Mediawiki:", "User:",
      "File:", "Help:", "Book:", "Category:", "talk:"
    };
    for (String badWikiThing : badWikiStuff) {
      if (url.contains(badWikiThing)) {
        return false;
      }
    }

    String wikiPart = "://en.wikipedia.org/wiki/";
    return url.contains(wikiPart);
  }
}
