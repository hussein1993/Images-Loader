package com.example.imageslogger.services

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService  private constructor() {


    private val retrofit: Retrofit
    val newData: Call<JsonElement>
        get() {
            val myApi: ApiCalls = retrofit.create(ApiCalls::class.java)
            return myApi.getNewData("70")
        }

    companion object {
        private const val BASE_URL = "https://api.pexels.com/v1/"
        const val ApiKey = "SPywZjIZxRiIt2C4WM0McU3t35jlahi8aa7ZLc5wAn3vEDVF086hwnNI"
        @get:Synchronized
        var instance: APIService? = null
            get() {
                if (field == null) {
                    field = APIService()
                }
                return field
            }
            private set
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}