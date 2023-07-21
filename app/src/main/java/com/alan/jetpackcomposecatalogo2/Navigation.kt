package com.alan.jetpackcomposecatalogo2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.alan.jetpackcomposecatalogo2.model.Routes

@Composable
fun Screen1(navController: NavHostController) {
    Box(Modifier.fillMaxSize().background(Color.Cyan)) {
        Text(
            "Pantalla 1",
            modifier = Modifier.align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla2.route) }
        )
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(Modifier.fillMaxSize().background(Color.Green)) {
        Text(
            "Pantalla 2",
            modifier = Modifier.align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla3.route) }
        )
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(Modifier.fillMaxSize().background(Color.Magenta)) {
        Text(
            "Pantalla 3",
            modifier = Modifier.align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla4.createRoute(123456789)) }
        )
    }
}

@Composable
fun Screen4(navController: NavHostController, age: Int) {
    Box(Modifier.fillMaxSize().background(Color.Yellow)) {
        Text(
            "Tengo $age años de edad",
            modifier = Modifier.align(Alignment.Center)
                .clickable { navController.navigate(Routes.Pantalla5.createRoute("Alan")) }
        )
    }
}

@Composable
fun Screen5(navController: NavHostController, name: String?) {
    Box(Modifier.fillMaxSize().background(Color.Yellow)) {
        Text(
            "Me llamo $name",
            modifier = Modifier.align(Alignment.Center)
                .clickable { navController.navigate("pantalla1") }
        )
    }
}

