package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ecervera.cocktails.R
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
            Column(modifier = Modifier.padding(CocktailsTheme.dimensions.medium3)) {
                Text("\uD83C\uDF79 ${stringResource(R.string.total_drinks)}: 635",
                    style = MaterialTheme.typography.labelLarge)
                Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))
                Text("\uD83C\uDF4B ${stringResource(R.string.total_ingredients)}: 489",
                    style = MaterialTheme.typography.labelLarge)
            }
        },
        shape = RoundedCornerShape(CocktailsTheme.dimensions.medium3)
    )
}