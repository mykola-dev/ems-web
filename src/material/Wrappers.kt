@file:Suppress("EnumEntryName")

package material

import kotlinext.js.Object
import react.RBuilder
import react.RHandler

enum class Color { inherit, primary, textSecondary, secondary, error, default }
enum class Align { inherit, left, center, right, justify }
enum class TextVariant { display4, display3, display2, display1, headline, title, subheading, body2, body1, caption, button }
enum class Position { fixed, absolute, sticky, static }
enum class Size { small, medium, large }
enum class ButtonVariant { flat, raised, fab }
enum class ScrollButtons { auto, on, off }

typealias OnTabChange = (event: Object, value: Int) -> Unit

fun RBuilder.appBar(
    classes: String? = null,
    color: Color = Color.primary,
    position: Position = Position.fixed,
    handler: RHandler<dynamic>
) = child(AppBar::class) {
    attrs {
        this.className = classes
        this.color = color.name
        this.position = position.name
    }
    handler()
}

fun RBuilder.toolBar(
    classes: String? = null,
    disableGutters: Boolean = false,
    handler: RHandler<dynamic>
) = child(Toolbar::class) {
    attrs {
        this.className = classes
        this.disableGutters = disableGutters
    }
    handler()
}

fun RBuilder.tabs(
    classes: String? = null,
    centered: Boolean = false,
    fullWidth: Boolean = false,
    scrollable: Boolean = false,
    indicatorColor: String = Color.secondary.name,
    scrollButtons: ScrollButtons = ScrollButtons.auto,
    tabScrollButton: Any = "TabScrollButton",
    textColor: Color = Color.inherit,   // secondary | primary | inherit
    value: Int = 0,
    action: ((dynamic) -> Unit)? = null, // function(actions: object) => void
    onChange: OnTabChange? = null, // function(event: object, value: number) => void
    handler: RHandler<dynamic>
) = child(Tabs::class) {
    attrs {
        this.className = classes
        this.centered = centered
        this.fullWidth = fullWidth
        this.scrollable = scrollable
        this.indicatorColor = indicatorColor
        this.scrollButtons = scrollButtons.name
        this.TabScrollButton = tabScrollButton
        this.textColor = textColor.name
        this.value = value
        this.action = action
        this.onChange = onChange

    }
    handler()
}

fun RBuilder.tab(
    label: String,
    classes: String? = null,
    disabled: Boolean = false,
    icon: Any? = null, // todo Icon
    value: Any? = null,
    handler: RHandler<dynamic> = {}
) = child(Tab::class) {
    attrs {
        this.className = classes
        this.disabled = disabled
        this.icon = icon
        this.label = label
        this.value = value

    }
    handler()
}

fun RBuilder.typography(
    classes: String? = null,
    variant: TextVariant = TextVariant.body1,
    align: Align = Align.inherit,
    color: Color = Color.default,
    gutterBottom: Boolean = false,
    noWrap: Boolean = false,
    paragraph: Boolean = false,
    handler: RHandler<dynamic>
) = child(Typography::class) {
    attrs {
        this.className = classes
        this.align = align.name
        this.color = color.name
        this.variant = variant.name
        this.gutterBottom = gutterBottom
        this.noWrap = noWrap
        this.paragraph = paragraph
    }
    handler()
}

fun RBuilder.button(
    classes: String? = null,
    href: String = "",
    color: Color = Color.inherit,
    disabled: Boolean = false,
    disableFocusRipple: Boolean = false,
    disableRipple: Boolean = false,
    fullWidth: Boolean = false,
    mini: Boolean = false,
    size: Size = Size.medium,
    variant: ButtonVariant = ButtonVariant.flat,
    handler: RHandler<dynamic>
) = child(Button::class) {
    attrs {
        this.className = classes
        this.href = href
        this.color = color.name
        this.disabled = disabled
        this.disableFocusRipple = disableFocusRipple
        this.disableRipple = disableRipple
        this.fullWidth = fullWidth
        this.mini = mini
        this.size = size.name
        this.variant = variant.name

    }
    handler()
}