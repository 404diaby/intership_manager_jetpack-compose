package com.diaby404.intership_manager_jetpack_compose

import android.view.Display
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class Login {



    @Composable
    fun LoginScreen(){
        var username by remember { muta}
    }

     @Preview
     @Composable
     fun DisplayLoginPreview(){
         LoginScreen()
     }

}