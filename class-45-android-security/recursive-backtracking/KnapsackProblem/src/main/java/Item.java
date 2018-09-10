public class Item {
    public int value;
    public int weight;
    public String description;

    public Item(int value, int weight, String description) {
        this.value = value;
        this.weight = weight;
        this.description = description;
    }

    public String toString() {
        return String.format("$%s %skg %s", this.value, this.weight, this.description);
    }
}
