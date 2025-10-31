package com.gromber05.practicalayout2.Ejercicios

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

private val ColorSaver = Saver<Color, Long>(
    save = { it.value.toLong() },
    restore = { Color(it) }
)

@Composable
fun ColoresEstado(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(color = Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val colorList = listOf<Pair<String, Color>>(
            "Rojo" to Color.Red,
            "Verde" to Color.Green,
            "Amarillo" to Color.Yellow,
            "Azul" to Color.Blue
        )
        var actualColor by rememberSaveable(stateSaver = ColorSaver) { mutableStateOf(Color.Red) }
        var actualColorText by rememberSaveable { mutableStateOf("Rojo") }

        Text(text = actualColorText)

        Spacer(Modifier.padding(10.dp))

        Box(Modifier.size(50.dp).fillMaxSize()
            .background(actualColor)
        )
        Spacer(Modifier.padding(8.dp))
        Button(onClick = {
            val selectedColor = colorList.random()

            actualColorText = selectedColor.first
            actualColor = selectedColor.second
        }) { Text("Cambiar color")}
    }
}

@Preview
@Composable
fun PreviewColoresEstado() {
    ColoresEstado()
}