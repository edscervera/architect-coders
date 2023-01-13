package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun ItemSkeleton(
    modifier: Modifier = Modifier,
    brush: Brush,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = CocktailsTheme.dimensions.medium2,
                top = CocktailsTheme.dimensions.medium2,
                bottom = CocktailsTheme.dimensions.medium2
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .size(CocktailsTheme.dimensions.large2)
                .clip(RoundedCornerShape(CocktailsTheme.dimensions.medium3))
                .background(brush)
        )
        Spacer(modifier = Modifier.width(CocktailsTheme.dimensions.medium2))
        Column {
            Spacer(
                modifier = Modifier
                    .height(14.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.5f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(
                modifier = Modifier
                    .height(14.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.9f)
                    .background(brush)
            )
        }
    }
}