public class Counter {
    private int value;
    public Counter() {
        this.value = 0;
    }

    public int increment() {
        this.value++;
        return this.value;
    }

    public int decrement() {
        this.value--;
        return this.value;
    }

    public int value() {
        return this.value;
    }
}
