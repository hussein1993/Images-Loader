package com.example.imageslogger.services

import android.util.Log
import com.example.imageslogger.model.Photo
import com.google.gson.Gson
import com.google.gson.JsonElement
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Response


class Repository {

    fun FetchImages(_images: MutableStateFlow<List<Photo>>){
        APIService.instance?.newData?.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if(response.isSuccessful){
                    val data =response.body()
                    data?.let {
                        val gson = Gson()
                        _images.value = gson.fromJson(data,com.example.imageslogger.model.Response::class.java).photos
                        Log.i("HH","1-"+_images.value.get(1).url.toString())
                    }
                    Log.i("HH","2-"+_images.value.size)
                }

                Log.i("HH","SUCCESS")
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.i("HH","FAIL()")
            }
        } )
    }
}