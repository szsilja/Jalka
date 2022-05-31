package com.example.jalka.networking

import android.util.Log
import com.example.jalka.data.MatchesResponseCallback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PredictionsRepository {

    // Todo:
    //  1. tee funktsioon mis tagastab ApiService instantsi
    //  2. tee klassi sisene privaatne muutuja ApiServicile ja salvesta sinna ApiService instants
    //  3. Veendu et äppi tööle pannes ikka veel päring tehakse


    // Todo: funktsiooni parameetrid
    //  1. Lisa createApiService() kutsungile sobiv parameeter, nii et äppi saaks jälle jooksutada
    //  1.1 Tee klassi ülene muutuja "retrofit" tüübiga Retrofit ning anna talle sobiv väärtus
    //  1.2 Lisa muutuja "retrofit" createApiService() parameetriks

    private var retrofit: Retrofit = createRetroFit()
    private var apiService: ApiService = createApiService(retrofit)

    // ### Siit edasi ei tohi muuta
    fun predictionsRequest() {
        apiService.getPredictions().enqueue(MatchesResponseCallback())
    }

    private fun createApiService(retrofit: Retrofit): ApiService {
        val apiService = retrofit.create(ApiService::class.java)
        return apiService
    }

    private fun createRetroFit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    // ### Siit edasi tohib jälle muuta


    // -----

/*
    fun predictionsRequest() {
        apiService.getPredictions().enqueue(MatchesResponseCallback())
    }

    private var apiService: ApiService = createApiService()

    private fun createApiService(): ApiService {
        val retrofit = createRetroFit()

        val apiService = retrofit.create(ApiService::class.java)
        return apiService
    }

    private fun createRetroFit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }*/


    // Klassi sisene privaatne muutuja, mis salvestab stringi
    private var returnedString: String = stringReturningFunction()

    // Tagastav funktsioon
    private fun stringReturningFunction(): String {
        var string = "mina olen String"
        string = string.uppercase()
        return string
    }

    fun testStringReturningFunction() {
        Log.e("********", returnedString)
    }
}