package com.diaby404.intership_manager_jetpack_compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.launch



val offers = listOf(
    Offer(
        id = "offer_123",
        title = "Développeur Android Senior",
        description = "Nous recherchons un développeur Android expérimenté pour rejoindre notre équipe. Vous travaillerez sur des projets innovants et stimulants.",
        location = "Paris, France"
    ),
    Offer(
        id = "offer_456",
        title = "Appartement 2 pièces à louer",
        description = "Appartement meublé de 2 pièces, idéalement situé proche des commerces et des transports.",
        location = "Lyon, France"
    ),
    Offer(
        id = "offer_789",
        title = "Cours de yoga à domicile",
        description = "Professeur de yoga certifié propose des cours particuliers à domicile, adaptés à tous les niveaux.",
        location = "Marseille, France"
    ),
    Offer(
        id = "offer_123",
        title = "Développeur Android Senior",
        description = "Nous recherchons un développeur Android expérimenté pour rejoindre notre équipe. Vous travaillerez sur des projets innovants et stimulants.",
        location = "Paris, France"
    ),
    Offer(
        id = "offer_456",
        title = "Appartement 2 pièces à louer",
        description = "Appartement meublé de 2 pièces, idéalement situé proche des commerces et des transports.",
        location = "Lyon, France"
    ),
    Offer(
        id = "offer_789",
        title = "Cours de yoga à domicile",
        description = "Professeur de yoga certifié propose des cours particuliers à domicile, adaptés à tous les niveaux.",
        location = "Marseille, France"
    ),
    Offer(
        id = "offer_123",
        title = "Développeur Android Senior",
        description = "Nous recherchons un développeur Android expérimenté pour rejoindre notre équipe. Vous travaillerez sur des projets innovants et stimulants.",
        location = "Paris, France"
    ),
    Offer(
        id = "offer_456",
        title = "Appartement 2 pièces à louer",
        description = "Appartement meublé de 2 pièces, idéalement situé proche des commerces et des transports.",
        location = "Lyon, France"
    ),
    Offer(
        id = "offer_789",
        title = "Cours de yoga à domicile",
        description = "Professeur de yoga certifié propose des cours particuliers à domicile, adaptés à tous les niveaux.",
        location = "Marseille, France"
    ),
    Offer(
        id = "offer_123",
        title = "Développeur Android Senior",
        description = "Nous recherchons un développeur Android expérimenté pour rejoindre notre équipe. Vous travaillerez sur des projets innovants et stimulants.",
        location = "Paris, France"
    ),
    Offer(
        id = "offer_456",
        title = "Appartement 2 pièces à louer",
        description = "Appartement meublé de 2 pièces, idéalement situé proche des commerces et des transports.",
        location = "Lyon, France"
    ),
    Offer(
        id = "offer_789",
        title = "Cours de yoga à domicile",
        description = "Professeur de yoga certifié propose des cours particuliers à domicile, adaptés à tous les niveaux.",
        location = "Marseille, France"
    ),
    Offer(
        id = "offer_123",
        title = "Développeur Android Senior",
        description = "Nous recherchons un développeur Android expérimenté pour rejoindre notre équipe. Vous travaillerez sur des projets innovants et stimulants.",
        location = "Paris, France"
    ),
    Offer(
        id = "offer_456",
        title = "Appartement 2 pièces à louer",
        description = "Appartement meublé de 2 pièces, idéalement situé proche des commerces et des transports.",
        location = "Lyon, France"
    ),
    Offer(
        id = "offer_789",
        title = "Cours de yoga à domicile",
        description = "Professeur de yoga certifié propose des cours particuliers à domicile, adaptés à tous les niveaux.",
        location = "Marseille, France"
    )


)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    //Menu
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("List", "Like")
    val selectedIcons = listOf(Icons.Filled.List, Icons.Filled.Favorite)
    val unselectedIcons =
        listOf(Icons.Outlined.List, Icons.Outlined.FavoriteBorder )

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            TopAppBar(title = { Text("Bonjour Users") })
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                contentDescription = item
                            )
                        },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            scope.launch {
                                snackbarHostState.showSnackbar("$item clicked")
                            }
                        }
                    )
                }
            }
            /*
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons., contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Build,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Add offer clicked")
                            }
                        }
                    ){
                        Icon(Icons.Filled.Add, contentDescription = "")
                    }
                }
            )
            */
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Add offer clicked")
                        navController.navigate("offer_input")
                    }
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        }

    ) { contentPadding ->
        when(selectedItem) {
            0 -> OffersList(offers,contentPadding,onOfferClick = {  title ->
                scope.launch {
                    snackbarHostState.showSnackbar("Offer clicked: $title")

                }
            })
            1 -> Favorites()
            else -> { // Note the block
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Page Inconnue !")
                }
            }

        }




    }





}