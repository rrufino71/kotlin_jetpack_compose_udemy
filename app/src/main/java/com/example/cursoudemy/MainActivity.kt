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
import com.example.cursoudemy.components.layout.MyButtons
import com.example.cursoudemy.components.layout.MyCheckBox
import com.example.cursoudemy.components.layout.MyImage
import com.example.cursoudemy.components.layout.MyNetworkImage
import com.example.cursoudemy.components.layout.MySwitch
import com.example.cursoudemy.components.layout.MyTextField
import com.example.cursoudemy.components.layout.MyTextFieldParent
import com.example.cursoudemy.components.layout.MyTexts
import com.example.cursoudemy.components.layout.Progress
import com.example.cursoudemy.components.layout.ProgressAdvance
import com.example.cursoudemy.components.layout.ProgressAnimation
import com.example.cursoudemy.ui.theme.CursoUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoUdemyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyCheckBox(Modifier.padding(innerPadding))
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