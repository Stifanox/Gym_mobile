package com.example.gym.data.remote

import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfiguration {
    const val BASE_URL = "http://192.168.1.58:3000"
    val CONVERTER_FACTORY:GsonConverterFactory = GsonConverterFactory.create()
}