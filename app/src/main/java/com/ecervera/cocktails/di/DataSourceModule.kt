package com.ecervera.cocktails.di

import com.ecervera.cocktails.data.database.DrinkRoomDataSource
import com.ecervera.cocktails.data.datasource.DrinkLocalDataSource
import com.ecervera.cocktails.data.datasource.DrinkRemoteDataSource
import com.ecervera.cocktails.data.server.DrinkServerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
@Suppress("UnnecessaryAbstractClass")
abstract class RepositoryModule {

    @Binds
    abstract fun bindLocalDataSource(localDataSource: DrinkRoomDataSource): DrinkLocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: DrinkServerDataSource): DrinkRemoteDataSource
}