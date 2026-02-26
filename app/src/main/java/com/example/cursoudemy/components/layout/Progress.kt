package com.example.cursoudemy.components.layout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.cursoudemy.R


@Composable
fun Progress(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            Modifier.size(70.dp), color = Color.Red,
            strokeWidth = 10.dp,
            trackColor = Color.Green,
            strokeCap = StrokeCap.Round
        )
        Spacer(Modifier.height(70.dp))
        LinearProgressIndicator(
            color = Color.Red,
            trackColor = Color.Magenta,
            strokeCap = StrokeCap.Round
        )
    }
}

@Composable
fun ProgressAdvance(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0.5f) }
    var isLoading by remember { mutableStateOf(false) }

    val animatedProgress by animateFloatAsState(targetValue = progress)


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { progress },
                Modifier.size(140.dp), color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Green,
                strokeCap = StrokeCap.Round
            )
        }
        Spacer(Modifier.height(70.dp))
        LinearProgressIndicator(
            progress = { progress },
            color = Color.Red,
            trackColor = Color.Magenta,
            strokeCap = StrokeCap.Round
        )
        Row(Modifier.padding(24.dp)) {
            Button(onClick = {
                progress += 0.1f
            }) { Text("<") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = {
                progress -= 0.1f
            }) { Text(">") }
        }
        Button(onClick = {
            isLoading = !isLoading
        }) { Text("Show/Hide") }
    }
}

@Composable
fun ProgressAnimation(modifier: Modifier = Modifier) {

    val composition: LottieComposition?
    by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_hand))

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(composition= composition, iterations = LottieConstants.IterateForever)
    }
}