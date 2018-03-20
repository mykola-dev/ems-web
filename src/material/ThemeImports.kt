@file:JsModule("material-ui/styles")

package material

import react.RState
import react.React
import react.ReactElement

external fun createMuiTheme(theme: Theme)

external class MuiThemeProvider : React.Component<dynamic, RState> {
    override fun render(): ReactElement
}
