package material

import kotlinext.js.JsFunction0
import kotlinext.js.Object
import kotlinx.html.InputType
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventTarget
import react.RBuilder
import react.RHandler
import react.React
import react.ReactElement
import kotlin.reflect.KClass


typealias OnTabChange = (event: Event, value: Int) -> Unit
typealias OnChecked = (event: Event, checked: Boolean) -> Unit
typealias EventCallback = (event: Event) -> Unit
typealias OnChange = EventCallback
typealias OnClick = EventCallback

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
 * Convenient alias for item grid
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
 * Convenient alias for container grid
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

fun RBuilder.list(
    classes: String? = null,
    dense: Boolean = false,
    disablePadding: Boolean = false,
    subheader: ReactElement? = null,
    handler: RHandler<dynamic>
) = child(List::class) {
    attrs {
        this.className = classes
        this.dense = dense
        this.disablePadding = disablePadding
        this.subheader = subheader
    }
    handler()
}

fun RBuilder.listItem(
    classes: String? = null,
    button: Boolean = false,
    dense: Boolean = false,
    disableGutters: Boolean = false,
    divider: Boolean = false,
    onClick: OnClick? = null,
    handler: RHandler<dynamic>
) = child(ListItem::class) {
    attrs {
        this.className = classes
        this.button = button
        this.dense = dense
        this.disableGutters = disableGutters
        this.divider = divider
        this.onClick = onClick
    }
    handler()
}

fun RBuilder.listSubheader(
    classes: String? = null,
    color: Color = Color.default,//'default' | 'primary' | 'inherit'
    disableSticky: Boolean = false,
    inset: Boolean = false,
    handler: RHandler<dynamic>
) = child(ListSubheader::class) {
    attrs {
        this.className = classes
        this.color = color
        this.disableSticky = disableSticky
        this.inset = inset
    }
    handler()
}

fun RBuilder.listItemIcon(
    iconName: String? = null,
    children: ReactElement? = null,
    classes: String? = null
) = child(ListItemIcon::class) {
    attrs {
        this.className = classes
        if (iconName != null) {
            this.children = icon(iconName)
        } else {
            this.children = children
        }
    }
}

fun RBuilder.iconButton(
    iconName: String? = null,
    children: ReactElement? = null,
    classes: String? = null,
    disabled: Boolean = false,
    disableRipple: Boolean = false,
    color: Color = Color.default  // 'default' |    'inherit' |'primary' |'secondary'
) = child(IconButton::class) {
    attrs {
        this.className = classes
        this.color = color
        this.disabled = disabled
        this.disableRipple = disableRipple
        if (iconName != null) {
            this.children = icon(iconName)
        } else {
            this.children = children
        }
    }
}

fun RBuilder.listItemText(
    primary: String? = null,
    secondary: String? = null,
    inset: Boolean = false,
    disableTypography: Boolean = false,
    classes: String? = null
) = child(ListItemText::class) {
    attrs {
        this.className = classes
        this.primary = primary
        this.secondary = secondary
        this.inset = inset
        this.disableTypography = disableTypography
    }
}

fun RBuilder.divider(
    absolute: Boolean = false,
    classes: String? = null,
    inset: Boolean = false,
    light: Boolean = false
) = child(Divider::class) {
    attrs {
        this.className = classes
        this.absolute = absolute
        this.inset = inset
        this.light = light
    }
}

fun RBuilder.checkbox(
    checked: Boolean = false,
    disabled: Boolean = false,
    icon: Icon? = null,
    color: Color = Color.secondary, // primary | secondary
    checkedIcon: Icon? = null,
    indeterminateIcon: Icon? = null,
    disableRipple: Boolean = false,
    indeterminate: Boolean = false,
    id: String? = null,
    value: String = "",
    inputProps: Object? = null,
    inputRef: JsFunction0<*>? = null,
    type: String? = null,
    classes: String? = null,
    onChange: OnChecked? = null
) = child(Checkbox::class) {
    attrs {
        this.className = classes
        this.color = color.toString()
        this.value = value
        if (icon != null) this.icon = icon
        if (checkedIcon != null) this.checkedIcon = checkedIcon
        if (indeterminateIcon != null) this.indeterminateIcon = indeterminateIcon
        this.checked = checked
        this.disabled = disabled
        this.disableRipple = disableRipple
        this.indeterminate = indeterminate
        this.id = id
        this.inputProps = inputProps
        this.inputRef = inputRef
        if (type != null) this.type = type
        this.onChange = onChange
    }
}

fun RBuilder.switch(
    checked: Boolean = false,
    icon: Icon? = null,
    checkedIcon: Icon? = null,
    disabled: Boolean = false,
    disableRipple: Boolean = false,
    id: String? = null,
    inputProps: Object? = null,
    inputRef: JsFunction0<*>? = null,
    type: String? = null,
    value: String = "",
    color: Color = Color.secondary,   // 'primary' | 'inherit'
    classes: String? = null,
    onChange: OnChecked? = null
) = child(Switch::class) {
    attrs {
        if (icon != null) this.icon = icon
        if (checkedIcon != null) this.checkedIcon = checkedIcon
        this.disabled = disabled
        this.disableRipple = disableRipple
        this.checked = checked
        this.className = classes
        this.color = color.toString()
        this.id = id
        this.inputProps = inputProps
        this.inputRef = inputRef
        if (type != null) this.type = type
        this.onChange = onChange
        this.value = value
    }
}

