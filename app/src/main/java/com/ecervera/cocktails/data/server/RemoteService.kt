package com.ecervera.cocktails.data.server

import retrofit2.http.GET
import retrofit2.http.Query

interface LatestDrinksService {

    @GET("latest")
    suspend fun listLatestDrinks(
        @Query("api_key") apiKey: String,
    ): DrinksResult
}