package com.example.superheroes.api

import com.example.superheroes.data.SuperheroImage

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SuperheroAPIService {

    @GET("/superhero-api/api/all.json")
    fun retrieveSuperheroImages():Call<List<SuperheroImage>>

}