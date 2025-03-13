package screen.admin_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.model.Role
import core.model.UnifiedData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import singletonDB.ServiceKt

class AdminViewModel : ViewModel() {

    private val _state = MutableStateFlow(AdminState())
    val state = _state.asStateFlow()

    private val _stateUI = MutableStateFlow(true)
    val stateUI = _stateUI.asStateFlow()

    private val _userRole = MutableStateFlow(Role.NULL)
    val userRole = _userRole.asStateFlow()

    private val serviceKt = ServiceKt

    init {
        getUserRole()
        getAllItems()
    }

    private fun getUserRole() {
        viewModelScope.launch(Dispatchers.IO) {
            _userRole.update { serviceKt.service.role }
        }
    }


    fun getAllItems() {
        _stateUI.update { false }
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(unifiedData = serviceKt.service.allItems) }
            _stateUI.update { true }
        }
    }

    fun insertData() {
        viewModelScope.launch(Dispatchers.IO) {
            serviceKt.service.insertData(
                UnifiedData(
                    0,
                    _state.value.clientName,
                    _state.value.clientSurname,
                    _state.value.clientEmail,
                    _state.value.clientAddress,
                    _state.value.orderId,
                    java.sql.Date(_state.value.orderDate.toLong()),
                    _state.value.localPrice,
                    _state.value.productName,
                    _state.value.productPrice,
                    _state.value.productQuantity,
                    _state.value.productDescription,
                    _state.value.storageLocation,
                    _state.value.storageCapacity,
                    _state.value.storageAvailableSpace,
                    _state.value.shopName,
                    _state.value.shopAddress,
                    _state.value.shopWorkingHours,
                    _state.value.shopRating,
                    _state.value.employeeName,
                    _state.value.employeeSurname,
                    _state.value.employeePosition,
                    _state.value.employeeSalary,
                    _state.value.taskDescription
                )
            )
            getAllItems()
        }
    }

    fun deleteProductByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            serviceKt.service.deleteByProductName(name)
            updateState { it.copy(unifiedData = serviceKt.service.allItems) }
        }
    }

    fun deleteTable(){
        viewModelScope.launch(Dispatchers.IO) {
            serviceKt.service.deleteDataBase()
        }
    }

    fun createTable(){
        viewModelScope.launch(Dispatchers.IO) {
            serviceKt.service.createTables()
        }
    }

    fun searchProductByName() {
        _stateUI.update { false }
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(unifiedData = serviceKt.service.findByProductName(it.textFieldValue))
            }
            _stateUI.update { true }
        }
    }

    fun updateProductInfo(productName: String, newPrice: Float, newQuantity: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            serviceKt.service.updateProductInfo(productName, newPrice, newQuantity)
            getAllItems()
        }
    }

    fun clearTable() {
        viewModelScope.launch(Dispatchers.IO) {
            serviceKt.service.clearTable()
            getAllItems()
        }
    }

    // Generic state update function
    private fun updateState(transform: (AdminState) -> AdminState) {
        _state.update(transform)
    }

    fun createUser(){
        viewModelScope.launch(Dispatchers.IO) {
            serviceKt.service.createUser(
                _state.value.newUserName,
                _state.value.newUserPassword,
                _state.value.newUserRole
            )
        }
    }

    // State update extensions (auto-generated via IDE or helper)

    fun updateTextFieldNewUserName(value: String) = updateState { it.copy(newUserName = value) }
    fun updateTextFieldNewUserPassword(value: String) = updateState { it.copy(newUserPassword = value) }
    fun updateTextFieldNewUserRole(value: Boolean) =
        updateState { it.copy(newUserRole = if (value) Role.ADMIN else Role.USER) }

    fun updateTextField(value: String) = updateState { it.copy(textFieldValue = value) }
    fun updateClientName(value: String) = updateState { it.copy(clientName = value) }
    fun updateClientSurname(value: String) = updateState { it.copy(clientSurname = value) }
    fun updateClientEmail(value: String) = updateState { it.copy(clientEmail = value) }
    fun updateClientAddress(value: String) = updateState { it.copy(clientAddress = value) }
    fun updateOrderId(value: Int) = updateState { it.copy(orderId = value) }
    fun updateOrderDate(value: String) = updateState { it.copy(orderDate = value) }
    fun updateLocalPrice(value: Float) = updateState { it.copy(localPrice = value) }
    fun updateProductName(value: String) = updateState { it.copy(productName = value) }
    fun updateProductPrice(value: Float) = updateState { it.copy(productPrice = value) }
    fun updateProductQuantity(value: Int) = updateState { it.copy(productQuantity = value) }
    fun updateProductDescription(value: String) = updateState { it.copy(productDescription = value) }
    fun updateStorageLocation(value: String) = updateState { it.copy(storageLocation = value) }
    fun updateStorageCapacity(value: Int) = updateState { it.copy(storageCapacity = value) }
    fun updateStorageAvailableSpace(value: Int) = updateState { it.copy(storageAvailableSpace = value) }
    fun updateShopName(value: String) = updateState { it.copy(shopName = value) }
    fun updateShopAddress(value: String) = updateState { it.copy(shopAddress = value) }
    fun updateShopWorkingHours(value: String) = updateState { it.copy(shopWorkingHours = value) }
    fun updateShopRating(value: Float) = updateState { it.copy(shopRating = value) }
    fun updateEmployeeName(value: String) = updateState { it.copy(employeeName = value) }
    fun updateEmployeeSurname(value: String) = updateState { it.copy(employeeSurname = value) }
    fun updateEmployeePosition(value: String) = updateState { it.copy(employeePosition = value) }
    fun updateEmployeeSalary(value: Float) = updateState { it.copy(employeeSalary = value) }
    fun updateTaskDescription(value: String) = updateState { it.copy(taskDescription = value) }
}

data class AdminState(
    val unifiedData: List<UnifiedData> = emptyList(),
    val newUserName: String = "",
    val newUserPassword: String = "",
    val newUserRole: Role = Role.USER,
    val textFieldValue: String = "",
    val clientName: String = "",
    val clientSurname: String = "",
    val clientEmail: String = "",
    val clientAddress: String = "",
    val orderId: Int = 0,
    val orderDate: String = "",
    val localPrice: Float = 0f,
    val productName: String = "",
    val productPrice: Float = 0f,
    val productQuantity: Int = 0,
    val productDescription: String = "",
    val storageLocation: String = "",
    val storageCapacity: Int = 0,
    val storageAvailableSpace: Int = 0,
    val shopName: String = "",
    val shopAddress: String = "",
    val shopWorkingHours: String = "",
    val shopRating: Float = 0f,
    val employeeName: String = "",
    val employeeSurname: String = "",
    val employeePosition: String = "",
    val employeeSalary: Float = 0f,
    val taskDescription: String = ""
)