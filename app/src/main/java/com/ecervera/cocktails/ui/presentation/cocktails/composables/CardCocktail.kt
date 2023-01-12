package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCocktail(onClick: (String) -> Unit, id: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(24.dp)),
        colors = CardDefaults.cardColors(
            containerColor =  CocktailsTheme.colors.background,
        ),
        content = {
            Box {
                Image(
                    painter = rememberAsyncImagePainter("https://www.thecocktaildb.com/images/media/drink/tquyyt1451299548.jpg"),
                    modifier = Modifier
                        .aspectRatio(18f / 9f)
                        .clip(shape = RoundedCornerShape(24.dp)),
                    contentDescription = "cocktailImage",
                    contentScale = ContentScale.Crop
                )
            }
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