fun <T : React.Component<dynamic, *>> RBuilder.formControlLabel(
    label: String,
    controlClass: KClass<T>,
    checked: Boolean = false,
    disabled: Boolean = false,
    name: String? = null,
    inputRef: JsFunction0<*>? = null,
    value: String? = null,
    classes: String? = null,
    onChange: OnChecked? = null
) = child(FormControlLabel::class) {
    val control = node(controlClass, Object.asDynamic())
    attrs {
        this.label = label
        this.checked = checked
        this.disabled = disabled
        this.name = name
        this.inputRef = inputRef
        if (value != null) this.value = value
        this.classes = classes
        this.onChange = onChange
        this.control = control
    }
}

fun RBuilder.menu(
    open: Boolean = false,
    anchorEl: EventTarget? = null,
    classes: String? = null,
    onClose: EventCallback? = null,
    /*onEnter: EventCallback? = null,
    onEntered: EventCallback? = null,
    onEntering: EventCallback? = null,
    onExit: EventCallback? = null,
    onExited: EventCallback? = null,
    onExiting: EventCallback? = null,*/
    MenuListProps: Object? = null,
    PopoverClasses: Object? = null,
    transitionDuration: Long? = null,
    handler: RHandler<dynamic>
) = child(Menu::class) {
    attrs {
        this.className = classes
        this.open = open
        this.anchorEl = anchorEl
        this.MenuListProps = MenuListProps
        this.onClose = onClose
        //this.onEnter = onEnter
        //this.onEntered = onEntered
        //this.onEntering = onEntering
        //this.onExit = onExit
        //this.onExited = onExited
        //this.onExiting = onExiting
        this.PopoverClasses = PopoverClasses
        if (transitionDuration != null) this.transitionDuration = transitionDuration
    }
    handler()
}

fun RBuilder.menuItem(
    title: String? = null,
    selected: Boolean = false,
    classes: String? = null,
    onClick: OnClick? = null,
    handler: RHandler<dynamic>? = null
) = child(MenuItem::class) {
    attrs {
        this.className = classes
        this.selected = selected
        this.onClick = onClick
        if (title != null) {
            this.children = title
        } else if (handler != null) {
            handler()
        }
    }
}

fun RBuilder.dialog(
    open: Boolean = false,
    disableBackdropClick: Boolean = false,
    disableEscapeKeyDown: Boolean = false,
    fullScreen: Boolean = false,
    fullWidth: Boolean = false,
    maxWidth: DialogMaxWidth = DialogMaxWidth.sm,
    onBackdropClick: OnClick? = null,
    onClose: EventCallback? = null,
    PaperProps: Object? = null,
    classes: String? = null,
    handler: RHandler<dynamic>
) = child(Dialog::class) {
    attrs {
        this.className = classes
        this.open = open
        this.disableBackdropClick = disableBackdropClick
        this.disableEscapeKeyDown = disableEscapeKeyDown
        this.fullScreen = fullScreen
        this.fullWidth = fullWidth
        this.maxWidth = maxWidth.toString()
        this.onBackdropClick = onBackdropClick
        this.onClose = onClose
        this.PaperProps = PaperProps
    }
    handler()
}

fun RBuilder.dialogTitle(
    title: String,
    disableTypography: Boolean = false,
    classes: String? = null
) = child(DialogTitle::class) {
    attrs {
        this.className = classes
        this.disableTypography = disableTypography
        this.children = title
    }
}

fun RBuilder.dialogContent(
    classes: String? = null,
    handler: RHandler<dynamic>
) = child(DialogContent::class) {
    attrs {
        this.className = classes
    }
    handler()
}

fun RBuilder.dialogContentText(
    text: String,
    classes: String? = null
) = child(DialogContentText::class) {
    attrs {
        this.children = text
        this.className = classes
    }
}

fun RBuilder.dialogActions(
    classes: String? = null,
    disableActionSpacing: Boolean = false,
    handler: RHandler<dynamic>
) = child(DialogActions::class) {
    attrs {
        this.className = classes
        this.disableActionSpacing = disableActionSpacing
    }
    handler()
}

fun RBuilder.themeWrapper(
    theme: dynamic,
    handler: RHandler<dynamic>
) = child(MuiThemeProvider::class) {
    attrs {
        this.theme = theme
    }
    handler()
}

fun RBuilder.circularProgress(
    value: Int = 0,
    color: Color = Color.primary, //'primary' |    'secondary' |'inherit',
    min: Int = 0,
    max: Int = 100,
    size: Int = 40,
    variant: CircularProgressVariant = CircularProgressVariant.indeterminate,
    thickness: Float = 3.6f,
    classes: String? = null
) = child(CircularProgress::class) {
    attrs {
        this.value = value
        this.className = classes
        this.color = color.toString()
        this.min = min
        this.max = max
        this.size = size
        this.variant = variant.toString()
        this.thickness = thickness
    }
}

fun RBuilder.linearProgress(
    value: Int = 0,
    valueBuffer: Int = 0,
    variant: LinearProgressVariant = LinearProgressVariant.indeterminate,
    color: Color = Color.secondary, //'primary' | 'secondary'
    classes: String? = null
) = child(LinearProgress::class) {
    attrs {
        this.value = value
        this.valueBuffer = valueBuffer
        this.variant = variant.toString()
        this.color = color.toString()
        this.className = classes
    }
}

fun buildTheme(primary: Palette, secondary: Palette): Theme = Theme(Theme.PaletteContainer(primary, secondary))