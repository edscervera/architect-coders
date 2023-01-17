package com.ecervera.cocktails.ui.cocktail

import app.cash.turbine.test
import com.ecervera.cocktails.testrules.CoroutinesTestRule
import com.ecervera.cocktails.testshared.sampleDrink
import com.ecervera.cocktails.ui.presentation.cocktail.CocktailViewModel
import com.ecervera.cocktails.ui.presentation.cocktail.CocktailViewModel.UiState
import com.ecervera.cocktails.usecases.FindDrinkUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class CocktailViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var findDrinkUseCase: FindDrinkUseCase

    private lateinit var vm: CocktailViewModel

    private val drink = sampleDrink.copy(idDrink = "2")

    @Before
    fun setup() {
        whenever(findDrinkUseCase("2")).thenReturn(flowOf(drink))
        vm = CocktailViewModel(drinkId = "2", findDrinkUseCase)
    }

    @Test
    fun `UI is updated with the drink on start`() = runTest {
        vm.state.test {
            assertEquals(UiState(), awaitItem())
            assertEquals(UiState(drink = drink), awaitItem())
            cancel()
        }
    }
}