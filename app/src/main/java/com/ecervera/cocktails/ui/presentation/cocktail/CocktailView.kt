package com.ecervera.cocktails.ui.presentation.cocktail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.ecervera.architectcoders.shared.ArrowBackIcon
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.ui.presentation.cocktail.composables.Steps
import com.ecervera.cocktails.ui.theme.CocktailsTheme


@Composable
fun CocktailView(
    viewModel: CocktailViewModel = hiltViewModel(),
    onUpClick: () -> Unit
) {
    val drink = viewModel.state.collectAsState().value.drink

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier.clip(
                shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
            )
        ) {
            ArrowBackIcon(onUpClick)
            Image(
                painter = rememberAsyncImagePainter(drink?.painter),
                modifier = Modifier
                    .aspectRatio(1f),
                    //.fillMaxHeight(0.5f),
                    //.fillMaxWidth(),
                contentDescription = "background_image",
                contentScale = ContentScale.Crop
            )
            Text(text = drink?.name ?: "")
        }

        Column(
            modifier = Modifier
                .padding(CocktailsTheme.dimensions.medium3)
        ) {
            Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))

            Ingredients(drink)

            Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))
            Divider()
            Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))

            Steps(instructions = drink?.instructions ?: "")
        }
    }
}

@Composable
fun Ingredient(ingredient: String, measure: String) {
    Text(
        text = "$measure oz - $ingredient",
        fontSize = 16.sp,
        color = CocktailsTheme.colors.text
    )
}

@Composable
fun Ingredients(drink: Drink?) {

    Text(
        text = "Ingredients", fontSize = 24.sp, color = CocktailsTheme.colors.title
    )
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))

    Ingredient(ingredient = drink?.ingredient1 ?: "", measure = drink?.measure1 ?: "")
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small3))
    Ingredient(ingredient = drink?.ingredient2 ?: "", measure = drink?.measure2 ?: "")
    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small3))
    Ingredient(ingredient = drink?.ingredient3 ?: "", measure = drink?.measure3 ?: "")
}

class di {
}