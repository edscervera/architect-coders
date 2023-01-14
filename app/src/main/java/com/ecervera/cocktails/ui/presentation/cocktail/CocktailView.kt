package com.ecervera.cocktails.ui.presentation.cocktail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.ui.composables.ArrowBackIcon
import com.ecervera.cocktails.ui.presentation.cocktail.composables.*
import com.ecervera.cocktails.ui.theme.CocktailsTheme


@Composable
fun CocktailView(
    viewModel: CocktailViewModel = hiltViewModel(),
    onUpClick: () -> Unit
) {
    val drink = viewModel.state.collectAsState().value.drink

    when (drink != null) {
        true -> {
            ContentCocktailView(drink = drink, onUpClick)
        }
        false -> {
            Text("error with load data into detail page")
        }
    }
}

@Composable
fun ContentCocktailView(drink: Drink, onUpClick: () -> Unit) {

    val paddingMedium = CocktailsTheme.dimensions.medium3
    Box {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                CocktailHeader(painterSource = drink.painter, title = drink.name)
                Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))
            }

            item {
                Text(
                    text = "Ingredients", fontSize = 24.sp,
                    color = CocktailsTheme.colors.title,
                    modifier = Modifier.padding(horizontal = paddingMedium)
                )
                Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))
            }

            items(drink.ingredientsAndMeasure) {
                Ingredient(
                    ingredient = it.ingredient,
                    measure = it.measure,
                    modifier = Modifier.padding(horizontal = paddingMedium)
                )
                Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small3))
            }

            item { CocktailDivider() }
            item { Steps(
                instructions = drink.instructions,
                modifier = Modifier.padding(paddingMedium)
            )}
        }
        Box(modifier = Modifier.padding(CocktailsTheme.dimensions.medium3)) {
            ArrowBackIcon(onUpClick)
        }
    }
}