package core.model;

public class Storage {
    private int id;
    private String location;
    private int capacity;
    private int availableSpace;

    public Storage(int id, String location, int capacity, int availableSpace) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.availableSpace = availableSpace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }

    // Геттеры и сеттеры
}
