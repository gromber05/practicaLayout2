package com.gromber05.practicalayout2

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ChainStyle
import com.gromber05.practicalayout2.Ejercicios.AccionesPrincipales
import com.gromber05.practicalayout2.Ejercicios.ColoresEstado
import com.gromber05.practicalayout2.Ejercicios.ContadorDoble
import com.gromber05.practicalayout2.Ejercicios.EjercicioExtra.MainEjercicioExtra
import com.gromber05.practicalayout2.Ejercicios.FichaProducto
import com.gromber05.practicalayout2.Ejercicios.InterruptorVisibilidad
import com.gromber05.practicalayout2.ui.theme.PracticaLayout2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaLayout2Theme {
                AppPrincipal()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPrincipal() {
    var pantallaActual by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Practica Layout2 - Gonzalo Romero Bernal")
            })

        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = pantallaActual == 0,
                    onClick = { pantallaActual = 0 },
                    label = { Text("Ej1") },
                    icon = { Text("1") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 1,
                    onClick = { pantallaActual = 1 },
                    label = { Text("Ej2") },
                    icon = { Text("2") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 2,
                    onClick = { pantallaActual = 2 },
                    label = { Text("Ej3") },
                    icon = { Text("3") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 3,
                    onClick = { pantallaActual = 3 },
                    label = { Text("Ej4") },
                    icon = { Text("4") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 4,
                    onClick = { pantallaActual = 4 },
                    label = { Text("Ej5") },
                    icon = { Text("5") }
                )
                NavigationBarItem(
                    selected = pantallaActual == 5,
                    onClick = { pantallaActual = 5 },
                    label = { Text("Ej6") },
                    icon = { Text("6") }
                )
            }
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            when (pantallaActual) {
                0 -> FichaProducto()
                1 -> {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(10.dp)
                    ) {
                        Text(text = "ChainStyle.Spread", fontSize = 16.sp)
                        AccionesPrincipales(Modifier, ChainStyle.Spread)
                        Spacer(Modifier.padding(10.dp))
                        Text(text = "ChainStyle.SpreadInside", fontSize = 16.sp)
                        AccionesPrincipales(Modifier, ChainStyle.SpreadInside)
                        Spacer(Modifier.padding(10.dp))
                        Text(text = "ChainStyle.Packed", fontSize = 16.sp)
                        AccionesPrincipales(Modifier, ChainStyle.Packed)
                    }

                }
                2 -> ColoresEstado()
                3 -> ContadorDoble()
                4 -> InterruptorVisibilidad()
                5 -> MainEjercicioExtra()
            }
        }
    }
}