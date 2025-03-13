package core.model;

public class UnifiedData {
    private int id;
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String clientAddress;
    private int orderId;
    private java.sql.Date orderDate;
    private float localPrice;
    private String productName;
    private float productPrice;
    private int productQuantity;
    private String productDescription;
    private String storageLocation;
    private int storageCapacity;
    private int storageAvailableSpace;
    private String shopName;
    private String shopAddress;
    private String shopWorkingHours;
    private float shopRating;
    private String employeeName;
    private String employeeSurname;
    private String employeePosition;
    private float employeeSalary;
    private String taskDescription;

    // Конструктор
    public UnifiedData(int id, String clientName, String clientSurname, String clientEmail, String clientAddress,
                       int orderId, java.sql.Date orderDate, float localPrice,
                       String productName, float productPrice, int productQuantity, String productDescription,
                       String storageLocation, int storageCapacity, int storageAvailableSpace,
                       String shopName, String shopAddress, String shopWorkingHours, float shopRating,
                       String employeeName, String employeeSurname, String employeePosition, float employeeSalary,
                       String taskDescription) {
        this.id = id;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.localPrice = localPrice;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.storageLocation = storageLocation;
        this.storageCapacity = storageCapacity;
        this.storageAvailableSpace = storageAvailableSpace;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopWorkingHours = shopWorkingHours;
        this.shopRating = shopRating;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
        this.taskDescription = taskDescription;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientSurname() { return clientSurname; }
    public void setClientSurname(String clientSurname) { this.clientSurname = clientSurname; }

    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public String getClientAddress() { return clientAddress; }
    public void setClientAddress(String clientAddress) { this.clientAddress = clientAddress; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public java.sql.Date getOrderDate() { return orderDate; }
    public void setOrderDate(java.sql.Date orderDate) { this.orderDate = orderDate; }

    public float getLocalPrice() { return localPrice; }
    public void setLocalPrice(float localPrice) { this.localPrice = localPrice; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getProductPrice() { return productPrice; }
    public void setProductPrice(float productPrice) { this.productPrice = productPrice; }

    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }

    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }

    public String getStorageLocation() { return storageLocation; }
    public void setStorageLocation(String storageLocation) { this.storageLocation = storageLocation; }

    public int getStorageCapacity() { return storageCapacity; }
    public void setStorageCapacity(int storageCapacity) { this.storageCapacity = storageCapacity; }

    public int getStorageAvailableSpace() { return storageAvailableSpace; }
    public void setStorageAvailableSpace(int storageAvailableSpace) { this.storageAvailableSpace = storageAvailableSpace; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getShopAddress() { return shopAddress; }
    public void setShopAddress(String shopAddress) { this.shopAddress = shopAddress; }

    public String getShopWorkingHours() { return shopWorkingHours; }
    public void setShopWorkingHours(String shopWorkingHours) { this.shopWorkingHours = shopWorkingHours; }

    public float getShopRating() { return shopRating; }
    public void setShopRating(float shopRating) { this.shopRating = shopRating; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getEmployeeSurname() { return employeeSurname; }
    public void setEmployeeSurname(String employeeSurname) { this.employeeSurname = employeeSurname; }

    public String getEmployeePosition() { return employeePosition; }
    public void setEmployeePosition(String employeePosition) { this.employeePosition = employeePosition; }

    public float getEmployeeSalary() { return employeeSalary; }
    public void setEmployeeSalary(float employeeSalary) { this.employeeSalary = employeeSalary; }

    public String getTaskDescription() { return taskDescription; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }

    // Метод toString()
    @Override
    public String toString() {
        return "UnifiedData{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", localPrice=" + localPrice +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productDescription='" + productDescription + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                ", storageCapacity=" + storageCapacity +
                ", storageAvailableSpace=" + storageAvailableSpace +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopWorkingHours='" + shopWorkingHours + '\'' +
                ", shopRating=" + shopRating +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
