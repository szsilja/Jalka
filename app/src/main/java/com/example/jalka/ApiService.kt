package com.example.jalka

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(Urls.predictions)
    fun getPredictions(): Call<MatchesResponse>
}