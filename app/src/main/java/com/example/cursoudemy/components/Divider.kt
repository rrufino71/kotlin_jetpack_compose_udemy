package com.example.cursoudemy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Parte de Arriba")
        HorizontalDivider(thickness = 5.dp,color=Color.Red)
        Text("Parte de Abajo")
        HorizontalDivider(thickness = 5.dp,color=Color.Red)

        Row {
            Text("Izquierda")
            VerticalDivider(thickness = 5.dp,color=Color.Gray)
            Text("Derecha")
        }
    }
}