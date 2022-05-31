package com.example.jalka.networking

import com.example.jalka.data.MatchesResponseCallback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PredictionsRepository {

    private var isRequestInProgress: Boolean = false

    fun predictionsRequest() {
        if (isRequestInProgress) {
            isRequestInProgress = true
            val retrofit = Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service: ApiService = retrofit.create(ApiService::class.java)
            service.getPredictions().enqueue(MatchesResponseCallback())
            isRequestInProgress = false
        }
    }
}