package app.main

import org.w3c.dom.events.EventTarget
import react.RState

interface MainState : RState {
    var tabIndex: Int
    var checked1: Boolean
    var showDialog: Boolean
    var menuAnchor: EventTarget?

}