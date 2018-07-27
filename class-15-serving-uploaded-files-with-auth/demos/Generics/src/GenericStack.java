public class GenericStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] data;

    // points to the next empty index of the array
    private int back;

    public GenericStack() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
        this.back = 0;
    }

    public int size() {
        return this.back;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void push(E value) {
        if (this.back == this.data.length) {
            this.grow();
        }

        this.data[this.back] = value;
        this.back++;
    }

    public E pop() {
        this.back--;
        E result = this.data[this.back];
        this.data[this.back] = null;
        return result;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < this.back; i++) {
            result += " " + this.data[i];
        }
        return result + "]";
    }

    private void grow() {
        E[] doubled = (E[]) new Object[this.data.length * 2];

        int index = 0;
        for (E val : this.data) {
            doubled[index] = val;
            index++;
        }
        this.data = doubled;
    }
}
