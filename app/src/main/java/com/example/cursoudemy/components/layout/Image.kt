package com.example.cursoudemy.components.layout

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.cursoudemy.R

@Preview
@Composable
fun MyImage(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.it),
        contentDescription = "Avatar Image Profile",
        modifier = Modifier.size(300.dp)
            .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
            .border(width = 5.dp,
                    brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue,Color.Yellow)),
                    shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp)),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(model = "https://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2026%2F0224%2Fr1619607_1296x729_16%2D9.jpg&w=570&format=jpg", contentDescription = "Image from Network",
               modifier.size(250.dp),
                onError = {Log.i("Aris","Ha ocurrido un error ${it.result.throwable.message}")})
}