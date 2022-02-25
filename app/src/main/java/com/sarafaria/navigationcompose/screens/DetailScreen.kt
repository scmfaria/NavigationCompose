package com.sarafaria.navigationcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sarafaria.navigationcompose.ui.theme.Purple500

@Composable
fun DetailsScreen(navController: NavHostController, name: String) {

    val idUser = navController.previousBackStackEntry?.arguments?.getInt("idUser")
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Screen") },
                backgroundColor = Purple500,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack,"")
                    }
                }
            )
        }) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Name selected: $name",
                modifier = Modifier.padding(top = 15.dp)
            )
            Divider(Modifier.padding(5.dp))
            Text(
                text = "ID user pass by parameter Bundle: $idUser",
                modifier = Modifier.padding(top = 10.dp)
            )
            Divider(Modifier.padding(5.dp))
            Text(
                text = "Go to direct Main Screen:",
                modifier = Modifier.padding(top = 10.dp, bottom = 5.dp)
            )
            Button(onClick = {
                navController.navigate("main") {
                    popUpTo("main") {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            }) {
                Icon(Icons.Default.ExitToApp,"")
                Text("Click Here to close screen")
            }
        }
    }
}