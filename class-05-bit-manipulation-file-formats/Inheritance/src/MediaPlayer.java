import media.MP3Media;
import media.MP4Media;
import media.Media;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
    public static void main(String[] args) {
        List<Media> playlist = new ArrayList<>();
        playlist.add(new MP3Media("michaeljackson.mp3"));
        playlist.add(new MP4Media("thriller_video.mp4"));
    }
}
