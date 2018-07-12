public class MyArrayList {
    private int DEFAULT_SIZE = 10;

    private int[] data;
    private int elements;

    public MyArrayList() {
        this.data = new int[DEFAULT_SIZE];
        this.elements = 0;
    }

    // adds a value to the end of the list
    public void add(int value) {
        this.data[this.elements] = value;
        this.elements++;
    }
}
