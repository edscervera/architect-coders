package com.ecervera.cocktails.ui.cocktail

import app.cash.turbine.test
import com.ecervera.cocktails.apptestshared.buildDatabaseDrinks
import com.ecervera.cocktails.apptestshared.buildRepositoryWith
import com.ecervera.cocktails.data.server.RemoteDrink
import com.ecervera.cocktails.testrules.CoroutinesTestRule
import com.ecervera.cocktails.ui.presentation.cocktail.CocktailViewModel
import com.ecervera.cocktails.ui.presentation.cocktail.CocktailViewModel.UiState
import com.ecervera.cocktails.usecases.FindDrinkUseCase
import com.ecervera.cocktails.data.database.Drink as DatabaseDrink
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class CocktailIntegrationTests {
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun `UI is updated with the drink on start`() = runTest {
        val vm = buildViewModelWith(
            idDrink = "2",
            localData = buildDatabaseDrinks("1", "2", "3")
        )

        vm.state.test {
            Assert.assertEquals(UiState(), awaitItem())
            Assert.assertEquals("2", awaitItem().drink!!.idDrink)
            cancel()
        }
    }

    private fun buildViewModelWith(
        idDrink: String,
        localData: List<DatabaseDrink> = emptyList(),
        remoteData: List<RemoteDrink> = emptyList()
    ): CocktailViewModel {
        val drinksRepository = buildRepositoryWith(localData, remoteData)
        val findDrinkUseCase = FindDrinkUseCase(drinksRepository)
        return CocktailViewModel(idDrink, findDrinkUseCase)
    }
}