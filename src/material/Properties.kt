@file:Suppress("EnumEntryName")

package material

import react.RProps
import react.ReactElement

class SnackbarContentProperties : RProps {
    var classes: String? = null
    var message: Any? = null
    var action: Any? = null
}

external interface SnackbarProperties : RProps {
    var message: ReactElement
    var action: ReactElement?
    var anchorOrigin: AnchorOrigin
    var classes: String
    var autoHideDuration: Int
    //var children: SnackbarContent? = null
    var disableWindowBlurListener: Boolean
    var key: Any?
    var onClose: EventCallback?
    var open: Boolean
    var resumeHideDuration: Int?
    var SnackbarContentProps: SnackbarContentProperties?
    var transitionDuration: Int?


}

data class AnchorOrigin(
    val horizontal: HorizontalOrigin = HorizontalOrigin.center,
    val vertical: VerticalOrigin = VerticalOrigin.bottom
)

enum class HorizontalOrigin { left, center, right }
enum class VerticalOrigin { top, center, bottom }

