package app.login

import app.base.Presenter

class LoginPresenter(val onLoggedIn: () -> Unit) : Presenter() {

    fun onLogin(login: String, password: String) {
        // todo
        onLoggedIn()
    }

    fun onRegister(login: String, password: String) {
        // todo
        onLoggedIn()
    }
}