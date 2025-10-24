package com.gromber05.practicalayout2.Ejercicios


import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun AccionesPrincipales(modifier: Modifier = Modifier, chainStyle: ChainStyle) {
    ConstraintLayout(
        modifier = modifier.padding(10.dp).fillMaxWidth().height(50.dp)
    ) {
        val (buttonARef, buttonBRef, buttonCRef) = createRefs()
        val context = LocalContext.current

        Button(
            onClick = { Toast.makeText(context, "1", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.constrainAs(buttonARef) {
                top.linkTo(parent.top)
            }
        ) { Text("Botón 1") }

        Button(
            onClick = { Toast.makeText(context, "2", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.constrainAs(buttonBRef) {
                top.linkTo(parent.top)
            }
        ) { Text("Botón 2") }

        Button(
            onClick = { Toast.makeText(context, "3", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.constrainAs(buttonCRef) {
                top.linkTo(parent.top)
            }
        ) { Text("Botón 3") }

        createHorizontalChain(
            buttonARef, buttonBRef, buttonCRef,
            chainStyle = chainStyle
        )
    }

}

@Preview
@Composable
fun PreviewSpread() {
    AccionesPrincipales(Modifier, ChainStyle.Spread)
}

@Preview
@Composable
fun PreviewSpreadInside() {
    AccionesPrincipales(Modifier, ChainStyle.SpreadInside)
}

@Preview
@Composable
fun PreviewPacked() {
    AccionesPrincipales(Modifier, ChainStyle.Packed)
} 