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

                    circularProgress()
                    linearProgress()
                }
                1 -> {
                    container {
                        item(xs = 4) {
                            list {

                                listItem(button = true) {
                                    listItemIcon("inbox")
                                    listItemText("Inbox")
                                }
                                listItem(button = true, onClick = {
                                    setState { showToast = true }
                                }) {
                                    listItemIcon("drafts")
                                    listItemText("Toast")

                                }

                                divider()

                                listItem(button = true, onClick = {
                                    setState { showDialog = true }
                                }) {
                                    listItemText("Dialog", inset = true)
                                }
                                val onClick: OnClick = { event ->
                                    console.log("click")
                                    val anchor = event.currentTarget
                                    setState {
                                        menuAnchor = anchor
                                    }
                                }
                                listItem(button = true, onClick = onClick) {
                                    listItemText("Menu", inset = true)
                                }


                            }
                        }

                        item {

                        }
                    }
                    val onClose: EventCallback = {
                        setState {
                            menuAnchor = null
                        }
                    }

                    menu(open = state.menuAnchor != null, onClose = onClose, anchorEl = state.menuAnchor) {
                        menuItem { +"item 1" }
                        menuItem { +"item 2" }
                        menuItem("item 3")
                    }

                    dialog(state.showDialog, onClose = { setState { showDialog = false } }) {
                        dialogTitle("Attention")
                        dialogContent {
                            dialogContentText("This is Dialog!")
                        }
                        dialogActions {
                            button("OK", color = Color.secondary)
                            button("CANCEL")
                        }

                    }

                    snackbar(
                        "Hello",
                        "UNDO",
                        state.showToast,
                        { console.log("on action click") },
                        { setState { showToast = false } }
                    )
                }
                2 -> {
                    container(direction = FlexDirection.column, alignContent = ContentAlign.center) {
                        checkbox(state.checked1) { _, checked ->
                            console.log("clicked $checked")
                            setState { checked1 = checked }
                        }

                        switch(state.checked1) { _, checked ->
                            console.log("clicked $checked")
                            setState { checked1 = checked }
                        }

                        formControlLabel("This is a check box", Checkbox::class, state.checked1) { _, checked ->
                            console.log("clicked $checked")
                            setState { checked1 = checked }
                        }
                        formControlLabel("This is a switch", Switch::class, state.checked1) { _, checked ->
                            console.log("clicked $checked")
                            setState { checked1 = checked }
                        }
                    }
                }
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

