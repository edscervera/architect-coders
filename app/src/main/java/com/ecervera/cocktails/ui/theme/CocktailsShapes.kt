package com.ecervera.cocktails.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CocktailsShapes(
    val small: Dp = 1.dp,
    val small2: Dp = 2.dp,
    val small3: Dp = 4.dp,
    val small4: Dp = 8.dp,
    val medium: Dp = 12.dp,
    val medium2: Dp = 16.dp,
    val medium3: Dp = 24.dp,
    val medium4: Dp = 32.dp,
    val large: Dp = 40.dp,
    val large2: Dp = 48.dp,
    val large3: Dp = 56.dp
)

internal val LocalShapes = staticCompositionLocalOf { CocktailsShapes() }