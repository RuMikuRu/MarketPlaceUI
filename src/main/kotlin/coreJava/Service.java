package org.example.core;

import org.example.model.Product;

public interface Service {
    void createTables();
    void clearTables();
    void addClient(String name, String surname, String email, String address);
    void addOrder(Integer clientId, Float localPrice);

    void addProduct(String name, Float price, Integer quantity, String description);


    void addStorage(String location, Integer capacity, Integer availableSpace);

    void addShop(String name, String address, String workingHours, Float rating);

    void addEmployee(String name, String surname, String position, Float salary, Integer shopId);

    Product findProductByName(String name);
    void updateProductPrice(String name, Float newPrice);
    void updateClientAddress(String name, String newAddress );
    void deleteProductByName(String name);
    void deleteClientByEmail(String email);
}
