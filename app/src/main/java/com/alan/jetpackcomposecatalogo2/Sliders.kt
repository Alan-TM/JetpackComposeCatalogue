package com.alan.jetpackcomposecatalogo2

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun BasicSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    Column() {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            }
        )

        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AdvanceSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    var completeValue by remember {
        mutableStateOf("")
    }

    Column() {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            onValueChangeFinished = {
                completeValue = sliderPosition.toString()
            },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember {
        mutableStateOf(0f..10f)
    }

    Column() {
        RangeSlider(
            values = currentRange,
            onValueChange = {
                currentRange = it
            },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = "1st value ${currentRange.start}")
        Text(text = "2nd value ${currentRange.endInclusive}")
    }
}
