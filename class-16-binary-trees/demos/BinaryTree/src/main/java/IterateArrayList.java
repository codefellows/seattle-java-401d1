import java.util.ArrayList;
import java.util.List;

public class IterateArrayList {
    public static void main(String[] args) {
        List<String> foo = new ArrayList<>();
        foo.add("bar");
        foo.add("baz");
        foo.add("qwix");

        boolean hasAddedJustOneThing = false;
        for (String thing : foo) {
            System.out.println(thing);

            if (!hasAddedJustOneThing) {
                foo.add("anything");
                hasAddedJustOneThing = true;
            }
        }
    }
}
