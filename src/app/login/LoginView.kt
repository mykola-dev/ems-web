package app.login

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.InputType
import kotlinx.html.id
import react.RBuilder
import react.RComponent
import react.RProps
import react.dom.*

class LoginView : RComponent<RProps, LoginState>() {

    override fun RBuilder.render() {
        div("container") {
            div("row") {
                attrs.jsStyle { height = 50 }
            }
            div("row") {
                div("col s4 offset-s4") {
                    cardPanel {
                        h3 { +"Log In" }
                        //p("flow-text") { +"Log In" }
                        div("section") {
                            div("input-field") {
                                input(classes = "validate", type = InputType.email) { }
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
                                    key = "password"
                                    attrs {
                                        id = "password"
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
                            }
                            //div {}
                            accentButton {
                                +"Sign Up"
                            }
                        }

                    }
                }
            }
        }
    }
}

fun RBuilder.cardPanel(child: RDOMBuilder<DIV>.() -> Unit) {
    div("card-panel", child)
}

fun RBuilder.accentButton(child: RDOMBuilder<A>.() -> Unit) {
    a(classes = "waves-effect waves-light btn horizontal-button", block = child)
}

fun RBuilder.lightButton(child: RDOMBuilder<A>.() -> Unit) {
    a(classes = "waves-effect waves-dark btn grey lighten-2 black-text horizontal-button", block = child)
}

fun RBuilder.loginView() = child(LoginView::class) {}