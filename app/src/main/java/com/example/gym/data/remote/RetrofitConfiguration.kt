package com.example.gym.data.remote

import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfiguration {
    const val BASE_URL = "localhost:3000"
    val CONVERTER_FACTORY:GsonConverterFactory = GsonConverterFactory.create()
}