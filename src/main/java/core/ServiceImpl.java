package core;

import core.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    private final DataBaseCore db = new DataBaseCore();

    private final Role initi(
            String username,
            String password
    ) throws Exception {
        try {
            var result = db.connectionDB(username, password);
            if (username.contains("app")) {
                return Role.USER;
            } else {
                return Role.ADMIN;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("");
        }
    }

    @Override
    public Role login(String username, String password) {
        try {
            return initi(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTables() {
        db.callProcedure("create_tables");
    }

    @Override
    public void clearTable() {
        db.callProcedure("clear_unified_data");
    }

    @Override
    public List<UnifiedData> getAllItems(){
        var result = new ArrayList<UnifiedData>();
        var res = db.callProcedureWithParam("get_all_items");

        try {
            while (res.next()){
                result.add(mapResultSetToUnifiedData(res));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer insertData(UnifiedData unifiedData){
        var newId = -1;
        var rs = db.callProcedureWithParam("add_unified_data",
                                           unifiedData.getClientName(),
                                           unifiedData.getClientSurname(),
                                           unifiedData.getClientEmail(),
                                           unifiedData.getClientAddress(),
                                           unifiedData.getOrderId(),
                                           unifiedData.getOrderDate(),
                                           unifiedData.getLocalPrice(),
                                           unifiedData.getProductName(),
                                           unifiedData.getProductPrice(),
                                           unifiedData.getProductQuantity(),
                                           unifiedData.getProductDescription(),
                                           unifiedData.getStorageLocation(),
                                           unifiedData.getStorageCapacity(),
                                           unifiedData.getStorageAvailableSpace(),
                                           unifiedData.getShopName(),
                                           unifiedData.getShopAddress(),
                                           unifiedData.getShopWorkingHours(),
                                           unifiedData.getShopRating(),
                                           unifiedData.getEmployeeName(),
                                           unifiedData.getEmployeeSurname(),
                                           unifiedData.getEmployeePosition(),
                                           unifiedData.getEmployeeSalary(),
                                           unifiedData.getTaskDescription());
        try {
            while (rs.next()){
                newId = rs.getInt("new_id");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return newId;
    }

    @Override
    public List<UnifiedData> findByProductName(String productName) {
        List<UnifiedData> data = new ArrayList<>();
        var result = db.callProcedureWithParam("search_by_product_name", productName);

        try {
            while (result.next()){
                data.add(mapResultSetToUnifiedData(result));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public void updateProductInfo(String productName, Float newPrice, Integer newQuantity){
        db.callProcedureWithParam("update_product_info", productName, newPrice, newQuantity);
    }

    @Override
    public Boolean deleteByProductName(String productName){
        var res = db.callProcedureWithParam("delete_by_product_name", productName);

        try {
            while (res.next()){
                return res.getBoolean(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Role getRole() {
        try {
            var res = db.callProcedureWithParam("get_current_user_role");
            res.next();
            var str = res.getString(1);
            if (str.contains("guest")){
                return Role.USER;
            } else {
                return Role.ADMIN;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Role.NULL;
        }
    }

    @Override
    public void createUser(String username, String password, Role role){
        var roleString = "";
        if(role == Role.ADMIN){
            roleString = "admin";
            db.callProcedureWithParam("create_user", username, password, roleString);
        } else {
            roleString = "guest";
            db.callProcedureWithParam("create_user", username, password, roleString);
        }

    }

    @Override
    public void deleteDataBase(){
        db.callProcedureWithParam("drop_table", "unifieddata");
    }

    private UnifiedData mapResultSetToUnifiedData(ResultSet rs) throws SQLException {
        return new UnifiedData(
                rs.getInt("id"),
                rs.getString("client_name"),
                rs.getString("client_surname"),
                rs.getString("client_email"),
                rs.getString("client_address"),
                rs.getInt("order_id"),
                rs.getDate("order_date"),
                rs.getFloat("local_price"),
                rs.getString("product_name"),
                rs.getFloat("product_price"),
                rs.getInt("product_quantity"),
                rs.getString("product_description"),
                rs.getString("storage_location"),
                rs.getInt("storage_capacity"),
                rs.getInt("storage_available_space"),
                rs.getString("shop_name"),
                rs.getString("shop_address"),
                rs.getString("shop_working_hours"),
                rs.getFloat("shop_rating"),
                rs.getString("employee_name"),
                rs.getString("employee_surname"),
                rs.getString("employee_position"),
                rs.getFloat("employee_salary"),
                rs.getString("task_description")
        );
    }
}
