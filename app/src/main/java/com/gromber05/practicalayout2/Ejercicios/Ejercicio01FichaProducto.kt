package com.gromber05.practicalayout2.Ejercicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import com.gromber05.practicalayout2.R
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun FichaProducto(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
    ) {
        val context = LocalContext.current
        val title: String = ""
        val price: String = ""
        val imageRes: Int = R.drawable.ic_launcher_foreground
        val onBuyClick: () -> Unit = {}

        Card(modifier = modifier.fillMaxWidth()) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                val (imgRef, titleRef, priceRef, buyRef) = createRefs()

                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .constrainAs(imgRef) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        }
                )

                Text(
                    text = title,
                    style =
                        MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.constrainAs(titleRef) {
                        start.linkTo(imgRef.end, margin = 12.dp)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        width = androidx.constraintlayout.compose.Dimension.preferredWrapContent
                    }
                )

                Text(
                    text = price,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.constrainAs(priceRef) {
                        start.linkTo(titleRef.start)
                        top.linkTo(titleRef.bottom, margin = 6.dp)
                        end.linkTo(parent.end)
                        width = androidx.constraintlayout.compose.Dimension.preferredWrapContent
                    }
                )

                val endBarrier = createEndBarrier(titleRef, priceRef)

                val gap = 8.dp
                Button(
                    onClick = onBuyClick,
                    modifier = Modifier.constrainAs(buyRef) {
                        start.linkTo(
                            endBarrier,
                            margin = gap
                        )
                        top.linkTo(titleRef.top)
                        end.linkTo(parent.end, margin = 30.dp)
                    }
                ) { Text("Comprar") }
            }
        }

    }
}

@Preview
@Composable
fun PreviewFicha() {
    FichaProducto(Modifier)
}