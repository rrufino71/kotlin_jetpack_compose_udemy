package com.example.cursoudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cursoudemy.components.exercise.Ejercicio2
import com.example.cursoudemy.components.layout.ConstraintBarrier
import com.example.cursoudemy.components.layout.ConstraintChain
import com.example.cursoudemy.components.layout.ConstraintExampleGuide
import com.example.cursoudemy.components.layout.MyBasicConstraintLayout
import com.example.cursoudemy.ui.theme.CursoUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoUdemyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ConstraintChain(Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name! Master ",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CursoUdemyTheme {
        Greeting("Android")
    }
}