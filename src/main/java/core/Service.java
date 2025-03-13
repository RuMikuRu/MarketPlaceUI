package core;


import core.model.*;

import java.util.List;

public interface Service {

    Role login(String username, String password);

    void createTables();

    void clearTable();

    List<UnifiedData> getAllItems();

    Integer insertData(UnifiedData unifiedData);

    List<UnifiedData> findByClientName(String clientName);

    void updateProductInfo(String productName, Float newPrice, Integer newQuantity);

    Boolean deleteByProductName(String productName);
}
