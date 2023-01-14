package com.ecervera.cocktails.ui.presentation.cocktail.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.ecervera.cocktails.R
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun Steps(instructions: String, modifier: Modifier = Modifier.padding()) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.steps),
            fontSize = 24.sp,
            color = CocktailsTheme.colors.title
        )
        Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))
        Text(
            text = instructions,
            fontSize = 16.sp,
            color = CocktailsTheme.colors.text
        )
    }
}