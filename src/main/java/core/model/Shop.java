package core.model;

public class Shop {
    private int id;
    private String name;
    private String address;
    private String workingHours;
    private float rating;

    public Shop(int id, String name, String address, String workingHours, float rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.workingHours = workingHours;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    // Геттеры и сеттеры
}
