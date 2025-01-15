package com.diaby404.intership_manager_jetpack_compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@SuppressLint("StaticFieldLeak")



@Composable
fun OffersList(offers: List<Offer>, paddingValues: PaddingValues, onOfferClick: (String) -> Unit ) {
    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier.fillMaxSize(),
        //contentPadding = PaddingValues(16.dp)
    ) {
        items(offers) { offer ->
            OfferItem(
                offer = offer,
                onOfferClick = onOfferClick
                )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true, name = "OffersListPreview" )
@Composable
fun OfferListPreview(name: String = "404diaby") {

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
            TopAppBar(title = { Text("Bonjour $name") })
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
                    }
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        }

    ) { contentPadding ->
            OffersList(offers,contentPadding,onOfferClick = {  title ->
                scope.launch {
                    snackbarHostState.showSnackbar("Offer clicked: $title")
                }
            })
    }
}