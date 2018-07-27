public class ObjectStack {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;

    // points to the next empty index of the array
    private int back;

    public ObjectStack() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.back = 0;
    }

    public int size() {
        return this.back;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void push(Object value) {
        if (this.back == this.data.length) {
            this.grow();
        }

        this.data[this.back] = value;
        this.back++;
    }

    public Object pop() {
        this.back--;
        Object result = this.data[this.back];
        this.data[this.back] = 0;
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
        Object[] doubled = new Object[this.data.length * 2];

        int index = 0;
        for (Object val : this.data) {
            doubled[index] = val;
            index++;
        }
        this.data = doubled;
    }
}
