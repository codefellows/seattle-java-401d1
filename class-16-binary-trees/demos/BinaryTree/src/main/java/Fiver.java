import java.util.Iterator;

// this class is built to store ten things.
public class Fiver<E> implements Iterable<E> {
    public static final int FIVE = 5;

    private E one;
    private E two;
    private E three;
    private E four;
    private E fifth;

    public Fiver(E one, E two, E three, E four, E five) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.fifth = five;
    }

    public E get(int i) {
        if (i == 1) {
            return this.one;
        } else if (i == 2) {
            return this.two;
        } else if (i == 3) {
            return this.three;
        } else if (i == 4) {
            return this.four;
        } else  if (i == 5) {
            return this.fifth;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new FiverIterator<E>(this);
    }
}
