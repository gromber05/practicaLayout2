package com.gromber05.practicalayout2.Ejercicios.EjercicioExtra.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

/**
 * Fila de acciones “Interesa”, “Compartir”, “Guardar” en texto.
 * - Distribución mediante CHAIN horizontal.
 * - ChainStyle elegido: SpreadInside (equilibrado en móviles).
 * - Se ajusta el bias de "Compartir" para un balance visual sutil.
 */
@Composable
fun EventActions(
    onInteresa: () -> Unit,
    onCompartir: () -> Unit,
    onGuardar: () -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp)
    ) {
        val (aInteresa, aCompartir, aGuardar) = createRefs()

        // Construimos la cadena horizontal
        createHorizontalChain(aInteresa, aCompartir, aGuardar, chainStyle = ChainStyle.SpreadInside)

        Text(
            "Interesa",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .constrainAs(aInteresa) {
                    start.linkTo(parent.start)
                    end.linkTo(aCompartir.start)
                    width = Dimension.wrapContent
                    // bias por defecto 0.5 (centrado entre anclas)
                }
                .clickable(onClick = onInteresa)
                .padding(8.dp)
        )

        Text(
            "Compartir",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .constrainAs(aCompartir) {
                    start.linkTo(aInteresa.end)
                    end.linkTo(aGuardar.start)
                    width = Dimension.wrapContent
                    // Ajuste sutil de bias para “descargar” un poco hacia la izquierda
                    horizontalBias = 0.47f
                }
                .clickable(onClick = onCompartir)
                .padding(8.dp)
        )

        Text(
            "Guardar",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .constrainAs(aGuardar) {
                    start.linkTo(aCompartir.end)
                    end.linkTo(parent.end)
                    width = Dimension.wrapContent
                }
                .clickable(onClick = onGuardar)
                .padding(8.dp)
        )
    }
}
