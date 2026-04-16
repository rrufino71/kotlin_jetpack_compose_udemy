package com.example.cursoudemy.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cursoudemy.components.model.DrawerItem
import com.example.cursoudemy.components.model.NavItem
import kotlinx.coroutines.CoroutineScope

@Composable
fun MyModalDrawer(drawerState: DrawerState, content:@Composable () -> Unit) {
    val scope: CoroutineScope = rememberCoroutineScope()
    val myItems = listOf(
        DrawerItem(title = "Home", icon = Icons.Default.Home, notification = 3),
        DrawerItem(title = "Favorite", icon = Icons.Default.Favorite, notification = 0),
        DrawerItem(title = "Build", icon = Icons.Default.Build, notification = 9),
        DrawerItem(title = "Call", icon = Icons.Default.Call, notification = 0),
        DrawerItem(title = "Location", icon = Icons.Default.LocationOn, notification = 3)
        )
    var selectedIndex by remember {mutableIntStateOf(0)}
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
                Spacer(Modifier.height(44.dp))
                myItems.forEachIndexed { index,drawerItem ->
                    NavigationDrawerItem(
                        modifier = Modifier.width(300.dp),
                        label = {Text(drawerItem.title)},
                        selected = selectedIndex==index,
                        onClick = {selectedIndex=index},
                        icon = {Icon(imageVector = drawerItem.icon, contentDescription = null)},
                        badge = {
                            if(drawerItem.notification>0) {
                                Badge(
                                    containerColor = if(selectedIndex==index) Color.White else Color.Red,
                                    contentColor = if(selectedIndex==index) Color.Red else Color.White,
                                ) { Text(drawerItem.notification.toString()) }
                            }
                        },
                        shape = RoundedCornerShape(10),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Red,
                            selectedIconColor =  Color.White,
                            selectedTextColor = Color.White,
                            selectedBadgeColor = Color.Yellow,
                            unselectedContainerColor = Color.White,
                            unselectedIconColor = Color.Red,
                            unselectedTextColor = Color.Red ,
                            unselectedBadgeColor= Color.Green,
                        )
                    )
                }
            }
        },
        scrimColor = Color.Red.copy(alpha = 0.7f) //tiene opacidad
    ) {
        //la vista que recibo por parametros
        content()
    }

}