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
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCocktail(drink: Drink, onClick: (String) -> Unit) {
    lateinit var sourceImage: String

    if(drink.imageSource.contains("www.thecocktaildb.com")) {
        sourceImage = drink.imageSource
    } else sourceImage = drink.drinkThumb ?: ""


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
                    painter = rememberAsyncImagePainter(sourceImage),
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
                    drink.name,
                    color = CocktailsTheme.colors.title,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(drink.category,
                    color = CocktailsTheme.colors.text,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        },
        onClick = { onClick(drink.idDrink) }
    )
}