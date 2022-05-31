package com.example.jalka.networking

import com.example.jalka.data.Urls
import com.example.jalka.data.models.MatchesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(Urls.predictions)
    fun getPredictions(): Call<MatchesResponse>
}