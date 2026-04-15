package com.example.cursoudemy.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Dimension.Companion.percent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(drawerState: DrawerState, content:@Composable () -> Unit) {
    val scope: CoroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        //contenedor del modal drawer
        drawerState = drawerState,
        drawerContent = {
            //menu
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp),
                drawerContentColor = Color.Red,
                drawerContainerColor = Color.White,
                drawerTonalElevation = 10.dp

            ) {
                NavigationDrawerItem(
                    label = {Text("")}


                )
            }
        },
        scrimColor = Color.Red
    ) {
        //la vista que recibo por parametros
        content()
    }

}