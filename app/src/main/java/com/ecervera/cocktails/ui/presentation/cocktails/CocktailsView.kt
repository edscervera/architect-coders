package com.ecervera.cocktails.ui.presentation.cocktails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.ui.composables.CocktailsApp
import com.ecervera.cocktails.ui.presentation.cocktails.composables.*
import com.ecervera.cocktails.ui.theme.CocktailsTheme
import timber.log.Timber

@Composable
fun CocktailsView(
    viewModel: CocktailsViewModel = hiltViewModel(),
    onClick: (String) -> Unit
) {
    val state = viewModel.state.collectAsState()

    viewModel.onUiReady()

    CocktailsApp {
        Column(
            modifier = Modifier.padding(CocktailsTheme.dimensions.medium3),
        ) {
            when (state.value.loading) {
                true -> { CocktailsSkeleton() }
                false -> {
                    state.value.error?.let {
                        Timber.e("Cannot retrieve drinks: $it")
                        Text("Error loaded drinks")
                    }
                    state.value.drinks?.let { drinks ->
                        if (drinks.isEmpty()) { Text(text = "No drinks") }
                        else ContentView(drinks = drinks, onClick = onClick)
                    }
                }
            }
        }
    }
}

@Composable
fun ContentView(drinks: List<Drink>, onClick: (String) -> Unit) {

    CocktailHeader()
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))

    Summary()
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))

    LazyColumn {
        items(drinks) { drink ->
            CardCocktail(onClick = onClick, drink = drink)
            Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))
        }
    }
}