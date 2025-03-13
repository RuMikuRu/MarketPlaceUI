package core.model;

import java.util.Date;

public class Order {
    private int id;
    private int clientId;
    private Date orderDate;
    private float localPrice;

    public Order(int id, int clientId, Date orderDate, float localPrice) {
        this.id = id;
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.localPrice = localPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public float getLocalPrice() {
        return localPrice;
    }

    public void setLocalPrice(float localPrice) {
        this.localPrice = localPrice;
    }

    // Геттеры и сеттеры
}
