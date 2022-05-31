package com.example.jalka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jalka.data.DefaultPredictions
import com.example.jalka.networking.PredictionsRepository
import com.example.jalka.ui.screens.predictions.PredictionScreen

class MainActivity : ComponentActivity() {

    // privaatne | muutumatu muutuja | muutuja nimi          | muutuja väärtus
    private        val                 predictionsRepository = PredictionsRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        predictionsRepository.predictionsRequest()
        predictionsRepository.testStringReturningFunction()

        setContent {
            PredictionScreen(DefaultPredictions.predictions)
        }
    }

    data class Prediction(
        val team1: String,
        val team2: String,
        val result1: String,
        val result2: String
    )
}

