package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun Summary() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        //set background color of the card
        colors = CardDefaults.cardColors(
            containerColor =  CocktailsTheme.colors.lightPrimary,
        ),
        content = {
            Column {
                Text("\uD83C\uDF79 Total Drinks: 635",
                    modifier = Modifier.padding(CocktailsTheme.dimensions.medium2),
                    style = MaterialTheme.typography.labelLarge)
                Text("\uD83C\uDF4B Total Ingredients: 489",
                    modifier = Modifier.padding(
                    CocktailsTheme.dimensions.medium2),
                    style = MaterialTheme.typography.labelLarge)
            }
        },
        shape = RoundedCornerShape(CocktailsTheme.dimensions.medium3)
    )
}