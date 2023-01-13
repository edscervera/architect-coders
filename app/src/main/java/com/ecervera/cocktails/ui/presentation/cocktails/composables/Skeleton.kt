package com.ecervera.cocktails.ui.presentation.cocktails.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Skeleton() {
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