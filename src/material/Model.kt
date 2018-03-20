package material

data class Theme(var palette: PaletteContainer) {

    data class PaletteContainer(
        val primary: Palette,
        val secondary: Palette
    )
}

data class Palette(
    val main: String? = null,
    val light: String? = null,
    val dark: String? = null,
    val contrastText: String? = null
)

