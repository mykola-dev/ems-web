package app

import app.login.loginView
import kotlinext.js.invoke
import material.material
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

interface AppState : RState {
}

interface AppProps : RProps {
    var loggedIn: Boolean
}

class App : RComponent<AppProps, AppState>() {
    override fun RBuilder.render() {
        kotlinext.js.require("materialize-css/dist/js/materialize.min.js")
        kotlinext.js.require("materialize-css/dist/css/materialize.min.css")

        if (!props.loggedIn)
            loginView()
        else {
            material()
        }
    }
}

fun RBuilder.app(loggedIn: Boolean) = child(App::class) {
    attrs.loggedIn = loggedIn
}
