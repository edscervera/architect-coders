package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecervera.cocktails.ui.composables.LoadingSkeleton

@Composable
fun CocktailsSkeleton() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        repeat(10) {
            item {
                LoadingSkeleton {
                    ItemSkeleton(brush = it)
                }
            }
        }
    }
}