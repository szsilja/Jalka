package com.example.jalka.data

import android.util.Log
import com.example.jalka.data.models.MatchesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchesResponseCallback : Callback<MatchesResponse> {
    override fun onResponse(call: Call<MatchesResponse>, response: Response<MatchesResponse>) {
        Log.e("SILJA", "Response: ${response.body()}")
    }

    override fun onFailure(call: Call<MatchesResponse>, t: Throwable) {
        Log.e("SILJA", "Error")
    }
}