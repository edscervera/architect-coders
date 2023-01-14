package com.ecervera.cocktails.di

import android.app.Application
import androidx.room.Room
import com.ecervera.cocktails.data.database.DrinkDatabase
import com.ecervera.cocktails.data.server.RemoteService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) = Room.databaseBuilder(
        app,
        DrinkDatabase::class.java,
        "drink-db"
    ).build()

    @Provides
    @Singleton
    fun provideDrinkDao(db: DrinkDatabase) = db.drinkDao()

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    @ApiUrl
    fun provideApiUrl(): String = "https://www.thecocktaildb.com/api/json/v2/9973533/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@ApiUrl apiUrl: String, client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideRemoteService(retrofit: Retrofit): RemoteService {
        return retrofit.create(RemoteService::class.java)
    }

}