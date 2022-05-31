package com.example.jalka.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jalka.MainActivity
import com.example.jalka.ui.theme.Typography

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