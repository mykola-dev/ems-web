package app

import app.login.LoginPresenter
import app.login.loginView
import app.main.mainView
import react.*

interface AppState : RState {
    var loggedIn: Boolean
}


class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        loggedIn = false
    }

    override fun RBuilder.render() {

        val loginPresenter = LoginPresenter(onLoggedIn = {
            console.log("logged in")
            setState {
                loggedIn = true
            }
        })

        if (!state.loggedIn) {
            loginView(loginPresenter)
        } else {
            mainView(state.loggedIn)
        }

        /* hashRouter {
             switch {
                 //div {
                 route("/", exact = true) {
                     console.log("route main. loggedIn=${state.loggedIn}")
                     mainView(state.loggedIn)
                 }
                 route("/login", exact = true) {
                     console.log("route login. loggedIn=${state.loggedIn}")
                     loginView(loginPresenter)
                 }

                *//* if (!state.loggedIn) {
                    redirect("/login")
                } else {
                    console.log("to root")
                    redirect("/", from = "/login")
                }*//*
            }
        }*/
    }
}

fun RBuilder.app() = child(App::class) {}
