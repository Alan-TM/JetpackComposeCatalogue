package com.alan.jetpackcomposecatalogo2.radiobutton_avanzado

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(
                selected = name == "Aris",
                onClick = { onItemSelected("Aris") }
            )
            Text(text = "Aris")
        }

        Row() {
            RadioButton(
                selected = name == "Alan",
                onClick = { onItemSelected("Alan") }
            )
            Text(text = "Alan")
        }

        Row() {
            RadioButton(
                selected = name == "Nayeli",
                onClick = { onItemSelected("Nayeli") }
            )
            Text(text = "Nayeli")
        }
    }
}