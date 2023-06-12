package com.alan.jetpackcomposecatalogo2.checkbox_avanzado

data class CheckInfo(
    val title: String,
    val isSelected: Boolean = false,
    val onCheckedChange: (Boolean) -> Unit
)
