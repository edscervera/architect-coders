package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.testshared.sampleDrink
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class GetLatestDrinksUseCaseTest {

    @Test
    fun `Invoke calls get latest drinks use case`(): Unit = runBlocking {
        val movies = flowOf(listOf(sampleDrink.copy(idDrink = "1")))
        val getLatestDrinksUseCase = GetLatestDrinksUseCase(mock {
            on { latestDrinks } doReturn movies
        })

        val result = getLatestDrinksUseCase()

        assertEquals(movies, result)
    }
}