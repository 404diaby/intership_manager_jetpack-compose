package com.diaby404.intership_manager_jetpack_compose

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


    @SuppressLint("NotConstructor")
    @Composable
    fun Onboarding(navController: NavController) {


        Scaffold(
            /*topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Top app bar")
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Bottom app bar",
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { presses++ }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }*/
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home Icon",
                        tint = Color.Blue,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(

                        text = "Intership Manager"
                    )

                    OutlinedButton(
                        onClick = {
                            println("Aller a la ge se connecter")
                            navController.navigate("login")

                        }
                    ) {
                        Text("Se Connecter")
                    }
                }
            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DisplayOnboardingPreview() {
        val myNavController = rememberNavController()
        NavHost(navController = myNavController, startDestination = "onBoarding") {
            composable("onboarding") { Onboarding(myNavController)}
            composable("login") { Login(myNavController) }
            composable("home") { Home() }
        }
        Onboarding(myNavController)
    }

