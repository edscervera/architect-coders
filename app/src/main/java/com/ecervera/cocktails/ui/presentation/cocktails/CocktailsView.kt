package com.ecervera.cocktails.ui.presentation.cocktails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ecervera.cocktails.ui.composables.CocktailsApp
import com.ecervera.cocktails.ui.theme.CocktailsTheme
import com.ecervera.cocktails.ui.presentation.cocktails.composables.CardCocktail
import com.ecervera.cocktails.ui.presentation.cocktails.composables.Search
import com.ecervera.cocktails.ui.presentation.cocktails.composables.Summary

@Composable
fun CocktailsView(onClick:(String) -> Unit) {
    CocktailsApp {
        Column(
            modifier = Modifier.padding(CocktailsTheme.dimensions.medium3),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("DrinkUp",
                    fontSize = 32.sp,
                    lineHeight = 40.sp
                )
                Search()
            }

            Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))

            Summary()

            Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(CocktailsTheme.dimensions.medium2),
            ) {
                item {
                    CardCocktail(onClick, "1")
                }

                item {
                    CardCocktail(onClick, "2")
                }
            }
        }
    }
}