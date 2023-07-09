package com.alan.jetpackcomposecatalogo2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TriStateCheckbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alan.jetpackcomposecatalogo2.ui.theme.JetpackComposeCatalogo2Theme
import com.alan.jetpackcomposecatalogo2.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogo2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /*var myText by remember {
                        mutableStateOf("")
                    }
                    MyTextField(myText) {
                        myText = it
                    }

                    MyButton()*/

                    // Checkbox with state hoisting
                    /*var status by rememberSaveable {
                        mutableStateOf(false)
                    }
                    val checkInfo = CheckInfo(
                        title = "Ejemplo 1",
                        isSelected = status,
                        onCheckedChange = { newStatus ->
                            status = newStatus
                        }
                    )*/

                    // MyCheckBoxList()

                    // Radio button state hoisting
                    /*var selected by rememberSaveable {
                        mutableStateOf("Aris")
                    }
                    MyRadioButtonList(selected) {
                        selected = it
                    }*/

                    // MyDropdownMenu()

                   /* var show by remember {
                        mutableStateOf(false)
                    }
                    Box(contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar dialogo")
                        }
                        MyConfirmationDialog(
                            show = show,
                            onDismiss = { show = false }
                        )
                    }*/

                    // SimpleRecyclerView()
                    // SuperHeroStickyView()

                    ScaffoldExample()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogo2Theme {
        MyDivider()
    }
}

@Composable
fun MyDropdownMenu() {
    var selectedText by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    val desserts = listOf("Helado", "Chocolate", "Café", "Fruta", "Natillas", "Pastel")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {
                selectedText = it
            },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            desserts.forEach {
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedText = it
                    },
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(text = it)
                }
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .height(32.dp),
        color = Color.Red
    )
}

@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = {
            Badge() {
                Text(text = "1")
            }
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = Shapes.small,
        border = BorderStroke(5.dp, Color.Gray),
        backgroundColor = Color.Transparent
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = false,
            onClick = { },
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green
            )
        )
        Text(text = "Algo...")
    }
}

@Composable
fun MyTriStateCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.Off -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.Off
        }
    })
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Row() {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = false,
        colors = CheckboxDefaults.colors()
    )
}

@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = state,
        onCheckedChange = {
            state = !state
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            checkedTrackColor = Color.Blue,
            uncheckedThumbColor = Color.Yellow,
            uncheckedTrackColor = Color.Green
        )
    )
}

@Composable
fun MyProgressBarAdvance() {
    var incrementProgress by rememberSaveable {
        mutableStateOf(0.5f)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column() {
            CircularProgressIndicator(progress = incrementProgress)

            Row(Modifier.fillMaxWidth()) {
                Button(onClick = { incrementProgress += 0.1f }) {
                    Text(text = "Incrementar")
                }
                Button(onClick = { incrementProgress -= 0.1f }) {
                    Text(text = "Decrementar")
                }
            }
        }
    }
}

@Composable
fun MyProgressBar() {
    var isLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator()
            LinearProgressIndicator(Modifier.padding(top = 32.dp))
        }

        Button(onClick = { isLoading = !isLoading }) {
            Text(text = "Dame click!")
        }
    }
}

@Composable
fun MyIcon() {
    // There are more icons, import the library in app module
    // Keep in mind that the library is huge, use it only when necessary
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icono", tint = Color.Red)
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
        // Modifier.clip(RoundedCornerShape(25f))
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyButton() {
    var enabled by remember {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                enabled = false
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text("Hola")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(
        value = myText,
        onValueChange = { valueChanged ->
            myText = valueChanged
        },
        modifier = Modifier.padding(24.dp),
        label = {
            Text(text = "Test")
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Red
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }

    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = {
            Text(text = "Introduce algo...")
        }
    )
}

// State hoisting / Stateless composable
@Composable
fun MyTextField(
    name: String,
    onValueChanged: (String) -> Unit
) {
    TextField(
        value = name,
        onValueChange = { valueChanged ->
            onValueChanged(valueChanged)
        },
        placeholder = {
            Text(text = "Test")
        }
    )
}

@Composable
fun MyText() {
    Column(
        Modifier.fillMaxSize()
    ) {
        Text(text = "Hello")
        Text(text = "Hello", color = Color.Blue)
        Text(text = "Hello", fontWeight = FontWeight.Bold)
        Text(text = "Hello", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Hello", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(
            text = "Hello",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough,
                        TextDecoration.Underline
                    )
                )
            )
        )
        Text(text = "Hello", fontSize = 30.sp)
    }
}
