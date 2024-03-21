package com.hazem.task.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: String ,
    val fats: String? ,
    val name: String? ,
    val image: String? ,
    val carbos: String? ,
    val fibers: String? ,
    val rating: Double? ,
    val country: String? ,
    val ratings: Double? ,
    val calories: String? ,
    val proteins: String? ,
    val description: String? ,
    val ingredients: ArrayList<String>
    )