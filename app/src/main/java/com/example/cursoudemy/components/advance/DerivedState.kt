package com.example.cursoudemy.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDerivatedStateOf(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // aca se recompone la vista cada vez que pulsamos una tecla
    //val isFormatValid = email.contains("@") && password.length > 4

    //se regenera el composable solo si cumple la condicions
    val isFormatValid by remember(email,password) {
        derivedStateOf {
            email.contains("@") && password.length > 4
        }
    }



    Column(modifier = Modifier.background(Color.White)) {
        TextField(email, onValueChange = {email = it})
        Spacer(Modifier.height(4.dp))
        TextField(password, onValueChange = {password = it})
        Spacer(Modifier.height(24.dp))
        Button(onClick={}, enabled = isFormatValid) {
           Text("Login")
        }
    }
}