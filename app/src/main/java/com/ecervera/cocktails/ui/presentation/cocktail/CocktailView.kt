package com.ecervera.cocktails.ui.presentation.cocktail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ecervera.architectcoders.shared.ArrowBackIcon
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailView(id: String, onUpClick: () -> Unit) {

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val isCollapsed = remember { derivedStateOf { scrollBehavior.state.collapsedFraction > 0.5 } }

    val topAppBarElementColor = if (isCollapsed.value) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onPrimary
    }
    val collapsedTextSize = 22
    val expandedTextSize = 32

    val topAppBarTextSize =
        (collapsedTextSize + (expandedTextSize - collapsedTextSize) * (1 - scrollBehavior.state.collapsedFraction)).sp

    Scaffold(topBar = {
        LargeTopAppBar(
            title = {
                Text(text = "Detail page", fontSize = topAppBarTextSize)
            },
            navigationIcon = { ArrowBackIcon(onUpClick) },
            scrollBehavior = scrollBehavior,
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = CocktailsTheme.colors.primary,
                scrolledContainerColor = MaterialTheme.colorScheme.surface,
                navigationIconContentColor = topAppBarElementColor,
                titleContentColor = topAppBarElementColor,
                actionIconContentColor = topAppBarElementColor,
            ),
            modifier = Modifier.clip(
                shape = RoundedCornerShape(
                    bottomEnd = 30.dp, bottomStart = 30.dp
                )
            ),
        )
    },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        content = { innerPadding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(CocktailsTheme.dimensions.medium3)
                ) {

                    Image(
                        painter = rememberAsyncImagePainter("https://www.thecocktaildb.com/images/media/drink/tquyyt1451299548.jpg"),
                        modifier = Modifier.aspectRatio(3f / 4f),
                        contentDescription = "background_image",
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))

                    Text(
                        text = "Ingredients", fontSize = 24.sp, color = CocktailsTheme.colors.title
                    )
                    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))
                    Text(
                        text = "$id oz - Kalhua", fontSize = 16.sp, color = CocktailsTheme.colors.text
                    )
                    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small3))
                    Text(
                        text = "$id oz - Chocolate ice-scream", fontSize = 16.sp, color = CocktailsTheme.colors.text
                    )
                    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))
                    Divider()
                    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.medium2))
                    Text(
                        text = "Steps", fontSize = 24.sp, color = CocktailsTheme.colors.title
                    )
                    Spacer(modifier = Modifier.padding(CocktailsTheme.dimensions.small4))
                    Text(
                        text = "Combine all ingredients in an electric blender and blend at a low speed for a short length of time. Pour into a chilled champagne flute and serve.",
                        fontSize = 16.sp,
                        color = CocktailsTheme.colors.text
                    )
                }
            }
        })
}