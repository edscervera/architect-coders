package com.ecervera.cocktails.data.server

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("latest.php")
    suspend fun listLatestDrinks(): Response<DrinksResult>
}