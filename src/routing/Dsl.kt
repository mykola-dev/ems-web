package routing

import react.*
import react.React.Component
import kotlin.reflect.KClass

fun RBuilder.hashRouter(handler: RHandler<RProps>) = child(HashRouterComponent::class, handler)

fun RBuilder.switch(handler: RHandler<RProps>) = child(SwitchComponent::class, handler)

fun RBuilder.route(
    path: String,
    component: KClass<out Component<*, *>>,
    exact: Boolean = false,
    strict: Boolean = false
): ReactElement = child<RouteProps<RProps>, RouteComponent<RProps>> {
    attrs {
        this.path = path
        this.exact = exact
        this.strict = strict
        this.component = component.js.unsafeCast<RClass<RProps>>()
    }
}

fun <T : RProps> RBuilder.route(
    path: String,
    render: (props: RouteResultProps<T>) -> ReactElement,
    exact: Boolean = false,
    strict: Boolean = false
): ReactElement = child<RouteProps<T>, RouteComponent<T>> {
    attrs {
        this.path = path
        this.exact = exact
        this.strict = strict
        this.render = render
    }
}

fun RBuilder.route(path: String, exact: Boolean = false, strict: Boolean = false, render: () -> ReactElement): ReactElement =
    child<RouteProps<RProps>, RouteComponent<RProps>> {
        attrs {
            this.path = path
            this.exact = exact
            this.strict = strict
            this.render = { render() }
        }
    }

fun RBuilder.routeLink(to: String, replace: Boolean = false, handler: RHandler<RProps>? = null) = child(LinkComponent::class) {
    attrs {
        this.to = to
        this.replace = replace
    }
    handler?.invoke(this)
}

fun RBuilder.redirect(to: String, from: String? = null) = child(Redirect::class) {
    attrs {
        this.to = to
        this.from = from
    }
}