package com.alan.jetpackcomposecatalogo2.checkbox_avanzado

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

@Composable
fun MyCheckBoxWithTextStateHoisting(checkInfo: CheckInfo) {
    Row() {
        Checkbox(
            checked = checkInfo.isSelected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.isSelected) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxList() {
    val getOptions = getOptions(listOf("Alan", "Eric", "Android"))

    Column() {
        getOptions.forEach {
            MyCheckBoxWithTextStateHoisting(checkInfo = it)
        }
    }
}

// List of checkbox with different titles
@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var state by rememberSaveable {
            mutableStateOf(false)
        }

        CheckInfo(
            title = it,
            isSelected = state,
            onCheckedChange = { newStatus ->
                state = newStatus
            }
        )
    }
}
