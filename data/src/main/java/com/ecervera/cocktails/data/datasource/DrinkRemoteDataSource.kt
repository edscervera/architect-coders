package com.ecervera.cocktails.data.datasource

import arrow.core.Either
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.domain.Error

interface DrinkRemoteDataSource {
    suspend fun findLatestDrinks(): Either<Error, List<Drink>>
}