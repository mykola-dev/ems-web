package app.main

import app.base.View
import material.*
import react.RBuilder
import react.dom.div
import react.setState

class MainView : View<MainPresenter, MainState>() {

    override fun MainState.init() {
        tabIndex = 0
    }

    override fun RBuilder.render() {
        div("root") {
            appBar(position = Position.static) {
                div("toolbar") {
                    typography("Hello World", variant = TextVariant.title, color = Color.inherit)

                    val onTabChange: OnTabChange = { event, value ->
                        console.log("$event: changed to $value")
                        setState {
                            tabIndex = value
                        }
                    }

                    tabs("flex", value = state.tabIndex, centered = true, onChange = onTabChange) {

                        tab("History")
                        tab("Charts")
                        tab("Settings")
                    }

                    button {
                        +"Log Out"
                    }
                }
            }

            when (state.tabIndex) {
                0 -> {
                    typography {
                        +"TO DO"
                    }
                    icon("stars")
                    textField("Login", defaultValue = "hi")
                }
                1 -> +"2"
                2 -> +"3"
            }
        }

        console.log("logged in? ${presenter.loggedIn}");
    }

}

fun RBuilder.mainView(loggedIn: Boolean) = child(MainView::class) {
    attrs {
        this.presenter = MainPresenter(loggedIn)

    }
}

