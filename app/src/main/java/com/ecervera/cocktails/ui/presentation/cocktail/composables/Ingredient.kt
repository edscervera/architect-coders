package com.ecervera.cocktails.ui.presentation.cocktail.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ecervera.cocktails.ui.theme.CocktailsTheme


@Composable
fun Ingredient(ingredient: String, measure: String, modifier: Modifier) {
    Text(
        text = "$measure oz - $ingredient",
        fontSize = 16.sp,
        color = CocktailsTheme.colors.text,
        modifier = modifier
    )
}