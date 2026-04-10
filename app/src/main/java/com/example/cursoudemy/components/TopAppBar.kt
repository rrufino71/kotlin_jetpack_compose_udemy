package com.example.cursoudemy.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.cursoudemy.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        {Text("My App")},
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_revert),
                contentDescription = null,
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_personita),
                contentDescription = null,
                tint = Color.White
            )
            Icon(
                painter = painterResource(R.drawable.ic_personita),
                contentDescription = null,
                tint = Color.White
            )
            Icon(
                painter = painterResource(R.drawable.ic_personita),
                contentDescription = null,
                tint = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Black,
            actionIconContentColor = Color.Red,
            scrolledContainerColor = Color.Black,
            subtitleContentColor = Color.Yellow,
        ),

    )

}