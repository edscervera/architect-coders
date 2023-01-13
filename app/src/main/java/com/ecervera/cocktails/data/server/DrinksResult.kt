package com.ecervera.cocktails.data.server

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DrinksResult(
    @Json(name = "drinks")
    val drinks: List<RemoteDrink>
)