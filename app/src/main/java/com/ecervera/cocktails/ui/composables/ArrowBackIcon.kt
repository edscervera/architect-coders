package com.ecervera.cocktails.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecervera.cocktails.ui.theme.CocktailsTheme


@Composable
fun ArrowBackIcon(onUpClick: () -> Unit) {
    IconButton(onClick = onUpClick, modifier = Modifier
        .background(
            color = CocktailsTheme.colors.iconBackground,
            shape = RoundedCornerShape(CocktailsTheme.dimensions.medium3),
        )
        .border(
            width = CocktailsTheme.dimensions.small,
            color = CocktailsTheme.colors.outline,
            shape = RoundedCornerShape(CocktailsTheme.dimensions.medium3)
        )
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "backIcon",
            tint = CocktailsTheme.colors.icon
        )
    }
}