package com.example.cursoudemy.components.layout

import android.widget.CheckBox
import android.widget.Switch
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cursoudemy.R


@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_personita),
                    contentDescription = ""
                )
            },
            enabled = true,
            colors = SwitchDefaults.colors(
                //Bolita
                checkedThumbColor = Color.Green,
                uncheckedThumbColor = Color.Black,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Cyan,
                //Icono
                checkedIconColor = Color.Blue,
                uncheckedIconColor = Color.LightGray,
                disabledUncheckedIconColor = Color.Green,
                disabledCheckedIconColor = Color.Red,
                //Borde
                checkedBorderColor = Color.Magenta,
                uncheckedBorderColor = Color.Magenta,
                disabledCheckedBorderColor = Color.Magenta,
                disabledUncheckedBorderColor = Color.Magenta,
                //Track
                checkedTrackColor = Color.White,
                uncheckedTrackColor = Color.Black,
                disabledCheckedTrackColor = Color.White,
                disabledUncheckedTrackColor = Color.Black


            )

        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var state: Boolean by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.clickable{state = !state}){
            Checkbox(
                checked = state,
                onCheckedChange = { state = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Green,
                    checkmarkColor = Color.Yellow,
                    disabledCheckedColor = Color.Black,
                    disabledUncheckedColor = Color.Blue,


                    )
            )
            Spacer(Modifier.width(12.dp))
            Text("Acepto Terminos y condiciones")

        }

    }


}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {

    var state: List<CheckBoxState> by remember {
        mutableStateOf(
            listOf(
                CheckBoxState("terms", "Aceptar Terminos y condiciones"),
                CheckBoxState("newsletter", "Recibir newsletter",true),
                CheckBoxState("updates", "Recibir actualizaciones"),

            )
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked)
                    }else {
                        it
                    }
                }
            }
        }
    }
    
}


@Composable
fun CheckBoxWithText(
        modifier: Modifier = Modifier,
        checkBoxState: CheckBoxState,
        onCheckedChange:(CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkBoxState) })
    {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.Yellow,
                disabledCheckedColor = Color.Black,
                disabledUncheckedColor = Color.Blue,
            )
        )
        Spacer(Modifier.width(12.dp))
        Text(checkBoxState.label)
    }
}