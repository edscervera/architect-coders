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

    override fun findById(id: Int): Flow<Drink> = drinkDao.findById(id).map { it.toDomainModel() }

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
        dateModified = dateModified,
        alcoholic,
        category,
        creativeCommonsConfirmed,
        name = name,
        drinkAlternate = drinkAlternate,
        drinkThumb = drinkThumb,
        glass = glass,
        IBA = IBA,
        imageAttribution = imageAttribution,
        imageSource = imageSource,
        ingredient1 = ingredient1,
        ingredient10 = ingredient10,
        ingredient11 = ingredient11,
        ingredient12 = ingredient12,
        ingredient13 = ingredient13,
        ingredient14 = ingredient14,
        ingredient15 = ingredient15,
        ingredient2 = ingredient2,
        ingredient3 = ingredient3,
        ingredient4 = ingredient4,
        ingredient5 = ingredient5,
        ingredient6 = ingredient6,
        ingredient7 = ingredient7,
        ingredient8 = ingredient8,
        ingredient9 = ingredient9,
        instructions = instructions,
        measure1 = measure1,
        measure10 = measure10,
        measure11 = measure11,
        measure12 = measure12,
        measure13 = measure13,
        measure14 = measure14,
        measure15 = measure15,
        measure2 = measure2,
        measure3 = measure3,
        measure4 = measure4,
        measure5 = measure5,
        measure6 = measure6,
        measure7 = measure7,
        measure8 = measure8,
        measure9 = measure9,
        tags = tags,
        video = video,
        isFavorite = isFavorite,
    )

private fun List<Drink>.fromDomainModel(): List<DbDrink> = map { it.fromDomainModel() }

private fun Drink.fromDomainModel(): DbDrink = DbDrink(
    idDrink,
    dateModified,
    alcoholic,
    category,
    creativeCommonsConfirmed,
    name,
    drinkAlternate,
    drinkThumb = drinkThumb,
    glass = glass,
    IBA = IBA,
    imageAttribution = imageAttribution,
    imageSource = imageSource,
    ingredient1 = ingredient1,
    ingredient10 = ingredient10,
    ingredient11 = ingredient11,
    ingredient12 = ingredient12,
    ingredient13 = ingredient13,
    ingredient14 = ingredient14,
    ingredient15 = ingredient15,
    ingredient2 = ingredient2,
    ingredient3 = ingredient3,
    ingredient4 = ingredient4,
    ingredient5 = ingredient5,
    ingredient6 = ingredient6,
    ingredient7 = ingredient7,
    ingredient8 = ingredient8,
    ingredient9 = ingredient9,
    instructions = instructions,
    measure1 = measure1,
    measure10 = measure10,
    measure11 = measure11,
    measure12 = measure12,
    measure13 = measure13,
    measure14 = measure14,
    measure15 = measure15,
    measure2 = measure2,
    measure3 = measure3,
    measure4 = measure4,
    measure5 = measure5,
    measure6 = measure6,
    measure7 = measure7,
    measure8 = measure8,
    measure9 = measure9,
    tags = tags,
    video = video,
    isFavorite = isFavorite,
)