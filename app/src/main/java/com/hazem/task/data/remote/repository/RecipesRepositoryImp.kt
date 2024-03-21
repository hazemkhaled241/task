package com.hazem.task.data.remote.repository

import com.hazem.task.domain.repository.RecipesRepository
import com.hazem.task.data.remote.KtorClient
import com.hazem.task.domain.model.Recipe
import com.hazem.task.utils.Resource

class RecipesRepositoryImp(
    private val client: KtorClient
) : RecipesRepository {
    override suspend fun getAllRecipes(): Resource<List<Recipe>, String> {
        return client.getAllRecipes()
    }


}