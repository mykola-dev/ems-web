package material

import kotlinext.js.JsFunction0
import kotlinext.js.Object
import kotlinx.html.InputType
import org.w3c.dom.events.Event
import react.RBuilder
import react.RHandler


typealias OnTabChange = (event: Object, value: Int) -> Unit
typealias OnChange = (event: Event) -> Unit
typealias OnClick = () -> Unit

fun RBuilder.appBar(
    classes: String? = null,
    color: Color = Color.primary,
    position: Position = Position.fixed,
    handler: RHandler<dynamic>
) = child(AppBar::class) {
    attrs {
        this.className = classes
        this.color = color.toString()
        this.position = position.toString()
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
    indicatorColor: String = Color.secondary.toString(),
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
        this.scrollButtons = scrollButtons.toString()
        this.TabScrollButton = tabScrollButton
        this.textColor = textColor.toString()
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
    icon: Icon? = null,
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
    text: String? = null,
    variant: TextVariant = TextVariant.body1,
    classes: String? = null,
    align: TextAlign = TextAlign.inherit,
    color: Color = Color.default,
    gutterBottom: Boolean = false,
    noWrap: Boolean = false,
    paragraph: Boolean = false,
    handler: RHandler<dynamic>? = null
) = child(Typography::class) {
    attrs {
        this.className = classes
        this.align = align.toString()
        this.color = color.toString()
        this.variant = variant.toString()
        this.gutterBottom = gutterBottom
        this.noWrap = noWrap
        this.paragraph = paragraph
        if (text != null)
            this.children = text
        else if (handler != null)
            handler()
    }
}

fun RBuilder.button(
    text: String? = null,
    classes: String? = null,
    color: Color = Color.inherit,
    variant: ButtonVariant = ButtonVariant.flat,
    href: String? = null,
    disabled: Boolean = false,
    disableFocusRipple: Boolean = false,
    disableRipple: Boolean = false,
    fullWidth: Boolean = false,
    mini: Boolean = false,
    size: Size = Size.medium,
    onClick: OnClick? = null,
    handler: RHandler<dynamic>? = null
) = child(Button::class) {
    attrs {
        this.className = classes
        this.href = href
        this.color = color.toString()
        this.disabled = disabled
        this.disableFocusRipple = disableFocusRipple
        this.disableRipple = disableRipple
        this.fullWidth = fullWidth
        this.mini = mini
        this.size = size.toString()
        this.variant = variant.toString()
        this.onClick = onClick
        if (text != null)
            this.children = text
        else if (handler != null)
            handler()

    }
}

fun RBuilder.paper(
    classes: String? = null,
    component: Any? = "div",    //union: string | func
    elevation: Int = 2,
    square: Boolean = false,
    handler: RHandler<dynamic>
) = child(Paper::class) {
    attrs {
        this.className = classes
        this.component = component
        this.elevation = elevation
        this.square = square
    }
    handler()
}

fun RBuilder.icon(
    icon: String,   // https://material.io/icons/
    classes: String? = null,
    color: Color = Color.inherit   // 'inherit', 'secondary', 'action', 'disabled', 'error', 'primary'
) = child(Icon::class) {
    attrs {
        this.children = icon
        this.className = classes
        this.color = color.toString()
    }
}

fun RBuilder.textField(
    label: Any? = null,
    type: InputType = InputType.text,
    value: String? = null, // union: string | number |arrayOf
    classes: String? = null,
    autoComplete: String? = null,
    autoFocus: Boolean? = null,
    defaultValue: String? = null,
    disabled: Boolean? = null,
    error: Boolean? = null,
    FormHelperTextProps: Object? = null,
    fullWidth: Boolean? = null,
    helperText: String? = null,    // node
    id: String? = null,
    InputLabelProps: Object? = null,
    InputProps: Object? = null,
    inputProps: Object? = null,
    inputRef: JsFunction0<*>? = null,
    margin: TextMargin = TextMargin.none,
    multiline: Boolean? = null,
    name: String? = null,
    placeholder: String? = null,
    required: Boolean = false,
    rows: Int? = null,
    rowsMax: Int? = null,
    select: Boolean = false,
    SelectProps: Object? = null,
    onChange: OnChange? = null

) = child(TextField::class) {
    attrs {
        this.className = classes
        this.autoComplete = autoComplete
        this.autoFocus = autoFocus
        this.defaultValue = defaultValue
        this.disabled = disabled
        this.error = error
        this.FormHelperTextProps = FormHelperTextProps
        this.fullWidth = fullWidth
        this.helperText = helperText
        this.id = id
        this.InputLabelProps = InputLabelProps
        this.InputProps = InputProps
        if (inputProps != null) this.inputProps = inputProps
        this.inputRef = inputRef
        this.label = label
        this.margin = margin.toString()
        this.multiline = multiline
        this.name = name
        this.onChange = onChange
        this.placeholder = placeholder
        this.required = required
        this.rows = rows
        this.rowsMax = rowsMax
        this.select = select
        this.SelectProps = SelectProps
        this.type = type.toString()
        if (value != null) this.value = value
    }
}


private inline fun RBuilder.grid(
    alignContent: ContentAlign? = null,
    alignItems: ItemsAlign? = null,
    classes: String? = null,
    container: Boolean = false,
    direction: FlexDirection? = null,
    hidden: Object? = null,
    justify: ContentJustify? = null,
    xs: Int? = null,
    sm: Int? = null,
    md: Int? = null,
    lg: Int? = null,
    xl: Int? = null,
    spacing: Int? = null,
    wrap: Wrap? = null,
    zeroMinWidth: Boolean = false,
    crossinline handler: RHandler<dynamic>
) = child(Grid::class) {
    attrs {
        this.className = classes
        this.hidden = hidden
        if (container) {
            this.container = true
            this.spacing = spacing
            this.alignContent = alignContent.toString()
            this.alignItems = alignItems.toString()
            this.direction = direction.toString()
            this.justify = justify.toString()
            this.wrap = wrap.toString()
        } else {
            this.item = true
            this.xs = xs
            this.sm = sm
            this.md = md
            this.lg = lg
            this.xl = xl
            if (zeroMinWidth) this.zeroMinWidth = true
        }
    }
    handler()
}

/**
 * [xs], [sm], [md], [lg], [xl] - enum: true, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
 */
fun RBuilder.item(
    classes: String? = null,
    hidden: Object? = null,
    zeroMinWidth: Boolean = false,
    xs: Int? = null,
    sm: Int? = null,
    md: Int? = null,
    lg: Int? = null,
    xl: Int? = null,
    handler: RHandler<dynamic>
) = grid(
    classes = classes,
    hidden = hidden,
    zeroMinWidth = zeroMinWidth,
    xs = xs,
    sm = sm,
    md = md,
    lg = lg,
    xl = xl,
    handler = handler
)

/**
 * [spacing] - enum: 0, 8, 16, 24, 40
 */
fun RBuilder.container(
    classes: String? = null,
    hidden: Object? = null,
    spacing: Int = 16,
    alignContent: ContentAlign = ContentAlign.stretch,
    alignItems: ItemsAlign = ItemsAlign.stretch,
    direction: FlexDirection = FlexDirection.row,
    justify: ContentJustify? = ContentJustify.flexStart,
    wrap: Wrap = Wrap.wrap,
    handler: RHandler<dynamic>
) = grid(
    container = true,
    classes = classes,
    hidden = hidden,
    spacing = spacing,
    alignContent = alignContent,
    alignItems = alignItems,
    direction = direction,
    justify = justify,
    wrap = wrap,
    handler = handler
)