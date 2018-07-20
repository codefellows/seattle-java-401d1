package models;

public class City {
    public String name;
    public String countryCode;
    public int population;

    @Override
    public String toString() {
        return name + " (" + population + ")";
    }
}
