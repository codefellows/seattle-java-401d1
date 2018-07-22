import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class KEXPPlaylist {
    public static void main(String[] args) throws IOException {
        Document kexp = Jsoup.connect("http://kexp.org/playlist").get();
        System.out.println(kexp.html());
        Elements songs = kexp.select(".PlaylistItem-primaryContent");
        for (Element song : songs) {
            String title = song.select("h3").text();
            String artist = song.child(1).text();
            System.out.println(title + " by " + artist);
            System.out.println();
        }
    }
}
