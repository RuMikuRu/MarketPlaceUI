package screen.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.ServiceImpl
import core.model.Role
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel():ViewModel(){
    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()
    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val service = ServiceImpl()
    fun clickToLogin(onAdminCompleate:()-> Unit, onUserCompleate:()->Unit){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = service.login(_userName.value, _password.value)
                if (result == Role.ADMIN){
                    onAdminCompleate.invoke()
                } else {
                    onUserCompleate.invoke()
                }
            } catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    fun updateUserName(value:String){
        _userName.update { value }
    }

    fun updatePassword(value:String){
        _password.update { value }
    }
}