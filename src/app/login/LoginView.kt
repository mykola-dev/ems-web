package app.login

import app.base.Props
import app.base.View
import app.inputValue
import app.widgets.accentButton
import app.widgets.cardPanel
import app.widgets.lightButton
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.dom.*
import react.setState

class LoginView : View<LoginPresenter, LoginState>() {

    override fun LoginState.init(props: Props<LoginPresenter>) {
        state.login = ""
        state.password = ""
    }

    override fun RBuilder.render() {
        div("container") {
            div("row") {
                attrs.jsStyle { height = 50 }
            }
            div("row") {
                div("col s6 offset-s3") {
                    cardPanel {
                        h3 { +"Log In" }
                        //p("flow-text") { +"Log In" }
                        div("section") {
                            div("input-field") {
                                input(classes = "validate", type = InputType.email) {
                                    attrs {
                                        onChangeFunction = {
                                            val value = it.inputValue
                                            setState { login = value }
                                        }
                                    }
                                }
                                label {
                                    attrs["data-error"] = "Wrong Email"
                                    +"Email"
                                }
                            }
                        }

                        div("section") {
                            div("input-field") {
                                // password
                                input(classes = "validate", type = InputType.password) {
                                    attrs {
                                        onChangeFunction = {
                                            val value = it.inputValue
                                            setState { password = value }
                                        }
                                    }
                                }
                                label {
                                    +"Password"
                                }
                            }
                        }

                        div("section") {
                            lightButton {
                                +"Sign In"
                                attrs {
                                    onClickFunction = {
                                        props.presenter.onLogin(state.login, state.password)
                                    }
                                }
                            }
                            //div {}
                            accentButton {
                                +"Sign Up"
                                attrs {
                                    onClickFunction = {
                                        presenter.onRegister(state.login, state.password)
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