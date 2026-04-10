package com.example.cursoudemy.components.layout

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue: Float by remember { mutableFloatStateOf(0f) }
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(
            value = myValue,
            onValueChange = { myValue = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                activeTickColor = Color.Blue,
                disabledActiveTickColor = Color.DarkGray,
                inactiveTickColor = Color.Green,
                inactiveTrackColor = Color.Blue
            )
        )
        Text(myValue.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example: String by remember { mutableStateOf(":(") }
    val state: SliderState = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = { example = ":)" }
        )
    }

    val colors = SliderDefaults.colors(
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        activeTickColor = Color.Blue,
        disabledActiveTickColor = Color.DarkGray,
        inactiveTickColor = Color.Green,
        inactiveTrackColor = Color.Blue
    )

    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        Slider(
            state, colors = colors,
            thumb = { state: SliderState -> Text(state.value.toString()) }
        )
        Text(example)
    }
}

@SuppressLint("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    var state = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            steps = 3,
            onValueChangeFinished = {}

        )
    }

    val colors = SliderDefaults.colors(
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        activeTickColor = Color.Blue,
        disabledActiveTickColor = Color.DarkGray,
        inactiveTickColor = Color.Green,
        inactiveTrackColor = Color.Blue
    )

    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        RangeSlider(
            state = state,
            colors = colors,
            startThumb = {
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(String.format("%.1f", it.activeRangeStart))
                }
            },
            endThumb = {
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(String.format("%.1f", it.activeRangeEnd))
                }
            }
        )
    }
}