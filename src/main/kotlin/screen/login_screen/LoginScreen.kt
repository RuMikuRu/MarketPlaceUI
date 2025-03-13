package screen.login_screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(
    onAdminNavigate: () -> Unit,
    onUserNavigate: () -> Unit
) {
    val viewModel = viewModel { LoginViewModel() }
    val usernameField by viewModel.userName.collectAsState()
    val passwordField by viewModel.password.collectAsState()

    Card() {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp)) {
            TextField(value = usernameField, onValueChange = {
                viewModel.updateUserName(it)
            }, placeholder = {
                Text(text = " Username")
            })
            TextField(value = passwordField, onValueChange = {
                viewModel.updatePassword(it)
            }, placeholder = {
                Text(text = "Password")
            })
            Button(onClick = {
                viewModel.clickToLogin(onAdminCompleate = {
                    onAdminNavigate.invoke()
                }, onUserCompleate = {
                    onUserNavigate.invoke()
                })
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Login")
            }
        }
    }
}