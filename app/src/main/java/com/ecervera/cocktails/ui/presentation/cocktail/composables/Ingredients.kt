package com.ecervera.cocktails.ui.presentation.cocktail.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun Ingredients(drink: Drink) {

    Text(
        text = "Ingredients", fontSize = 24.sp, color = CocktailsTheme.colors.title
    )
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))

    Ingredient(ingredient = drink.ingredient1, measure = drink.measure1)
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small3))
    Ingredient(ingredient = drink.ingredient2 ?: "", measure = drink.measure2 ?: "")
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small3))
    Ingredient(ingredient = drink.ingredient3 ?: "", measure = drink.measure3 ?: "")
}