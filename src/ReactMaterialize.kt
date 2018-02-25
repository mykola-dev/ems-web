@file:JsModule("react-materialize")

import react.RClass
import react.RProps

external interface ButtonProps: RProps {
    var waves: String
}

external val Button: RClass<ButtonProps>
external val Icon: RClass<dynamic>
external val Card: RClass<dynamic>
external val Row: RClass<dynamic>
external val Col: RClass<dynamic>