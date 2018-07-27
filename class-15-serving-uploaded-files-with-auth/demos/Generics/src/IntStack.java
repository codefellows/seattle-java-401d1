public class IntStack {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] data;

    // points to the next empty index of the array
    private int back;

    public IntStack() {
        this.data = new int[DEFAULT_CAPACITY];
        this.back = 0;
    }

    public int size() {
        return this.back;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void push(int value) {
        if (this.back == this.data.length) {
            this.grow();
        }

        this.data[this.back] = value;
        this.back++;
    }

    public int pop() {
        this.back--;
        int result = this.data[this.back];
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
        int[] doubled = new int[this.data.length * 2];

        int index = 0;
        for (int val : this.data) {
            doubled[index] = val;
            index++;
        }
        this.data = doubled;
    }
}
