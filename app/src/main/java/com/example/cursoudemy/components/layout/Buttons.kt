package com.example.cursoudemy.components.layout

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursoudemy.R

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier = modifier) {
        Button(onClick = {Log.i("Aris","Boton Pulsado")},
                enabled = true,
                shape = RoundedCornerShape(20),
                border = BorderStroke(3.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Red,
                    containerColor = Color.White,
                    disabledContentColor = Color.Green,
                    disabledContainerColor = Color.Yellow
                )
            ) {
              Text("Pulsame")
        }

        OutlinedButton(onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContentColor = Color.Green,
                disabledContainerColor = Color.Yellow)
            ) {
            Text("Outlined")
        }

        TextButton(onClick = {}) {
            Text("TextButton")
        }
        ElevatedButton(onClick = {}, elevation = ButtonDefaults.elevatedButtonElevation(10.dp)) {
            Text("ElevatedButton")
        }

        FilledTonalButton(onClick = {}) {
            Text("FilledTonalButton")
        }
    }
}

@Preview
@Composable
fun MyFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        shape = CircleShape,
        contentColor = Color.White,
        containerColor = Color.Red,
        elevation =  FloatingActionButtonDefaults.elevation(defaultElevation = 15.dp)
    ){
        Icon(painter = painterResource(R.drawable.ic_add),contentDescription = null)
    }
}