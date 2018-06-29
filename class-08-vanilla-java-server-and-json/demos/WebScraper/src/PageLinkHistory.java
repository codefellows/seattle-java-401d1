import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PageLinkHistory {
  // the URL of one page
  String url;

  // the page leading to this page.
  PageLinkHistory parent;

  // number of steps away from the starting page.
  int depth;

  public PageLinkHistory(String url) {
    this.url = url;
    this.parent = null;
    this.depth = 0;
  }

  public PageLinkHistory(String url, PageLinkHistory parent) {
    this.url = url;
    this.parent = parent;
    this.depth = parent.depth + 1;
  }

  public List<String> history() {
    List<String> history = new LinkedList<>();
    history.add(0, this.url);

    PageLinkHistory current = this.parent;
    while (current != null) {
      history.add(0, current.url);
      current = current.parent;
    }
    return history;
  }

  public String toString() {
    return this.url;
  }
}
