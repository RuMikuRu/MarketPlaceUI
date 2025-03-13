package screen.admin_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.model.Client
import core.model.Employee
import core.model.Order
import core.model.Product
import core.model.Shop
import core.model.Storage
import core.model.UnifiedData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import singletonDB.ServiceKt

class AdminViewModel : ViewModel(){

    private val _unifiedData = MutableStateFlow(listOf<UnifiedData>())
    val unifiedData = _unifiedData.asStateFlow()

    private val _textFieldValue = MutableStateFlow("")
    val textFieldValue = _textFieldValue.asStateFlow()

    private val _clientName = MutableStateFlow("")
    val clientName = _clientName.asStateFlow()

    private val _



    private val serviceKt = ServiceKt

    fun getAllItems(){
        viewModelScope.launch(Dispatchers.IO) {
            _unifiedData.update {serviceKt.service.allItems}
        }
    }

    fun deleteProductByName(){
        viewModelScope.launch {
            serviceKt.service.deleteByProductName(_textFieldValue.value)
        }
    }

    fun searchClientByName(){
        viewModelScope.launch {
            _unifiedData.update {serviceKt.service.findByClientName(_textFieldValue.value)}
        }
    }

    fun updateProductInfo(productName:String, newPrice:Float, newQuantity:Int){
        viewModelScope.launch {
            serviceKt.service.updateProductInfo(productName, newPrice, newQuantity)
            getAllItems()
        }
    }

    fun updateTextField(value:String){
        _textFieldValue.update { value }
    }
}