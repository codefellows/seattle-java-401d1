import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MirrorList {
    List<String> m1;
    List<String> m2;

    public MirrorList() {
        List<String> m1 = new ArrayList<>();
        List<String> m2 = new LinkedList<>();
    }

    public void add(String ss) {
        m1.add(ss);
        m2.add(ss);
    }
}
