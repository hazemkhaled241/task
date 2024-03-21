package com.hazem.task.domain.repository

import com.hazem.task.domain.model.Recipe
import com.hazem.task.utils.Resource


interface RecipesRepository {

        suspend fun getAllRecipes(): Resource<List<Recipe>,String>


}