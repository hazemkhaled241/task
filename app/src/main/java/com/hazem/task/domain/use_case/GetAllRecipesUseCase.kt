package com.hazem.task.domain.use_case

import com.hazem.task.domain.model.Recipe
import com.hazem.task.domain.repository.RecipesRepository
import com.hazem.task.utils.Resource

class GetAllRecipesUseCase(
    private val recipesRepository: RecipesRepository
) {

    suspend operator fun invoke(): Resource<List<Recipe>, String> {

        return recipesRepository.getAllRecipes()
    }
}