package com.diaby404.intership_manager_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.diaby404.intership_manager_jetpack_compose.ui.theme.Intership_manager_jetpack_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Intership_manager_jetpack_composeTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val myNavController = rememberNavController()
    NavHost(navController = myNavController, startDestination = "onBoarding") {
        composable("onboarding") { Onboarding(myNavController)}
        composable("login") { Login(myNavController) }
        composable("signup") { SignUp() }
        composable("home") { Home() }
    }
}



@Composable
fun Home() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Bienvenue à la maison !")
    }
}


@Composable
fun SignUp() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Bienvenue à la âde d'inscription !")
    }
}
