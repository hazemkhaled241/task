package com.hazem.task.presentation.recipes.view_model

import com.hazem.task.domain.model.Recipe

data class RecipeState(
    val recipes: List<Recipe> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = false
)
