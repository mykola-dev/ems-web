package app.login

import app.base.View
import app.inputValue
import kotlinx.html.InputType
import material.*
import react.RBuilder
import react.dom.div
import react.dom.jsStyle
import react.setState

class LoginView : View<LoginPresenter, LoginState>() {

    override fun LoginState.init() {
        console.log("init")
        login = ""
        password = ""
    }

    override fun RBuilder.render() {
        div("container") {
            div("row") {
                attrs.jsStyle { height = 50 }
            }
            container(justify = ContentJustify.center) {
                item(xs = 6) {
                    paper("card") {
                        container(direction = FlexDirection.column) {
                            item {
                                typography("Log In", TextVariant.headline)
                            }
                            item {
                                textField(
                                    "Login",
                                    InputType.email,
                                    error = state.loginError,
                                    autoFocus = true,
                                    fullWidth = true,
                                    helperText = if (state.loginError) "Wrong Email" else null
                                ) {
                                    val value = it.inputValue
                                    console.log("new value=$value")
                                    setState {
                                        login = value
                                        loginError = false
                                    }
                                }
                            }

                            item {
                                textField(
                                    "Password",
                                    InputType.password,
                                    error = state.passwordError,
                                    fullWidth = true,
                                    helperText = if (state.loginError) "Wrong Password" else null
                                ) {
                                    val value = it.inputValue
                                    setState {
                                        password = value
                                        passwordError = false
                                    }
                                }
                            }

                            item {
                                container {
                                    item {
                                        button("Sign In", variant = ButtonVariant.raised, onClick = {
                                            console.log("login=${state.login}")
                                            props.presenter.onLogin(this@LoginView, state.login, state.password)
                                        })
                                    }

                                    item {
                                        button("Sign Up", variant = ButtonVariant.raised, color = Color.primary, onClick = {
                                            presenter.onRegister(state.login, state.password)
                                        })
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

fun RBuilder.loginView(presenter: LoginPresenter) = child(LoginView::class) {
    attrs {
        this.presenter = presenter
    }
}