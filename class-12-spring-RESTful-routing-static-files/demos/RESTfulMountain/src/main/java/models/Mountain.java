package models;

public class Mountain {
    private static int ID_COUNT = 12_543;

    public int id;
    public String name;
    public int elevation;

    public Mountain(String name, int elevation) {
        this.id = ID_COUNT++;
        this.name = name;
        this.elevation = elevation;
    }

    public String toString() {
        return this.name + " @ " + this.elevation + "ft";
    }
}
