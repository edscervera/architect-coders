package com.ecervera.cocktails.ui.presentation.cocktails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
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
                true -> {
                    CocktailsSkeleton()
                }
                false -> {
                    state.value.error?.let {
                        Timber.e("Cannot retrieve drinks: $it")
                    }
                    state.value.drinks?.let { drinks ->

                        if (drinks.isEmpty()) {
                            Text(text = "No drinks")
                        } else {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "DrinkUp",
                                    fontSize = 32.sp,
                                    lineHeight = 40.sp
                                )
                                Search()
                            }

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
                    }
                }
            }
        }
    }
}