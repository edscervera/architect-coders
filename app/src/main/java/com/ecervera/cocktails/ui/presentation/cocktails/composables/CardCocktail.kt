package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCocktail(onClick: (String) -> Unit, id: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        //set background color of the card
        colors = CardDefaults.cardColors(
            containerColor =  CocktailsTheme.colors.background,
        ),
        content = {
            Column(
                modifier = Modifier.padding(CocktailsTheme.dimensions.medium2)
            ) {
                Text(
                    "Chocolate Black Russian",
                    color = CocktailsTheme.colors.title,
                    style = MaterialTheme.typography.labelLarge
                )
                Text("Ordinary Drink",
                    color = CocktailsTheme.colors.text,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        },
        onClick = { onClick(id) }
    )
}