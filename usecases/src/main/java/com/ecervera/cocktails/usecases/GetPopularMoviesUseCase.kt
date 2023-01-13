package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.data.DrinksRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: DrinksRepository) {

    operator fun invoke() = repository.latestDrinks
}