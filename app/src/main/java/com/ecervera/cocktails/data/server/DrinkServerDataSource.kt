package com.ecervera.cocktails.data.server

import arrow.core.Either
import com.ecervera.cocktails.data.datasource.DrinkRemoteDataSource
import com.ecervera.cocktails.domain.Error
import com.ecervera.cocktails.data.tryCall
import com.ecervera.cocktails.domain.Drink
import javax.inject.Inject

class DrinkServerDataSource @Inject constructor(
    private val remoteService: RemoteService
) : DrinkRemoteDataSource {

    override suspend fun findLatestDrinks(): Either<Error, List<Drink>> = tryCall {

        val drinks = remoteService.listLatestDrinks().body()?.drinks

        if(drinks != null && drinks.isNotEmpty()) drinks.toDomainModel()
        else emptyList()
    }
}

private fun List<RemoteDrink>.toDomainModel(): List<Drink> = map { it.toDomainModel() }

private fun RemoteDrink.toDomainModel(): Drink = Drink(
    idDrink = idDrink,
    alcoholic,
    category,
    creativeCommonsConfirmed,
    name,
    drinkThumb,
    glass,
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
    isFavorite = false,
)