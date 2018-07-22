import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CodeFellowsCourses {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.codefellows.org/courses/code-400/").get();
            Elements courseTitles = doc.select("h3");
            for (Element title : courseTitles) {
                System.out.println(title.text());
            }
        } catch (IOException e) {
            System.out.println("Error connecting to webpage.");
        }
    }
}
