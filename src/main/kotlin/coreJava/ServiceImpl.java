package org.example.core;

import org.example.model.Product;

public class ServiceImpl implements Service {

    private final DataBaseCore db = new DataBaseCore();

    public final void init(
            String username,
            String password
    ) {
        db.connectionDB("postgres_user", "postgres_password");
        createTables();
    }

    @Override
    public void createTables() {
        db.callProcedure("create_tables");
    }

    @Override
    public void clearTables() {
        db.callProcedure("clear_tables");
    }

    @Override
    public void addClient(String name, String surname, String email, String address) {
        db.callProcedureWithParam("add_client", name, surname, email, address);
    }

    @Override
    public void addOrder(Integer clientId, Float localPrice) {
        db.callProcedureWithParam("add_order", clientId, localPrice);
    }

    @Override
    public void addProduct(String name, Float price, Integer quantity, String description) {
        db.callProcedureWithParam("add_product", name, price, quantity, description);
    }

    @Override
    public void addStorage(String location, Integer capacity, Integer availableSpace) {
        db.callProcedureWithParam("add_storage", location, capacity, availableSpace);
    }

    @Override
    public void addShop(String name, String address, String workingHours, Float rating) {
        db.callProcedureWithParam("add_shop", name, address, workingHours, rating);
    }

    @Override
    public void addEmployee(String name, String surname, String position, Float salary, Integer shopId) {
        db.callProcedureWithParam("add_employee", name, surname, position, salary, shopId);
    }

    @Override
    public Product findProductByName(String name) {
        var result = db.callProcedureWithParam("find_product_by_name", name);
        try {
            while (result.next()) {
                return new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getFloat("price"),
                        result.getInt("quantity"),
                        result.getString("description")
                        );
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    public void updateProductPrice(String name, Float newPrice) {
        db.callProcedureWithParam("update_product_price", name, newPrice);
    }

    @Override
    public void updateClientAddress(String name, String newAddress) {
        db.callProcedureWithParam("update_client_address", name, newAddress);
    }

    @Override
    public void deleteProductByName(String name) {
        db.callProcedureWithParam("delete_product_by_name", name);
    }

    @Override
    public void deleteClientByEmail(String email) {
        db.callProcedureWithParam("delete_client_by_email", email);
    }
}
