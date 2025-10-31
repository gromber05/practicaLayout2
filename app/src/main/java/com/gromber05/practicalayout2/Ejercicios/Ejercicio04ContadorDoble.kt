package com.gromber05.practicalayout2.Ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun ContadorDoble(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var contador by rememberSaveable { mutableStateOf(0) }

        Button(onClick = {
            contador++
        }) { Text("+1") }

        Button(onClick = {
            if (contador >0) contador--
        }) { Text("-1") }

        Text(text = "Contador: $contador")
    }
}

@Preview
@Composable
fun PreviewContadorDoble() {
    ContadorDoble(Modifier)
}