package com.gromber05.practicalayout2.Ejercicios

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun AccionesPrincipales(modifier: Modifier = Modifier) {
    var chainStyle by remember { mutableStateOf(ChainStyle.Spread) }

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        val (dividerRef, t1Ref, t2Ref, t3Ref, b1Ref, b2Ref, b3Ref) = createRefs()

        Text(
            text = "Texto 1",
            modifier = Modifier.constrainAs(t1Ref) {
                top.linkTo(parent.top, 16.dp)
                start.linkTo(parent.start)
            }
        )
        Text(
            text = "Texto 2",
            modifier = Modifier.constrainAs(t2Ref) {
                top.linkTo(parent.top, 16.dp)
            }
        )
        Text(
            text = "Texto 3",
            modifier = Modifier.constrainAs(t3Ref) {
                top.linkTo(parent.top, 16.dp)
                end.linkTo(parent.end)
            }
        )

        createHorizontalChain(t1Ref, t2Ref, t3Ref, chainStyle = chainStyle)

        HorizontalDivider(
            Modifier.constrainAs(dividerRef) {
                top.linkTo(t1Ref.bottom, 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        )

        Button(
            onClick = {
                chainStyle = ChainStyle.Spread
            },
            modifier = Modifier.constrainAs(b1Ref) {
                bottom.linkTo(parent.bottom, 16.dp)
            }
        ) { Text("Spread") }

        Button(
            onClick = {
                chainStyle = ChainStyle.SpreadInside
            },
            modifier = Modifier.constrainAs(b2Ref) {
                bottom.linkTo(parent.bottom, 16.dp)
            }
        ) { Text("SpreadInside") }

        Button(
            onClick = {
                chainStyle = ChainStyle.Packed
            },
            modifier = Modifier.constrainAs(b3Ref) {
                bottom.linkTo(parent.bottom, 16.dp)
            }
        ) { Text("Packed") }

        createHorizontalChain(b1Ref, b2Ref, b3Ref, chainStyle = ChainStyle.SpreadInside)
    }
}

@Preview
@Composable
fun PreviewAccionesPrincipales() {
    AccionesPrincipales()
}
