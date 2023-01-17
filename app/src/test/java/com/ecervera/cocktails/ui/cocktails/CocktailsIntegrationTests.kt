package com.ecervera.cocktails.ui.cocktails

import app.cash.turbine.test
import com.ecervera.cocktails.apptestshared.buildDatabaseDrinks
import com.ecervera.cocktails.apptestshared.buildRemoteDrinks
import com.ecervera.cocktails.apptestshared.buildRepositoryWith
import com.ecervera.cocktails.data.server.RemoteDrink
import com.ecervera.cocktails.testrules.CoroutinesTestRule
import com.ecervera.cocktails.ui.presentation.cocktails.CocktailsViewModel
import com.ecervera.cocktails.ui.presentation.cocktails.CocktailsViewModel.UiState
import com.ecervera.cocktails.usecases.GetLatestDrinksUseCase
import com.ecervera.cocktails.usecases.RequestLatestDrinksUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import com.ecervera.cocktails.data.database.Drink as DatabaseDrink
import org.junit.Rule
import org.junit.Test

class CocktailsIntegrationTests {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun `data is loaded from server when local source is empty`() = runTest {
        val remoteData = buildRemoteDrinks("4", "5", "6")
        val vm = buildViewModelWith(
            localData = emptyList(),
            remoteData = remoteData
        )

        vm.onUiReady()

        vm.state.test {
            assertEquals(UiState(), awaitItem())
            assertEquals(UiState(drinks = emptyList()), awaitItem())
            assertEquals(UiState(drinks = emptyList(), loading = true), awaitItem())
            assertEquals(UiState(drinks = emptyList(), loading = false), awaitItem())

            val drinks = awaitItem().drinks!!
            assertEquals("Name 4", drinks[0].name)
            assertEquals("Name 5", drinks[1].name)
            assertEquals("Name 6", drinks[2].name)

            cancel()
        }
    }

    @Test
    fun `data is loaded from local source when available`() = runTest {
        val localData = buildDatabaseDrinks("1", "2", "3")
        val remoteData = buildRemoteDrinks("4", "5", "6")
        val vm = buildViewModelWith(
            localData = localData,
            remoteData = remoteData
        )

        vm.state.test {
            assertEquals(UiState(), awaitItem())

            val drinks = awaitItem().drinks!!
            assertEquals("Name 1", drinks[0].name)
            assertEquals("Name 2", drinks[1].name)
            assertEquals("Name 3", drinks[2].name)

            cancel()
        }
    }


    private fun buildViewModelWith(
        localData: List<DatabaseDrink> = emptyList(),
        remoteData: List<RemoteDrink> = emptyList()
    ): CocktailsViewModel {
        val drinksRepository = buildRepositoryWith(localData, remoteData)
        val getLatestDrinksUseCase = GetLatestDrinksUseCase(drinksRepository)
        val requestLatestDrinksUseCase = RequestLatestDrinksUseCase(drinksRepository)
        return CocktailsViewModel(getLatestDrinksUseCase, requestLatestDrinksUseCase)
    }
}