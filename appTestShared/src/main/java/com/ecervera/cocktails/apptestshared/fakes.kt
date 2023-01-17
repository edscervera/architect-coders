package com.ecervera.cocktails.apptestshared

import com.ecervera.cocktails.data.database.DrinkDao
import com.ecervera.cocktails.data.server.DrinksResult
import com.ecervera.cocktails.data.server.RemoteDrink
import com.ecervera.cocktails.data.server.RemoteService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import com.ecervera.cocktails.data.database.Drink as DatabaseDrink

class FakeDrinkDao(drinks: List<DatabaseDrink> = emptyList()) : DrinkDao {

    private val inMemoryDrinks = MutableStateFlow(drinks)
    private lateinit var findDrinkFlow: MutableStateFlow<DatabaseDrink>

    override fun getAll(): Flow<List<DatabaseDrink>> = inMemoryDrinks

    override fun findById(id: String): Flow<DatabaseDrink> = MutableStateFlow(inMemoryDrinks.value.first { it.idDrink == id })

    override suspend fun drinkCount(): Int = inMemoryDrinks.value.size

    override suspend fun insertDrinks(drinks: List<DatabaseDrink>) {
        inMemoryDrinks.value = drinks

        if (::findDrinkFlow.isInitialized) {
            drinks.firstOrNull() { it.idDrink == findDrinkFlow.value.idDrink }
                ?.let { findDrinkFlow.value = it }
        }
    }
}

class FakeRemoteService(private val drinks: List<RemoteDrink> = emptyList()) : RemoteService {

    override suspend fun listLatestDrinks(): DrinksResult = DrinksResult(drinks)

}