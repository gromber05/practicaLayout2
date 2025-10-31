package com.gromber05.practicalayout2.Ejercicios.EjercicioExtra

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gromber05.practicalayout2.Ejercicios.EjercicioExtra.components.EventCard

@Composable
fun MainEjercicioExtra(modifier: Modifier = Modifier) {
    Column {
        EventCard(
            title = "Gonzalo Romero Bernal",
            subtitle = "Dom 17 Nov · 19:30 · Sala Central",
            description = "Charla sobre desarrollo multiplataforma, diseño de UI con Jetpack Compose y buenas prácticas en arquitectura moderna. Preguntas en directo al final.",
            imageUrl = "https://images.unsplash.com/photo-1529101091764-c3526daf38fe?w=800",
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
fun Preview_MainEjercicioExtra() {
    MainEjercicioExtra()
}