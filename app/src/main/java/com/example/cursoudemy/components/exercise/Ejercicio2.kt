package com.example.cursoudemy.components.exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun Ejercicio2(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow,boxBlue,boxCyan,boxLightGray,boxBlack) = createRefs()

        Box(Modifier.size(175.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxMagenta.top)
            end.linkTo(boxMagenta.end)
        })
        Box(Modifier.size(175.dp).background(Color.LightGray).constrainAs(boxLightGray){
            bottom.linkTo(boxGreen.top)
            start.linkTo(boxGreen.start)
        })

        Box(Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack){
            start.linkTo(boxCyan.end)
            top.linkTo(boxCyan.top)
            bottom.linkTo(boxCyan.bottom)
        })


        Box(Modifier.size(75.dp).background(Color.Companion.Green).constrainAs(boxGreen){
            bottom.linkTo(boxYellow.top)
            start.linkTo(boxYellow.end)
        })

        Box(Modifier.size(75.dp).background(Color.Companion.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxYellow.top)
            end.linkTo(boxYellow.start)
        })

        Box(Modifier.size(75.dp).background(Color.Companion.Yellow).constrainAs(boxYellow){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })

        Box(Modifier.size(175.dp).background(Color.Companion.Blue).constrainAs(boxBlue){
            top.linkTo(boxYellow.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)

        })
        Box(Modifier.size(75.dp).background(Color.Companion.Gray).constrainAs(boxGray){
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        })

        Box(Modifier.size(75.dp).background(Color.Companion.Red).constrainAs(boxRed){
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })

    }
}