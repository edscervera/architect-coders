package com.ecervera.cocktails.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecervera.cocktails.ui.theme.CocktailsTheme

@Composable
fun CocktailsApp(content: @Composable () -> Unit) {
    CocktailsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) { content() }
    }
}