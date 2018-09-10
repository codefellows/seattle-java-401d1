import java.util.*;

public class Knapsack {
    private int weight;
    private int maxWeight;

    private Set<Item> availableItems;
    private Map<Item, Integer> storedItems;

    public Knapsack(int maxWeight, Set<Item> items) {
        this.weight = 0;
        this.maxWeight = maxWeight;

        this.availableItems = items;
        this.storedItems = new HashMap<>();

        for (Item item : items) {
            storedItems.put(item, 0);
        }
    }

    public int capacity() {
        return this.maxWeight - this.weight;
    }

    public int value() {
        int total = 0;
        for (Map.Entry<Item, Integer> entry : storedItems.entrySet()) {
            total += entry.getKey().value * entry.getValue();
        }
        return total;
    }

    public boolean addIfRoom(Item item) {
        if (weight + item.weight <= this.maxWeight) {
            this.add(item);
            return true;
        }
        return false;
    }

    public void add(Item item) {
        int count = storedItems.get(item);
        count++;
        storedItems.put(item, count);
        this.weight += item.weight;
        if (this.weight > this.maxWeight) {
            System.out.println("added " + item + " for " + this.weight);
        }
    }

    public void remove(Item item) {
        int count = storedItems.get(item);
        count--;
        storedItems.put(item, count);
        this.weight -= item.weight;
    }

    public Knapsack copy() {
        Knapsack copy = new Knapsack(this.maxWeight, this.availableItems);
        for (Map.Entry<Item, Integer> entry : this.storedItems.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                copy.add(entry.getKey());
            }
        }
        return copy;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        String format = "Total: $%d %d/%dkg\n";
        builder.append(String.format(format, this.value(), this.weight, this.maxWeight));

        for (Map.Entry<Item, Integer> itemCount : this.storedItems.entrySet()) {
            builder.append("  " + itemCount.getValue() + "x " + itemCount.getKey() + "\n");
        }
        return builder.toString();
    }
}
