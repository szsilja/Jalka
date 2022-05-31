package com.example.jalka.networking

import android.util.Log
import com.example.jalka.data.MatchesResponseCallback
import com.example.jalka.data.Urls
import com.example.jalka.data.models.MatchesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET(Urls.predictions)
    fun getPredictions(): Call<MatchesResponse>
}