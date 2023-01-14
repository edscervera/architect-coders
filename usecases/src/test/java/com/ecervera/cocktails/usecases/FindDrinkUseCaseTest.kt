package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.testshared.sampleDrink
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock


class FindDrinkUseCaseTest {

    @Test
    fun `Find drink use case`(): Unit = runBlocking {
        val drink = flowOf(sampleDrink.copy(idDrink = "1"))
        val findDrinkUseCase = FindDrinkUseCase(mock() {
            on { findById("1") } doReturn (drink)
        })

        val result = findDrinkUseCase("1")

        assertEquals(drink, result)
    }
}
