package app.login

import app.base.Presenter
import react.setState

class LoginPresenter(val onLoggedIn: () -> Unit) : Presenter() {

    fun onLogin(view: LoginView, login: String, password: String) {
        if (login.isEmpty()) {
            view.setState { loginError = true }
            return
        }
        if (password.isEmpty()) {
            view.setState { passwordError = true }
            return
        }

        // todo
        onLoggedIn()
    }

    fun onRegister(login: String, password: String) {
        // todo
        onLoggedIn()
    }

}