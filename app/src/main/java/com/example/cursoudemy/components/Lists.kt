package com.example.cursoudemy.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick:(String)->Unit) {
    val names = listOf(
        "Aris",
        "Pepe",
        "Ramon",
        "Ruben",
        "Aris",
        "Pepe",
        "Ramon",
        "Ruben",
        "Aris",
        "Pepe",
        "Ramon",
        "Ruben"
    )
    LazyColumn {
        items(names, key = {myValue -> myValue}) {myValue->
            Text(myValue, modifier = Modifier
                .padding(24.dp)
                .clickable { onItemClick(myValue) })
        }
    }
}

@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    //genera 100 posiciones
    var items by remember { mutableStateOf(List(100) {"Item numero # $it"})}

    LazyColumn {
        item {
            Button({
                items = items.toMutableList().apply { add(0, "Hola") }
            })  {Text("AñadirItem")}
        }

        //no solo viene el dato sino tambien el indice a diferencia de items
        itemsIndexed(items, key = {_, item -> item}) {index, item ->
            Row {
               Text(" "+item + " indice: $index")
                Spacer(Modifier.weight(1f)) //usa todo el alto
                TextButton({
                    items = items.toMutableList().apply {
                        //remove(item)
                        removeAt(index)
                    }
                }) {Text("Borrar") }
                Spacer(Modifier.width(24.dp))
            }

        }
    }
}