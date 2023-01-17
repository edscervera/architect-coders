package com.ecervera.cocktails.apptestshared

import com.ecervera.cocktails.data.DrinksRepository
import com.ecervera.cocktails.data.database.DrinkRoomDataSource
import com.ecervera.cocktails.data.server.DrinkServerDataSource
import com.ecervera.cocktails.data.server.RemoteDrink
import com.ecervera.cocktails.data.database.Drink as DatabaseDrink

fun buildRepositoryWith(
    localData: List<DatabaseDrink>,
    remoteData: List<RemoteDrink>
): DrinksRepository {
    val localDataSource = DrinkRoomDataSource(FakeDrinkDao(localData))
    val remoteDataSource = DrinkServerDataSource(FakeRemoteService(remoteData))
    return DrinksRepository(localDataSource, remoteDataSource)
}

fun buildDatabaseDrinks(vararg id: String) = id.map {
    DatabaseDrink(
        idDrink = it,
        name = "Name $it",
        alcoholic= "Alcoholic",
        category = "Cocktail",
        creativeCommonsConfirmed ="No",
        drinkThumb = "http://localhost/images/drink/test_thumb",
        glass = "ighball glass",
        imageSource = "http://localhost/images/drink/test_image_source",
        ingredient1 = "Gin",
        ingredient2 = "Tonic Water",
        instructions = "Description test",
        measure1 = "1 ml",
        tags = "best",
        video = "http://localhost/images/drink/test_video",
        isFavorite = false,
    )
}

fun buildRemoteDrinks(vararg id: String) = id.map {
    RemoteDrink(
        idDrink = it,
        name = "Name $it",
        dateModified = null,
        alcoholic= "Alcoholic",
        category = "Cocktail",
        creativeCommonsConfirmed ="No",
        drinkAlternate = "",
        drinkThumb = "http://localhost/images/drink/test_thumb",
        glass = "ighball glass",
        IBA = null,
        imageAttribution = "",
        imageSource = "http://localhost/images/drink/test_image_source",
        ingredient1 = "Gin",
        ingredient2 = "Tonic Water",
        instructions = "Description test",
        measure1 = "1 ml",
        tags = "best",
        video = "http://localhost/images/drink/test_video",
    )
}