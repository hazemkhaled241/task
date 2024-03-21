package com.hazem.task.data.mapper

import com.hazem.task.data.remote.dto.RecipeDto
import com.hazem.task.domain.model.Recipe

fun RecipeDto.toMeal(): Recipe {
    return Recipe(
        id = id!!,
        fats = fats,
        name = name,
        image = image,
        carbos = carbos,
        fibers = fibers,
        rating = rating,
        country = country,
        ratings = ratings,
        calories = calories,
        proteins = proteins,
        description = description,
        ingredients = ingredients
    )
}