package app.widgets

import kotlinx.html.A
import kotlinx.html.DIV
import react.RBuilder
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.div


fun RBuilder.cardPanel(child: RDOMBuilder<DIV>.() -> Unit) {
    div("card-panel", child)
}

fun RBuilder.accentButton(child: RDOMBuilder<A>.() -> Unit) {
    a(classes = "waves-effect waves-light btn horizontal-button", block = child)
}

fun RBuilder.lightButton(child: RDOMBuilder<A>.() -> Unit) {
    a(classes = "waves-effect waves-dark btn grey lighten-2 black-text horizontal-button", block = child)
}