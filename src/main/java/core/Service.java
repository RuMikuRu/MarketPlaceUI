package core;


import core.model.*;

import java.util.List;

public interface Service {

    Role login(String username, String password);

    void createTables();

    void clearTable();

    List<UnifiedData> getAllItems();

    Integer insertData(UnifiedData unifiedData);

    List<UnifiedData> findByProductName(String clientName);

    void updateProductInfo(String productName, Float newPrice, Integer newQuantity);

    Boolean deleteByProductName(String productName);

    Role getRole();

    void createUser(String username, String password, Role role);

    void deleteDataBase();
}
