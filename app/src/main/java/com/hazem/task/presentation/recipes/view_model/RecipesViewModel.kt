package com.hazem.task.presentation.recipes.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.task.domain.use_case.GetAllRecipesUseCase
import com.hazem.task.utils.Resource
import kotlinx.coroutines.launch
import androidx.compose.runtime.State

class RecipesViewModel(
    private val getAllRecipesUseCase: GetAllRecipesUseCase
): ViewModel() {
    private val _state = mutableStateOf(RecipeState())
    val state: State<RecipeState> = _state

    init {
        fetchAllCoins()
    }

    private fun fetchAllCoins() {
        viewModelScope.launch {
            _state.value = RecipeState(isLoading = true)
            getAllRecipesUseCase().let {
                when (it) {
                    is Resource.Success -> {
                        _state.value = RecipeState(isLoading = false)
                        _state.value = RecipeState(recipes = it.data)
                    }
                    is Resource.Error -> {
                        _state.value = RecipeState(isLoading = false)
                        _state.value = RecipeState(
                            errorMessage = it.message
                        )

                    }
                }
            }
        }

    }
}