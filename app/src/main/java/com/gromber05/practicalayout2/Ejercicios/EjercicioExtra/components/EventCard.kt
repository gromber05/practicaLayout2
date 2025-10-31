package com.gromber05.practicalayout2.Ejercicios.EjercicioExtra.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage

@Composable
fun EventCard(
    title: String,
    subtitle: String,
    description: String,
    imageUrl: String?,
    modifier: Modifier = Modifier
) {
    var interestedCount by rememberSaveable { mutableStateOf(23) }
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    var isInterested by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            val (
                imgRef, titleRef, subtitleRef,
                descRef, actionsRef,
                counterRef, plusRef, minusRef, footerLabelRef,
                showMore
            ) = createRefs()
            Box(
                modifier = Modifier
                    .constrainAs(imgRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        width = Dimension.fillToConstraints
                    }
                    .height(168.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.BottomStart
            ) {
                if (!imageUrl.isNullOrBlank()) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = "Imagen del evento",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(titleRef) {
                        start.linkTo(imgRef.start, 12.dp)
                        end.linkTo(imgRef.end, 12.dp)
                        bottom.linkTo(imgRef.bottom, 36.dp)
                        width = Dimension.fillToConstraints
                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.75f))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(subtitleRef) {
                        start.linkTo(imgRef.start, 12.dp)
                        end.linkTo(imgRef.end, 12.dp)
                        bottom.linkTo(imgRef.bottom, 8.dp)
                        width = Dimension.fillToConstraints
                    }
                    .clip(RoundedCornerShape(6.dp))
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.75f))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = if (isExpanded) 10 else 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(descRef) {
                        top.linkTo(imgRef.bottom, 12.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                    .padding(horizontal = 2.dp)
            )
            EventActions(
                modifier = Modifier.constrainAs(actionsRef) {
                    top.linkTo(descRef.bottom, 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                onInteresa = { isInterested = !isInterested },
                onCompartir = {

                },
                onGuardar = { /*Tengo que colocar aquí lo que va a realizar cuando se le de a guardar*/ }
            )
            val textEndBarrier = createEndBarrier(titleRef, subtitleRef, descRef)
            Text(
                text = "Interesados: $interestedCount",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.constrainAs(counterRef) {
                    top.linkTo(actionsRef.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(footerLabelRef.start, margin = 16.dp)

                }
            )

            Text(
                text = "+1",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .clickable { interestedCount += 1 }
                    .padding(10.dp)
                    .constrainAs(plusRef) {
                        baseline.linkTo(counterRef.baseline)
                        start.linkTo(counterRef.end)
                    }
            )

            Text(
                text = "−1",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .clickable { if (interestedCount > 0) interestedCount -= 1 }
                    .padding(10.dp)
                    .constrainAs(minusRef) {
                        baseline.linkTo(counterRef.baseline)
                        start.linkTo(plusRef.end, 8.dp)
                    }
            )
            Text(
                text = if (isInterested) "Interesa ✓" else "Interesa",
                style = MaterialTheme.typography.titleSmall,
                color = if (isInterested) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { isInterested = !isInterested }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .constrainAs(footerLabelRef) {
                        baseline.linkTo(showMore.baseline)
                        start.linkTo(showMore.end, margin = 12.dp)
                        end.linkTo(parent.end, margin = 12.dp)
                        width = Dimension.wrapContent
                        horizontalBias = 0f
                    }
            )
            Text(
                text = if (isExpanded) "Mostrar menos" else "Mostrar más",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
                    .padding(top = 16.dp)
                    .constrainAs(showMore) {
                        top.linkTo(counterRef.bottom, 12.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Preview(
    name = "Card - Textos cortos (360x640)",
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun EventCardShortPreview() {
    Surface {
        EventCard(
            title = "Noche de Jazz",
            subtitle = "Vie 7 nov · 20:00",
            description = "Trío acústico en un ambiente íntimo.",
            imageUrl = null,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview(
    name = "Card - Textos largos (320x700) · Dark",
    showBackground = true,
    widthDp = 320,
    heightDp = 700,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun EventCardLongPreview() {
    val longTitle =
        "Festival Internacional de Arte Contemporáneo — Apertura oficial y recorrido guiado por comisariado invitado"
    val longSubtitle =
        "Sábado 22 de noviembre de 2025 · 10:30 — 18:00 · Centro Cultural de la Ciudad, Sala Principal"
    val longDesc =
        "Explora instalaciones inmersivas y performances site-specific de artistas emergentes y consagrados. " +
                "La visita guiada incluye pausas para coloquios breves y Q&A con el comisariado. " +
                "Recomendamos llegar con antelación para el registro y recogida de pulseras de acceso. " +
                "Aforo limitado. Accesible. Idiomas: ES/EN."

    Surface {
        EventCard(
            title = longTitle,
            subtitle = longSubtitle,
            description = longDesc,
            imageUrl = "https://images.unsplash.com/photo-1529101091764-c3526daf38fe?w=800",
            modifier = Modifier.padding(12.dp)
        )
    }
}
