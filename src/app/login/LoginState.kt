package app.login

import react.RState

interface LoginState : RState {
    val loggedIn: Boolean
    var login: String
    var password: String
}