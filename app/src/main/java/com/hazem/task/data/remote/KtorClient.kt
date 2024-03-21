package com.hazem.task.data.remote

import com.hazem.task.data.mapper.toMeal
import com.hazem.task.data.remote.dto.RecipeDto
import com.hazem.task.domain.model.Recipe
import com.hazem.task.utils.Resource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class KtorClient(
    private val client: HttpClient
) {
    suspend fun getAllRecipes(): Resource<List<Recipe>, String> {
       /*
         return try {
            val response = client.get {
                url(HttpRoutes.RECIPES)
            }.body<List<Recipe>>()
            Resource.Success(response)
        }
        also working fine
        */

        return try {
            val response = client.get {
                url(HttpRoutes.RECIPES)
            }.body<List<RecipeDto>>().map { it.toMeal() }
            Resource.Success(response)
        }
        catch (e: Exception) {
            Resource.Error("${e.message}")
        }
    }
}