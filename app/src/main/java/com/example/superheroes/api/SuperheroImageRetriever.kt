package com.example.superheroes.api

import com.example.superheroes.data.SuperheroImage
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.R
import android.util.Log



class SuperheroImageRetriever {
    private var service: SuperheroAPIService

    companion object {

        const val BASE_URL = "https://akabab.github.io"

    }

    init {
        val retrofit = Retrofit.Builder()

            .baseUrl(BASE_URL)
            .addConverterFactory((GsonConverterFactory.create()))
            .build()

        service = retrofit.create(SuperheroAPIService::class.java)
    }

    fun getSuperheroImages(callback: Callback<List<SuperheroImage>>) {
        Log.d("Superherocalled2","inside service call")
        val call = service.retrieveSuperheroImages()
        call.enqueue(callback)


    }

}