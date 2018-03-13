package app.base

import react.RComponent
import react.RState

abstract class View<P : Presenter, S : RState> : RComponent<Props<P>, S>() {
    val presenter: P get() = props.presenter
}