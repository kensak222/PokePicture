package com.example.pokepicture.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Species(
    @SerialName("url")
    val url: String
)
