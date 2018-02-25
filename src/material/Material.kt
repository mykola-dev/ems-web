package material

import Button
import Icon
import kotlinext.js.invoke
import kotlinext.js.require
import react.RBuilder
import react.RProps
import react.dom.a
import react.dom.button
import react.dom.div
import react.dom.i

operator fun RProps.set(key: String, value: dynamic) {
    asDynamic()[key] = value
}

fun RBuilder.material() {
    require("materialize-css/dist/js/materialize.min.js")
    require("materialize-css/dist/css/materialize.min.css")

    div {
        button(classes = "waves-effect waves-light btn") {
            i("material-icons left") { +"thumb_up" }
            +"Click"
        }
        a(classes = "btn-floating btn-large waves-effect waves-light") {
            i("material-icons large") {
                +"add"
            }
        }

        button {
            +"CLICK"
            attrs["disabled"] = true
        }

        Button {
            attrs {
                waves = "light"
            }
            //attrs["waves"] = "light"
            Icon {
                +"thumb_up"
                //attrs.asDynamic().right = true
                attrs["right"] = true
            }
            +"HELLO THERE!"
        }
        //+"thumb_up"
    }

}
