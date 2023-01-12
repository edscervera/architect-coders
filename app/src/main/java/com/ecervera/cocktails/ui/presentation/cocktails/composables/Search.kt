package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun Search() {
    IconButton(
        modifier = Modifier.size(CocktailsTheme.dimensions.medium3),
        onClick = { }
    ) {
        Icon(
            Icons.Filled.Search,
            "Search drink",
        )
    }
}