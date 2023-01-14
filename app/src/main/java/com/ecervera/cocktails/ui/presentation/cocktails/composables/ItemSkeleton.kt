package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun ItemSkeleton(
    modifier: Modifier = Modifier,
    brush: Brush,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = CocktailsTheme.dimensions.medium2,
                bottom = CocktailsTheme.dimensions.medium2
            )
            .clip(shape = RoundedCornerShape(24.dp)),
    ) {
        Box {
            Spacer(
                modifier = Modifier
                    .aspectRatio(18f / 9f)
                    .clip(shape = RoundedCornerShape(24.dp))
                    .background(brush)
            )
        }
        Column(
            modifier = Modifier.padding(CocktailsTheme.dimensions.medium2)
        ) {
            Spacer(
                modifier = Modifier
                    .height(14.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.6f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(
                modifier = Modifier
                    .height(14.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.4f)
                    .background(brush)
            )
        }
    }
}