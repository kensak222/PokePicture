package com.example.pokepicture.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokeFundamentals(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("height")
    val height: Int,
    @Contextual
    val species: Species,
    @Contextual
    val sprites: Sprites
)
