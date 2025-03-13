package screen.admin_screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import core.model.Role
import core.model.UnifiedData

@Preview
@Composable
fun AdminScreen() {
    val viewModel = viewModel { AdminViewModel() }
    val state by viewModel.state.collectAsState()
    val uiState by viewModel.stateUI.collectAsState()
    val userRole by viewModel.userRole.collectAsState()
    var cheked by remember { mutableStateOf(false) }

    Column {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Column {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TextField(value = state.textFieldValue, onValueChange = {
                        viewModel.updateTextField(it)
                    })
                    IconButton(onClick = {
                        viewModel.searchProductByName()
                    }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Поиск имени продукта")
                    }
                    IconButton(onClick = {
                        viewModel.getAllItems()
                    }) {
                        Icon(imageVector = Icons.Default.Build, contentDescription = "Обновить")
                    }
                }
                if (userRole == Role.ADMIN){
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = {
                            viewModel.deleteTable()
                        }) {
                            Text(text = "Удалить таблицу")
                        }
                        Button(onClick = {
                            viewModel.clearTable()
                        }) {
                            Text(text = "Очистка таблицы")
                        }

                        Button(onClick = {
                            viewModel.createTable()
                        }) {
                            Text(text = "Создать таблицу")
                        }

                        TextField(value = state.newUserName, onValueChange = {viewModel.updateTextFieldNewUserName(it)})
                        TextField(value = state.newUserPassword, onValueChange = {viewModel.updateTextFieldNewUserPassword(it)})
                        Checkbox(checked = cheked, onCheckedChange = {
                            cheked = it
                            viewModel.updateTextFieldNewUserRole(cheked)
                        })
                        Button(onClick = {viewModel.createUser()}){
                            Text(text = "Создать пользователя")
                        }
                    }
                }
                Column {
                    if (uiState == true) {
                        LazyColumn {
                            item {
                                Text(text = "Имя клиента, Фамилия клиента, Email, Адресс клиента, id заказа, дата заказа, локальная цена, название продукта, цена продукта, ProductQuantity, описание продукта, склад местоположение, StorageCapacity, место на складе, название магазина, аддресс магазина, часы работы магазина, рейтинг магазина, имя сотркдника, фамилия сотрудника, местоположение сотрудника, EmployeeSalary, название задачи ")
                            }
                            items(state.unifiedData) { unifiedData ->
                                UnifiedDataItem(unifiedData, userRole = userRole, onClick = {
                                    viewModel.deleteProductByName(unifiedData.productName)
                                }, onClickUpdate = {
                                    viewModel.updateProductInfo(unifiedData.productName, 22f, 999)
                                })
                            }
                            item {
                                if (userRole == Role.ADMIN){
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                                    ) {
                                        val sizeTextField = 75.dp
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.clientName,
                                            onValueChange = { viewModel.updateClientName(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.clientSurname,
                                            onValueChange = { viewModel.updateClientSurname(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.clientEmail,
                                            onValueChange = { viewModel.updateClientEmail(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.clientAddress,
                                            onValueChange = { viewModel.updateClientAddress(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.orderId.toString(),
                                            onValueChange = { viewModel.updateOrderId(it.toInt()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.orderDate,
                                            onValueChange = { viewModel.updateOrderDate(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.localPrice.toString(),
                                            onValueChange = { viewModel.updateLocalPrice(it.toFloat()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.productName,
                                            onValueChange = { viewModel.updateProductName(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.productPrice.toString(),
                                            onValueChange = { viewModel.updateProductPrice(it.toFloat()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.productQuantity.toString(),
                                            onValueChange = { viewModel.updateProductQuantity(it.toInt()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.productDescription,
                                            onValueChange = { viewModel.updateProductDescription(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.storageLocation,
                                            onValueChange = { viewModel.updateStorageLocation(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.storageCapacity.toString(),
                                            onValueChange = { viewModel.updateStorageCapacity(it.toInt()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.storageAvailableSpace.toString(),
                                            onValueChange = { viewModel.updateStorageAvailableSpace(it.toInt()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.shopName,
                                            onValueChange = { viewModel.updateShopName(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.shopAddress,
                                            onValueChange = { viewModel.updateShopAddress(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.shopWorkingHours,
                                            onValueChange = { viewModel.updateShopWorkingHours(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.shopRating.toString(),
                                            onValueChange = { viewModel.updateShopRating(it.toFloat()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.employeeName,
                                            onValueChange = { viewModel.updateEmployeeName(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.employeeSurname,
                                            onValueChange = { viewModel.updateEmployeeSurname(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.employeePosition,
                                            onValueChange = { viewModel.updateEmployeePosition(it) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.employeeSalary.toString(),
                                            onValueChange = { viewModel.updateEmployeeSalary(it.toFloat()) })
                                        TextField(
                                            modifier = Modifier.width(sizeTextField),
                                            value = state.taskDescription,
                                            onValueChange = { viewModel.updateTaskDescription(it) })
                                        Button(onClick = {
                                            viewModel.insertData()
                                        }) {
                                            Text(text = "Добавить запись")
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Composable
fun UnifiedDataItem(unifiedData: UnifiedData, userRole: Role, onClick: () -> Unit, onClickUpdate: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
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
        if(userRole == Role.ADMIN){
            Button(onClick = { onClick.invoke() }) {
                Text(text = "Удалить")
            }
            Button(onClick = { onClickUpdate.invoke() }) {
                Text(text = "Обновить данные")
            }
        }
    }
}
