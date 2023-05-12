package com.example.imageslogger.services

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiCalls {
    @Headers("Authorization: " + APIService.ApiKey)
    @GET("curated")
    fun getNewData(@Query("per_page") per_page:String): Call<JsonElement>
}