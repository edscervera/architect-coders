package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.data.DrinksRepository
import com.ecervera.cocktails.domain.Drink
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindDrinkUseCase @Inject constructor(private val repository: DrinksRepository) {

    operator fun invoke(id: String): Flow<Drink> = repository.findById(id)
}