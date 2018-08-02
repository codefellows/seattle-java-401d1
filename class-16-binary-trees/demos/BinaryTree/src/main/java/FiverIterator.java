import java.util.Iterator;

public class FiverIterator<E> implements Iterator<E> {
    private int count;
    private Fiver<E> fiver;

    public FiverIterator(Fiver tenner) {
        this.count = 1;
        this.fiver = tenner;
    }

    @Override
    // this iterator is considered to have something
    // next (or, have more stuff left in one iteration)
    // as long as the count is below ten
    public boolean hasNext() {
        return this.count <= Fiver.FIVE;
    }

    @Override
    public E next() {
        E result =this.fiver.get(this.count);
        this.count++;
        return result;
    }
}
