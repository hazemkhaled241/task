package com.hazem.task.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    @SerialName("id") var id: String? = null,
    @SerialName("fats") var fats: String? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("time") var time: String? = null,
    @SerialName("image") var image: String? = null,
    @SerialName("weeks") var weeks: ArrayList<String> = arrayListOf(),
    @SerialName("carbos") var carbos: String? = null,
    @SerialName("fibers") var fibers: String? = null,
    @SerialName("rating") var rating: Double? = null,
    @SerialName("country") var country: String? = null,
    @SerialName("ratings") var ratings: Double? = null,
    @SerialName("calories") var calories: String? = null,
    @SerialName("headline") var headline: String? = null,
    @SerialName("keywords") var keywords: ArrayList<String> = arrayListOf(),
    @SerialName("products") var products: ArrayList<String> = arrayListOf(),
    @SerialName("proteins") var proteins: String? = null,
    @SerialName("favorites") var favorites: Int? = null,
    @SerialName("difficulty") var difficulty: Int? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("highlighted") var highlighted: Boolean? = null,
    @SerialName("ingredients") var ingredients: ArrayList<String> = arrayListOf(),
    @SerialName("incompatibilities") var incompatibilities: String? = null,
    @SerialName("deliverable_ingredients") var deliverableIngredients: ArrayList<String> = arrayListOf(),
    @SerialName("undeliverable_ingredients") var undeliverableIngredients: ArrayList<String> = arrayListOf()
)
