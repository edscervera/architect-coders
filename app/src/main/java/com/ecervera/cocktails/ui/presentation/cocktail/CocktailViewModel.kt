package com.ecervera.cocktails.ui.presentation.cocktail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecervera.cocktails.data.toError
import com.ecervera.cocktails.di.DrinkId
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.domain.Error
import com.ecervera.cocktails.usecases.FindDrinkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CocktailViewModel @Inject constructor(
    @DrinkId private val drinkId: String,
    findDrinkUseCase: FindDrinkUseCase,
    // savedStateHandle: SavedStateHandle
) : ViewModel() {

    // private val drinkId = savedStateHandle.get<String>("id") ?: "1"

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            findDrinkUseCase(drinkId)
                .catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                .collect { drink -> _state.update { UiState(drink = drink) } }
        }
    }

    data class UiState(val drink: Drink? = null, val error: Error? = null)
}
