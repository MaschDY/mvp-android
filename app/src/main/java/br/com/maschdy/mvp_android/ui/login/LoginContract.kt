package br.com.maschdy.mvp_android.ui.login

import kotlinx.coroutines.Job

interface LoginContract {
    interface View {
        fun onSuccess()
        fun onError()
        fun onLoading(isLoading: Boolean)
    }

    interface Presenter {
        fun doLogin(email: String, password: String): Job
    }
}
