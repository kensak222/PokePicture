package com.example.pokepicture.domain.api

import com.example.pokepicture.models.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("/pokemon/{id}")
    suspend fun getPokemon (
        @Path("id") pokeId: String
    ): Response<Pokemon>

    // TODO: flavor_textはややこしいので、後で考える
}
