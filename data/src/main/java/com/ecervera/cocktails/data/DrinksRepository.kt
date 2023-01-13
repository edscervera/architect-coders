package com.ecervera.cocktails.data

import com.ecervera.cocktails.data.datasource.DrinkLocalDataSource
import com.ecervera.cocktails.data.datasource.DrinkRemoteDataSource
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.domain.Error
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DrinksRepository @Inject constructor(
    private val localDataSource: DrinkLocalDataSource,
    private val remoteDataSource: DrinkRemoteDataSource
) {
    val latestDrinks get() = localDataSource.drinks

    fun findById(id: String): Flow<Drink> = localDataSource.findById(id)

    suspend fun requestLatestDrinks(): Error? {
        if (localDataSource.isEmpty()) {
            val drinks = remoteDataSource.findLatestDrinks()
            drinks.fold(ifLeft = { return it }) {
                localDataSource.save(it)
            }
        }
        return null
    }

    suspend fun switchFavorite(drink: Drink): Error? {
        val updatedDrink = drink.copy(isFavorite = !drink.isFavorite)
        return localDataSource.save(listOf(updatedDrink))
    }
}