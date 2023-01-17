package com.ecervera.cocktails.data

import arrow.core.right
import com.ecervera.cocktails.data.datasource.DrinkLocalDataSource
import com.ecervera.cocktails.data.datasource.DrinkRemoteDataSource
import com.ecervera.cocktails.testshared.sampleDrink
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.argThat
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class DrinksRepositoryTest {

    @Mock
    lateinit var localDataSource: DrinkLocalDataSource

    @Mock
    lateinit var remoteDataSource: DrinkRemoteDataSource

    private lateinit var drinksRepository: DrinksRepository

    private val localDrinks = flowOf(listOf(sampleDrink.copy("1")))

    @Before
    fun setUp() {
        whenever(localDataSource.drinks).thenReturn(localDrinks)
        drinksRepository = DrinksRepository(localDataSource, remoteDataSource)
    }

    @Test
    fun `Latest drinks are taken from local data source if available`(): Unit = runBlocking {

        val result = drinksRepository.latestDrinks

        assertEquals(localDrinks, result)
    }

    @Test
    fun `Latest drinks are saved to local data source when it's empty`(): Unit = runBlocking {
        val remoteDrinks = listOf(sampleDrink.copy("2"))
        whenever(localDataSource.isEmpty()).thenReturn(true)
        whenever(remoteDataSource.findLatestDrinks()).thenReturn(remoteDrinks.right())

        drinksRepository.requestLatestDrinks()

        verify(localDataSource).save(remoteDrinks)
    }

    @Test
    fun `Finding a drink by id is done in local data source`(): Unit = runBlocking {
        val drink = flowOf(sampleDrink.copy("3"))
        whenever(localDataSource.findById("3")).thenReturn(drink)

        val result = drinksRepository.findById("3")

        assertEquals(drink, result)
    }

    @Test
    fun `Switching favorite updates local data source`(): Unit = runBlocking {
        val drink = sampleDrink.copy( "4")

        drinksRepository.switchFavorite(drink)

        verify(localDataSource).save(argThat { get(0).idDrink == "4" })
    }

    @Test
    fun `Switching favorite marks as favorite an unfavorite drink`(): Unit = runBlocking {
        val drink = sampleDrink.copy(isFavorite = false)

        drinksRepository.switchFavorite(drink)

        verify(localDataSource).save(argThat { get(0).isFavorite })
    }

    @Test
    fun `Switching favorite marks as unfavorite a favorite drink`(): Unit = runBlocking {
        val drink = sampleDrink.copy(isFavorite = true)

        drinksRepository.switchFavorite(drink)

        verify(localDataSource).save(argThat { !get(0).isFavorite })
    }
}