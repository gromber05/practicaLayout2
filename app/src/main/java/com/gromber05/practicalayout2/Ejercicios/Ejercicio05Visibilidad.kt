package com.gromber05.practicalayout2.Ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*

@Composable
fun InterruptorVisibilidad(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var stateText by rememberSaveable { mutableStateOf(false) }

        Button(onClick = {
            stateText = !stateText
        }) { Text(text = if (!stateText) "Ocultar texto" else "Mostrar texto") }
        Spacer(Modifier.padding(10.dp))

        if (!stateText) Text("Hola, soy un texto que no está oculto")
    }
}