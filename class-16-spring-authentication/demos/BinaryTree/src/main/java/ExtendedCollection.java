import java.util.Iterator;

// no you cannot extend an interface. you must "implement" it.
//public class ExtendedCollection<T> extends Iterable<T> {
public class ExtendedCollection<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
