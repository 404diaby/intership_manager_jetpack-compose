package com.diaby404.intership_manager_jetpack_compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import java.util.Date


@Composable
fun OfferInput() {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)

        ) {
            Text("Entrez une nouvelle offre")
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") }
            )
            Spacer(Modifier.height(20.dp))
            TextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Définit la hauteur comme un textarea
                placeholder = {
                    Text(text = "Description here ...", textAlign = TextAlign.Start)
                },
                maxLines = Int.MAX_VALUE, // Autorise un nombre illimité de lignes
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                ),
                singleLine = false // Assure un comportement multi-lignes
            )
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = location,
                onValueChange = { location = it },
                label = { Text("Location") }
            )
            Spacer(Modifier.height(30.dp))
            // Ajoutez les autres champs similairement
            Button(onClick = {
                println("Add new offer")
                    // Réinitialiser les champs
                    title = ""
                    description = ""
                    location = ""
            }) {
                Text("Add new offer")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "OfferInputPreview" )
@Composable
fun OfferInputPreview(){
    OfferInput()
}