package com.ecervera.cocktails.ui.presentation.cocktail

import androidx.lifecycle.SavedStateHandle
import com.ecervera.cocktails.di.DrinkId
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class CocktailViewModelModule {

    @Provides
    @ViewModelScoped
    @DrinkId
    fun provideDrinkId(savedStateHandle: SavedStateHandle) = savedStateHandle.get<String>("id")!!
}