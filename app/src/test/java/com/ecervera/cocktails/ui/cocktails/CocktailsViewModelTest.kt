package com.ecervera.cocktails.ui.cocktails

import app.cash.turbine.test
import com.ecervera.cocktails.testrules.CoroutinesTestRule
import com.ecervera.cocktails.testshared.sampleDrink
import com.ecervera.cocktails.ui.presentation.cocktails.CocktailsViewModel
import com.ecervera.cocktails.ui.presentation.cocktails.CocktailsViewModel.UiState
import com.ecervera.cocktails.usecases.GetLatestDrinksUseCase
import com.ecervera.cocktails.usecases.RequestLatestDrinksUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class CocktailsViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var getLatestDrinksUseCase: GetLatestDrinksUseCase

    @Mock
    lateinit var requestLatestDrinksUseCase: RequestLatestDrinksUseCase

    private lateinit var vm: CocktailsViewModel

    private val drinks = listOf(sampleDrink.copy("1"))

    @Before
    fun setup() {
        whenever(getLatestDrinksUseCase()).thenReturn(flowOf(drinks))
        vm = CocktailsViewModel(getLatestDrinksUseCase, requestLatestDrinksUseCase)
    }

    @Test
    fun `State is updated with current cached content immediately`() = runTest {
        vm.state.test {
            assertEquals(UiState(), awaitItem())
            assertEquals(UiState(drinks = drinks), awaitItem())
            cancel()
        }
    }

    @Test
    fun `Progress is shown when screen starts and hidden when it finishes requesting drinks`() = runTest {
        vm.onUiReady()

        vm.state.test {
            assertEquals(UiState(), awaitItem())
            assertEquals(UiState(drinks = drinks), awaitItem())
            assertEquals(UiState(drinks = drinks, loading = true), awaitItem())
            assertEquals(UiState(drinks = drinks, loading = false), awaitItem())
            cancel()
        }
    }

    @Test
    fun `Latest drinks are requested when UI screen starts`() = runTest {
        vm.onUiReady()
        runCurrent()

        verify(requestLatestDrinksUseCase).invoke()
    }
}