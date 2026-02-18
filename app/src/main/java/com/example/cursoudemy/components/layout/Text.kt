package com.example.cursoudemy.components.layout


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Pepe")
        Text(text = "Pepe Rojo", color = Color.Red)
        Text(text = "FontStyle", fontSize = 55.sp, fontStyle = FontStyle.Italic)
        Text(text = "fontweight", fontWeight = FontWeight.ExtraBold, fontSize = 50.sp)
        Text(text = "LetterSpacing", letterSpacing = 20.sp, modifier = Modifier.padding(all = 15.dp))
        Text(
            text = "TextDecoration",
            textDecoration = TextDecoration.Underline,
            fontSize = 15.sp,
            color = Color.Blue,
            modifier = Modifier.clickable{})
        Text(
            text = "TextAlign TextAlign TextAlign TextAlign TextAlign TextAlign TextAlign",
            maxLines = 1,
            modifier = Modifier.fillMaxWidth().background(color = Color.Red),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
            )
    }

}