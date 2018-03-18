@file:Suppress("EnumEntryName")

package material

enum class Color { inherit, primary, textSecondary, secondary, error, default }

enum class TextAlign { inherit, left, center, right, justify }

enum class ContentAlign(private val alias: String? = null) {
    stretch, center, flexStart("flex-start"), flexEnd("flex-end"), spaceBetween("space-between"), spaceAround("space-around");

    override fun toString(): String = alias ?: super.toString()

}

enum class ContentJustify(private val alias: String? = null) {
    flexStart("flex-start"), center, flexEnd("flex-end"), spaceBetween("space-between"), spaceAround("space-around");

    override fun toString(): String = alias ?: super.toString()

}

enum class FlexDirection(private val alias: String? = null) {
    row, rowReverse("row-reverse"), column, columnReverse("column-reverse");

    override fun toString(): String = alias ?: super.toString()

}

enum class ItemsAlign(private val alias: String? = null) {
    stretch, center, flexStart("flex-start"), flexEnd("flex-end"), baseline;

    override fun toString(): String = alias ?: super.toString()

}

enum class TextVariant { display4, display3, display2, display1, headline, title, subheading, body2, body1, caption, button }

enum class Position { fixed, absolute, sticky, static }

enum class Size { small, medium, large }

enum class ButtonVariant { flat, raised, fab }

enum class ScrollButtons { auto, on, off }

enum class TextMargin { none, dense, normal }

enum class Control { CHECKBOX, SWITCH, RADIO }

enum class Wrap(private val alias: String? = null) {
    nowrap, wrap, wrapReverse("wrap-reverse");

    override fun toString(): String = alias ?: super.toString()
}

enum class DialogMaxWidth(private val alias: String? = null) {
    xs, sm, md, none("false");

    override fun toString(): String = alias ?: super.toString()
}
