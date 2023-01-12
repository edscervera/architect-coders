package com.ecervera.cocktails.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.ecervera.cocktails.R

val fonts = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold),
    Font(R.font.roboto_italic),
    Font(R.font.roboto_light),
    Font(R.font.roboto_medium),
    Font(R.font.roboto_regular),
    Font(R.font.roboto_thin),
)

@Immutable
data class CocktailsTypography(
    val fontFamily: FontFamily,
    val textStyle: TextStyle
)


internal val LocalTypography = staticCompositionLocalOf {
    CocktailsTypography(
        fontFamily = fonts,
        textStyle = TextStyle.Default
    )
}


// Set of Material typography styles to start with

/*
val CocktailsTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
) */