package com.diaby404.intership_manager_jetpack_compose

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



    @Preview
    @Composable
    fun DisplayLoginPreview(){
        val myNavController = rememberNavController()
        NavHost(navController = myNavController, startDestination = "onBoarding") {
            composable("onboarding") { Onboarding(myNavController)}
            composable("login") { Login(myNavController) }
            composable("home") { Home() }
        }
        Login(myNavController)
    }



    @SuppressLint("NotConstructor")
    @OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
    @Composable
    fun Login(navController: NavHostController) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current

        fun simulateFirebaseLogin(username: String, password: String) {
            // Simulation d'un appel Firebase avec un délai de 2 secondes

           /* kotlinx.coroutines.GlobalScope.launch {
                delay(2000)
                val success = username == "404diaby" && password == "123"
                if (success) {
                    Toast.makeText(context, "Connexion réussie", Toast.LENGTH_SHORT).show()
                    navController.navigate("home")
                } else {
                    Toast.makeText(context, "Échec de la connexion", Toast.LENGTH_SHORT).show()
                }

            }*/

            try {
                val success = username == "404diaby" && password == "123"
                if (success) {
                    Toast.makeText(context, "Connexion réussie", Toast.LENGTH_SHORT).show()
                    navController.navigate("home")
                } else {
                    throw Exception("Id  incorrect")
                }

            }catch (e: Exception){
                Toast.makeText(context, "Identifianbt incorrect", Toast.LENGTH_SHORT).show()
                println("Erreur de connexion :  $e")
            }





        }


        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(800),
                            text = "Connexion"
                        )
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
            }
        ) {
            innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        label = { Text("Username") },
                        value = username,
                        onValueChange = { username = it },
                        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null , tint = MaterialTheme.colorScheme.primary ) }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        label = { Text("Password") },
                        value = password,
                        onValueChange = { password = it },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password ),
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.primary ) }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Button(
                            onClick = {
                                if(username.isEmpty() || password.isEmpty()){
                                    Toast.makeText(context, "Identifiant requis", Toast.LENGTH_SHORT).show()
                                }else{
                                    simulateFirebaseLogin(username.trim() , password.trim() )
                                }
                            }
                        ) {
                            Text("SignIn")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalDivider(thickness = 2.dp)
                        Spacer(modifier = Modifier.height(42.dp))
                        Button(
                            onClick = {
                                println("Clique : S'inscrire")
                                navController.navigate("signup")
                            }
                        ) {
                            Text("SignUp")
                        }

                    }


                }

                }
            }

    }







