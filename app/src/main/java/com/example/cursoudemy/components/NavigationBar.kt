package com.example.cursoudemy.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.cursoudemy.R
import com.example.cursoudemy.components.model.NavItem


@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {

    val itemList = listOf(
        NavItem("Home",Icons.Default.Home),
        NavItem("Favorite",Icons.Default.Favorite),
        NavItem("Profile",Icons.Default.Person)
        )

    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {Icon(painter = painterResource(R.drawable.ic_revert), contentDescription = null)},
            label = {Text("Home")},
            alwaysShowLabel = true,
            colors =  NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.Red,
                indicatorColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.Gray,
                disabledTextColor = Color.Gray)
        )



    }
}