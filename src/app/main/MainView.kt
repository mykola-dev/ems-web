package app.main

import app.base.View
import react.RBuilder
import react.RState

class MainView : View<MainPresenter, RState>() {

    override fun RBuilder.render() {
        +"Main"
        console.log("logged in? ${presenter.loggedIn}")
    }

}

fun RBuilder.mainView(loggedIn: Boolean) = child(MainView::class) {
    attrs {
        this.presenter = MainPresenter(loggedIn)
    }
}