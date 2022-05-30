package com.example.jalka

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jalka.ui.theme.JalkaTheme
import com.example.jalka.ui.theme.Typography
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    val callback = object : Callback<MatchesResponse>{
        override fun onResponse(call: Call<MatchesResponse>, response: Response<MatchesResponse>) {
            Log.e("SILJA", "Response: ${response.body()}")
        }

        override fun onFailure(call: Call<MatchesResponse>, t: Throwable) {
            Log.e("SILJA", "Error")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: ApiService = retrofit.create(ApiService::class.java)
        service.getPredictions().enqueue(callback)

        val predictions = listOf(
            Prediction(team1 = "Wolfsburg", result1 = "1", team2 = "Gent", result2 = "2"),
            Prediction(team1 = "Real Madrid", result1 = "2", team2 = "Roma", result2 = "0"),
            Prediction(team1 = "Zenit", result1 = "_", team2 = "Benfica", result2 = "_"),
            Prediction(team1 = "Wolfsburg", result1 = "_", team2 = "Paris", result2 = "_"),
            Prediction(team1 = "Chelsea", result1 = "_", team2 = "PSV", result2 = "_"),
            Prediction(team1 = "Atletico", result1 = "_", team2 = "Dynamo Kyiv", result2 = "_"),
            Prediction(team1 = "Man. City", result1 = "_", team2 = "Arsenal", result2 = "_"),
            Prediction(team1 = "Bayern", result1 = "_", team2 = "Juventus", result2 = "_"),
            Prediction(team1 = "Wolfsburg", result1 = "1", team2 = "Gent", result2 = "2"),
            Prediction(team1 = "Real Madrid", result1 = "2", team2 = "Roma", result2 = "0"),
            Prediction(team1 = "Zenit", result1 = "_", team2 = "Benfica", result2 = "_"),
            Prediction(team1 = "Wolfsburg", result1 = "_", team2 = "Paris", result2 = "_"),
            Prediction(team1 = "Chelsea", result1 = "_", team2 = "PSV", result2 = "_"),
            Prediction(team1 = "Atletico", result1 = "_", team2 = "Dynamo Kyiv", result2 = "_"),
            Prediction(team1 = "Man. City", result1 = "_", team2 = "Arsenal", result2 = "_"),
            Prediction(team1 = "Bayern", result1 = "_", team2 = "Juventus", result2 = "_"),
            Prediction(team1 = "Wolfsburg", result1 = "1", team2 = "Gent", result2 = "2"),
            Prediction(team1 = "Real Madrid", result1 = "2", team2 = "Roma", result2 = "0"),
            Prediction(team1 = "Zenit", result1 = "_", team2 = "Benfica", result2 = "_"),
            Prediction(team1 = "Wolfsburg", result1 = "_", team2 = "Paris", result2 = "_"),
            Prediction(team1 = "Chelsea", result1 = "_", team2 = "PSV", result2 = "_"),
            Prediction(team1 = "Atletico", result1 = "_", team2 = "Dynamo Kyiv", result2 = "_"),
            Prediction(team1 = "Man. City", result1 = "_", team2 = "Arsenal", result2 = "_"),
            Prediction(team1 = "Bayern", result1 = "_", team2 = "Juventus", result2 = "_"),

            )

        setContent {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { /* Do something! */ }) {
                        Text("Get results >>")
                    }


                }
                Divider()
                LazyColumn {
                    items(items = predictions,
                        itemContent = { prediction: Prediction ->
                            PredictionRow(prediction = prediction)
                            Divider()
                        }
                    )
                }
            }

        }
    }

    data class Prediction(
        val team1: String,
        val team2: String,
        val result1: String,
        val result2: String
    )
}

@Composable
fun PredictionRow(prediction: MainActivity.Prediction) {
    // Text(text = "${prediction.team1} ${prediction.result1} - ${prediction.result2} ${prediction.team2}")
    Row {
        //(modifier = Modifier.padding(vertical = 8.dp)) {

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(0.45f)
        ) {
            Text(text = prediction.team1, style = Typography.h2)
            Text(
                text = prediction.result1,
                style = Typography.h2,
                // modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(0.1f)
        )
        {
            Text(text = "-")
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.45f)
        ) {
            Text(
                text = prediction.result2,
                style = Typography.h2,
                //  modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = prediction.team2, style = Typography.h2, maxLines = 1)
        }
    }
}