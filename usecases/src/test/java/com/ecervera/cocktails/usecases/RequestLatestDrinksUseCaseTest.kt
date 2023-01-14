package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.data.DrinksRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class RequestLatestDrinksUseCaseTest {

    @Test
    fun `Request latest drinks use case`(): Unit = runBlocking {
        val drinksRepository = mock<DrinksRepository>()
        val requestLatestDrinksUseCase = RequestLatestDrinksUseCase(drinksRepository)

        requestLatestDrinksUseCase()

        verify(drinksRepository).requestLatestDrinks()
    }
}