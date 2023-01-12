package com.ecervera.cocktails.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

object CocktailsTheme {
    val colors: CocktailsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val dimensions: CocktailsShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val typography: CocktailsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

}

@Composable
fun CocktailsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: CocktailsColors = CocktailsTheme.colors,
    dimensions: CocktailsShapes = CocktailsTheme.dimensions,
    typography: CocktailsTypography = CocktailsTheme.typography,
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    val appColors = if (darkTheme) {
        systemUiController.setStatusBarColor(
            color = Gray600,
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = Gray600
        )
        darkColors()
    } else {
        systemUiController.setStatusBarColor(
            color = Gray100,
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(
            color = Gray100
        )
        lightColors()
    }
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(appColors) }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalShapes provides dimensions,
        LocalTypography provides typography
    ) {
        content()
    }
}