package com.ecervera.cocktails.ui.presentation.cocktail.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun CocktailBody(drink: Drink) {

    Column(
        modifier = Modifier
            .padding(CocktailsTheme.dimensions.medium3),
    ) {
        Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small3))

        Ingredients(drink)

        Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))
        Divider()
        Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))

        Steps(instructions = drink.instructions)
    }
}