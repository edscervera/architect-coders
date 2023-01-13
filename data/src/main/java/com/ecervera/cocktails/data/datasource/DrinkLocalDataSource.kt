package com.ecervera.cocktails.data.datasource

import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.domain.Error
import kotlinx.coroutines.flow.Flow

interface DrinkLocalDataSource {
    val drinks: Flow<List<Drink>>

    suspend fun isEmpty(): Boolean
    fun findById(id: String): Flow<Drink>
    suspend fun save(drinks: List<Drink>): Error?
}