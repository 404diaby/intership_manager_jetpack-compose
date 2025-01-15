package com.diaby404.intership_manager_jetpack_compose

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun OfferItem(offer: Offer, onOfferClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onOfferClick(offer.title)}
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = offer.title,
                style = MaterialTheme.typography.titleMedium
            )
            /*Text(
                text = offer.description,
                style = MaterialTheme.typography.bodyMedium
            )*/
            Text(
                text = "${offer.location}",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}


@Composable
fun OfferItemWithouSnackbar(offer: Offer) {
    Card(
        onClick = {
            println("Clicked on offer: ${offer.title}")

        },
        enabled = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = offer.title,
                style = MaterialTheme.typography.titleMedium
            )
            /*Text(
                text = offer.description,
                style = MaterialTheme.typography.bodyMedium
            )*/
            Text(
                text = "${offer.location}",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true, name = "OfferItem1Preview", group = "OfferItem" )
@Composable
fun OfferItemPreview() {
    OfferItemWithouSnackbar(
        offer = Offer(
            id = "offer_123",
            title = "Développeur Android Senior",
            description = "Nous recherchons un développeur Android expérimenté pour rejoindre notre équipe. Vous travaillerez sur des projets innovants et stimulants.",
            location = "Paris, France"
        )
    )
}

