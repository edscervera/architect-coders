package com.ecervera.cocktails.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class CocktailsColors(
    primary: Color,
    lightPrimary: Color,
    background: Color,
    outline: Color,
    error: Color,
    warning: Color,
    success: Color,
    title: Color,
    text: Color,
    icon: Color,
    iconOnPrimary: Color,
    gray: Color,
    iconBackground: Color,
    skeleton: Color,
    divider: Color,
    isLight: Boolean,
) {
    var primary by mutableStateOf(primary)
        private set
    var lightPrimary by mutableStateOf(lightPrimary)
        private set
    var background by mutableStateOf(background)
        private set
    var outline by mutableStateOf(outline)
        private set
    var error by mutableStateOf(error)
        private set
    var warning by mutableStateOf(warning)
        private set
    var success by mutableStateOf(success)
        private set
    var title by mutableStateOf(title)
        private set
    var text by mutableStateOf(text)
        private set
    var icon by mutableStateOf(icon)
        private set
    var iconOnPrimary by mutableStateOf(iconOnPrimary)
        private set
    var gray by mutableStateOf(gray)
        private set
    var iconBackground by mutableStateOf(iconBackground)
        private set
    var skeleton by mutableStateOf(skeleton)
        private set
    var divider by mutableStateOf(divider)
        private set
    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        primary: Color = this.primary,
        lightPrimary: Color = this.lightPrimary,
        background: Color = this.background,
        outline: Color = this.outline,
        error: Color = this.error,
        warning: Color = this.warning,
        success: Color = this.success,
        title: Color = this.title,
        text: Color = this.text,
        icon: Color = this.icon,
        iconOnPrimary: Color = this.icon,
        gray: Color = this.gray,
        iconBackground: Color = this.iconBackground,
        skeleton: Color = this.skeleton,
        divider: Color = this.divider,
        isLight: Boolean = this.isLight,
    ): CocktailsColors = CocktailsColors(
        primary,
        lightPrimary,
        background,
        outline,
        error,
        warning,
        success,
        title,
        text,
        icon,
        iconOnPrimary,
        gray,
        iconBackground,
        skeleton,
        divider,
        isLight
    )

    fun updateColorsFrom(cocktailsColors: CocktailsColors) {
        primary = cocktailsColors.primary
        lightPrimary = cocktailsColors.lightPrimary
        background = cocktailsColors.background
        outline = cocktailsColors.outline
        error = cocktailsColors.error
        warning = cocktailsColors.warning
        success = cocktailsColors.success
        title = cocktailsColors.title
        text = cocktailsColors.text
        icon = cocktailsColors.icon
        iconOnPrimary = cocktailsColors.iconOnPrimary
        skeleton = cocktailsColors.skeleton
        gray = cocktailsColors.gray
        iconBackground = cocktailsColors.iconBackground
        divider = cocktailsColors.divider
    }
}

fun lightColors(
    primary: Color = Primary500,
    lightPrimary: Color = Primary100,
    background: Color = Gray200,
    outline: Color = Gray300,
    error: Color = Error500,
    warning: Color = Warning500,
    success: Color = Success500,
    title: Color = Gray600,
    text: Color = Gray400,
    icon: Color = Gray500,
    iconOnPrimary: Color = Primary500,
    gray: Color = Gray400,
    iconBackground: Color = Gray100,
    skeleton: Color = Gray300,
    divider: Color = Gray200,
): CocktailsColors = CocktailsColors(
    primary = primary,
    lightPrimary = lightPrimary,
    background = background,
    outline = outline,
    error = error,
    warning = warning,
    success = success,
    title = title,
    text = text,
    icon = icon,
    iconOnPrimary = iconOnPrimary,
    gray = gray,
    iconBackground = iconBackground,
    skeleton = skeleton,
    divider = divider,
    isLight = true
)

fun darkColors(
    primary: Color = Primary500,
    lightPrimary: Color = Primary100,
    background: Color = Gray600,
    outline: Color = Gray600,
    error: Color = Error400,
    warning: Color = Warning400,
    success: Color = Success400,
    title: Color = Gray100,
    text: Color = Gray300,
    icon: Color = Gray400,
    iconOnPrimary: Color = Gray600,
    gray: Color = Gray400,
    iconBackground: Color = Gray400,
    skeleton: Color = Gray500,
    divider: Color = Gray600,
): CocktailsColors = CocktailsColors(
    primary = primary,
    lightPrimary = lightPrimary,
    background = background,
    outline = outline,
    error = error,
    warning = warning,
    success = success,
    title = title,
    text = text,
    icon = icon,
    iconOnPrimary = iconOnPrimary,
    gray = gray,
    iconBackground = iconBackground,
    skeleton = skeleton,
    divider = divider,
    isLight = false
)

val LocalColors = staticCompositionLocalOf { lightColors() }
