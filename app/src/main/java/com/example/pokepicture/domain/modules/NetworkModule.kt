package com.example.pokepicture.domain.modules

import com.example.pokepicture.domain.api.PokemonApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    private val baseUrl = "https://pokeapi.co/api/v2"

    fun provideApiService(retrofit: Retrofit): PokemonApi {
        val okhttpClient = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            // ログを出力させる設定
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val pokemonApiService = Retrofit.Builder()
            .baseUrl("https://qiita.com")
            .client(okhttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(PokemonApi::class.java)
    }
}
