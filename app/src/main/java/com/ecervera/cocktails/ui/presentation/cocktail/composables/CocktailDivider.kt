package com.ecervera.cocktails.ui.presentation.cocktail.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun CocktailDivider() {
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))
    Divider(modifier = Modifier.padding(horizontal = CocktailsTheme.dimensions.medium3))
}