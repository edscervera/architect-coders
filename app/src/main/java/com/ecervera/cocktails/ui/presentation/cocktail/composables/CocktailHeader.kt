package com.ecervera.cocktails.ui.presentation.cocktail.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun CocktailHeader(painterSource: String, title: String) {
    Box(
        modifier = Modifier.clip(
            shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
        )
    ) {
        Image(
            painter = rememberAsyncImagePainter(painterSource),
            modifier = Modifier
                .aspectRatio(1f),
            contentDescription = "background_image",
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .padding(CocktailsTheme.dimensions.medium3)
            .align(Alignment.BottomStart)
            .background(
                color = CocktailsTheme.colors.outline.copy(alpha = 0.6f),
                shape = RoundedCornerShape(CocktailsTheme.dimensions.medium2 + 4.dp)
            )
        ) {
            Text(
                text = title,
                color = CocktailsTheme.colors.title,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                modifier = Modifier
                    .padding(
                        horizontal = CocktailsTheme.dimensions.medium2,
                        vertical = CocktailsTheme.dimensions.small3)
            )
        }
    }
}