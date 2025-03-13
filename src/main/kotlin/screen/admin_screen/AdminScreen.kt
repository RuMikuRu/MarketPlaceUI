package screen.admin_screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import core.model.Client
import core.model.Employee
import core.model.Order
import core.model.Product
import core.model.Shop
import core.model.Storage
import core.model.UnifiedData
import org.w3c.dom.Text

@Preview
@Composable
fun AdminScreen() {
    val viewModel = viewModel { AdminViewModel() }
    val unifiedDataList by viewModel.unifiedData.collectAsState()
    val textField by viewModel.textFieldValue.collectAsState()

    viewModel.getAllItems()
    Column {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Column {
                Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
                    TextField(value = textField, onValueChange = {
                        viewModel.updateTextField(it)
                    })
                    IconButton(onClick = {

                    }){
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Удалить продукт")
                    }
                    IconButton(onClick = {

                    }){
                        Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    }
                }
                Row {
                    Button(onClick = {}){
                        Text(text = "Удалить таблицу")
                    }
                    Button(onClick = {}){
                        Text(text = "Очистка таблицы")
                    }
                }
                Column {
                    LazyColumn {
                        item {
                            Text(text = "Ебать хэдэр")
                        }
                        items(unifiedDataList){ unifiedData ->
                            UnifiedDataItem(unifiedData)
                        }
                        item {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                                TextField(value = , onValueChange = {})
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UnifiedDataItem(unifiedData: UnifiedData){
    Row {
        Text(text = unifiedData.clientName)
        Text(text = unifiedData.clientSurname)
        Text(text = unifiedData.clientEmail)
        Text(text = unifiedData.clientAddress)
        Text(text = unifiedData.orderId.toString())
        Text(text = unifiedData.orderDate.toString())
        Text(text = unifiedData.localPrice.toString())
        Text(text = unifiedData.productName)
        Text(text = unifiedData.productPrice.toString())
        Text(text = unifiedData.productQuantity.toString())
        Text(text = unifiedData.productDescription)
        Text(text = unifiedData.storageLocation)
        Text(text = unifiedData.storageCapacity.toString())
        Text(text = unifiedData.storageAvailableSpace.toString())
        Text(text = unifiedData.shopName)
        Text(text = unifiedData.shopAddress)
        Text(text = unifiedData.shopWorkingHours)
        Text(text = unifiedData.shopRating.toString())
        Text(text = unifiedData.employeeName)
        Text(text = unifiedData.employeeSurname)
        Text(text = unifiedData.employeePosition)
        Text(text = unifiedData.employeeSalary.toString())
        Text(text = unifiedData.taskDescription)
    }
}
