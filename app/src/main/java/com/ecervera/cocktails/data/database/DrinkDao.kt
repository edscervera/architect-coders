package com.ecervera.cocktails.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DrinkDao {

    @Query("SELECT * FROM Drink")
    fun getAll(): Flow<List<Drink>>

    @Query("SELECT * FROM Drink WHERE idDrink = :id")
    fun findById(id: String): Flow<Drink>

    @Query("SELECT COUNT(idDrink) FROM Drink")
    suspend fun drinkCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinks(movies: List<Drink>)
}