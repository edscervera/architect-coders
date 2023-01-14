package com.ecervera.cocktails.data.database

import com.ecervera.cocktails.data.datasource.DrinkLocalDataSource
import com.ecervera.cocktails.data.tryCall
import com.ecervera.cocktails.domain.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.data.database.Drink as DbDrink

class DrinkRoomDataSource @Inject constructor(private val drinkDao: DrinkDao) :
    DrinkLocalDataSource {

    override val drinks: Flow<List<Drink>> = drinkDao.getAll().map { it.toDomainModel() }

    override suspend fun isEmpty(): Boolean = drinkDao.drinkCount() == 0

    override fun findById(id: String): Flow<Drink> = drinkDao.findById(id).map { it.toDomainModel() }

    override suspend fun save(drinks: List<Drink>): Error? = tryCall {
        drinkDao.insertDrinks(drinks.fromDomainModel())
    }.fold(
        ifLeft = { it },
        ifRight = { null }
    )
}

private fun List<DbDrink>.toDomainModel(): List<Drink> = map { it.toDomainModel() }

private fun DbDrink.toDomainModel(): Drink =
    Drink(
        idDrink = idDrink,
        alcoholic,
        category,
        creativeCommonsConfirmed,
        name,
        drinkThumb,
        glass,
        imageSource,
        ingredient1,
        ingredient10,
        ingredient11,
        ingredient12,
        ingredient13,
        ingredient14,
        ingredient15,
        ingredient2,
        ingredient3,
        ingredient4,
        ingredient5,
        ingredient6,
        ingredient7,
        ingredient8,
        ingredient9,
        instructions,
        measure1,
        measure10,
        measure11,
        measure12,
        measure13,
        measure14,
        measure15,
        measure2,
        measure3,
        measure4,
        measure5,
        measure6,
        measure7,
        measure8,
        measure9,
        tags,
        video,
        isFavorite,
    )

private fun List<Drink>.fromDomainModel(): List<DbDrink> = map { it.fromDomainModel() }

private fun Drink.fromDomainModel(): DbDrink = DbDrink(
    idDrink = idDrink,
    alcoholic,
    category,
    creativeCommonsConfirmed,
    name,
    drinkThumb,
    glass,
    imageSource,
    ingredient1,
    ingredient10,
    ingredient11,
    ingredient12,
    ingredient13,
    ingredient14,
    ingredient15,
    ingredient2,
    ingredient3,
    ingredient4,
    ingredient5,
    ingredient6,
    ingredient7,
    ingredient8,
    ingredient9,
    instructions,
    measure1,
    measure10,
    measure11,
    measure12,
    measure13,
    measure14,
    measure15,
    measure2,
    measure3,
    measure4,
    measure5,
    measure6,
    measure7,
    measure8,
    measure9,
    tags,
    video,
    isFavorite,
)