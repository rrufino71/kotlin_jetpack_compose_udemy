package com.example.cursoudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursoudemy.components.MyCard
import com.example.cursoudemy.components.MyElevatedCard
import com.example.cursoudemy.components.MyModalDrawer
import com.example.cursoudemy.components.MyNavigationBar
import com.example.cursoudemy.components.MyOutlinedCard
import com.example.cursoudemy.components.MyTopAppBar
import com.example.cursoudemy.components.layout.MyFAB
import com.example.cursoudemy.ui.theme.CursoUdemyTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoUdemyTheme {
                val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val snackbarHotState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                MyModalDrawer(drawerState) {
                    Scaffold(modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar {scope.launch {drawerState.open() } } },
                        snackbarHost = { SnackbarHost(hostState = snackbarHotState) },
                        floatingActionButton = { MyFAB() },
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = { MyNavigationBar() }

                    ) { innerPadding ->
                        Box(
                            modifier=Modifier.fillMaxSize()
                                .background(Color.Cyan)
                                .padding(innerPadding),
                                contentAlignment = Alignment.Center
                        )
                        {
                            MyOutlinedCard()
/*
                            Text("Esta es mi screen", modifier = Modifier.clickable{
                                scope.launch {
                                    val result = snackbarHotState.showSnackbar(
                                        message= "Ejemplo asnackbar",
                                        actionLabel = "Deshacer"
                                    )
                                    if (result==SnackbarResult.ActionPerformed) {
                                        //pulso deshacer
                                    }else{
                                        //se fue solo
                                    }

                                }
                            })
*/
                        }
                    }
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