package com.ecervera.cocktails.ui.presentation.cocktail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.ui.presentation.cocktail.composables.*


@Composable
fun CocktailView(
    viewModel: CocktailViewModel = hiltViewModel(),
    onUpClick: () -> Unit
) {
    val drink = viewModel.state.collectAsState().value.drink

    when(drink != null) {
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
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        CocktailHeader(painterSource = drink.painter, title = drink.name, onUpClick)
        CocktailBody(drink)
    }
}