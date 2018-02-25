package app.login

import react.RState

interface LoginState : RState {
    val loggedIn: Boolean
    val login: String
    val password: String
}