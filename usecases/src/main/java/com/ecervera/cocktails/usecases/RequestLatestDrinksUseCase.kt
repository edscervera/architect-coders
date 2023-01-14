package com.ecervera.cocktails.usecases

import com.ecervera.cocktails.data.DrinksRepository
import com.ecervera.cocktails.domain.Error
import javax.inject.Inject

class RequestLatestDrinksUseCase @Inject constructor(private val repository: DrinksRepository) {

    suspend operator fun invoke(): Error? {
        return repository.requestLatestDrinks()
    }
}