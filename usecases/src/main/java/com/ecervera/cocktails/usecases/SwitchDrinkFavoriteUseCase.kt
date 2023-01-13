package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.data.DrinksRepository
import com.ecervera.cocktails.domain.Drink
import javax.inject.Inject

class SwitchDrinkFavoriteUseCase @Inject constructor(private val repository: DrinksRepository) {

    suspend operator fun invoke(drink: Drink) = repository.switchFavorite(drink)
}