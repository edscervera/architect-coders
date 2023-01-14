package com.ecervera.cocktails.ui.presentation.cocktails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecervera.cocktails.data.toError
import com.ecervera.cocktails.domain.Drink
import com.ecervera.cocktails.domain.Error
import com.ecervera.cocktails.usecases.GetLatestDrinksUseCase
import com.ecervera.cocktails.usecases.RequestLatestDrinksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CocktailsViewModel @Inject constructor(
    getLatestDrinksUseCase: GetLatestDrinksUseCase,
    private val requestLatestDrinksUseCase: RequestLatestDrinksUseCase
) : ViewModel() {


    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getLatestDrinksUseCase()
                .catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                .collect { drinks -> _state.update { UiState(drinks = drinks) } }
        }
    }

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            val error = requestLatestDrinksUseCase()
            _state.value = _state.value.copy(loading = false, error = error)
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val drinks: List<Drink>? = null,
        val error: Error? = null
    )
}