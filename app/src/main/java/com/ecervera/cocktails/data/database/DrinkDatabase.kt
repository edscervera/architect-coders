package com.ecervera.cocktails.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Drink::class], version = 1, exportSchema = false)
abstract class DrinkDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao
}