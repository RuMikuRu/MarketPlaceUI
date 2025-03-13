import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import router.AdminScreen
import router.LoginScreen
import router.UserScreen
import screen.login_screen.LoginScreen
import screen.admin_screen.AdminScreen

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val navController = rememberNavController()

    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            NavHost(navController = navController, startDestination = LoginScreen) {
                composable<LoginScreen> {
                    LoginScreen(
                        onAdminNavigate = {
                            navController.navigate(route = AdminScreen)
                        },
                        onUserNavigate = {
                            
                        }
                    )
                }
                composable<AdminScreen> {
                    AdminScreen()
                }
                composable<UserScreen> {

                }
            }
        }
    }

}

fun main() {
    return application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}
