package br.com.maschdy.mvp_android.ui.login

import br.com.maschdy.mvp_android.utils.AuthUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginPresenter(
    private val view: LoginContract.View,
    override val coroutineContext: CoroutineContext = Dispatchers.Main
) : LoginContract.Presenter, CoroutineScope {

    override fun doLogin(email: String, password: String) = launch {
            view.onLoading(true)
            delayOnLogin()
            if (email.isEmpty() || password.isEmpty()) {
                view.onError()
            } else {
                if (password == AuthUtils.PASSWORD && email == AuthUtils.USERNAME) {
                    view.onSuccess()
                } else {
                    view.onError()
                }
            }
            view.onLoading(false)
        }

    private suspend fun delayOnLogin() {
        delay(3000)
    }
}
