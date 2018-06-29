import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void verifyEmptySum() {
    List<Integer> nums = new ArrayList<>();
    assertEquals(0, Main.sum(nums));
  }

  @Test
  public void verifySum() {
    List<Integer> nums = new ArrayList<>();
    nums.add(1);
    nums.add(2);
    nums.add(4);
    assertEquals(7, Main.sum(nums));
  }

  @Test
  public void verify50States() throws IOException {
    List<String> statePageUrls = Main.scrapeStateListForStatePageUrl(Main.STATE_LIST_URL);
    assertEquals(50, statePageUrls.size());
  }

  @Test
  public void verifyStatePopulation() throws IOException {
    String alabamaUrl = "https://en.wikipedia.org/wiki/Alabama";
    int population = Main.scrapeStatePopulation(alabamaUrl);
    assertEquals(4_863_300, population);
  }
}