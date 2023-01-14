package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.data.DrinksRepository
import com.ecervera.cocktails.testshared.sampleDrink
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SwitchDrinkFavoriteUseCaseTest {

    @Test
    fun `Switch drink favorite use case`(): Unit = runBlocking {
        val drink = sampleDrink.copy(idDrink = "1")
        val drinksRepository = mock<DrinksRepository>()
        val switchDrinkFavoriteUseCase = SwitchDrinkFavoriteUseCase(drinksRepository)

        switchDrinkFavoriteUseCase(drink)

        verify(drinksRepository).switchFavorite(drink)
    }
}