package com.example.jalka.ui.screens.predictions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jalka.MainActivity
import com.example.jalka.ui.components.PredictionRow

@Composable
    fun PredictionScreen(predictions: List<MainActivity.Prediction>) {
        Column {
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
                    itemContent = { prediction: MainActivity.Prediction ->
                        PredictionRow(prediction = prediction)
                        Divider()
                    }
                )
            }
        }
    }