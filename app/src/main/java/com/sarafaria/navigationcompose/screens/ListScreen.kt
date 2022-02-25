package com.sarafaria.navigationcompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sarafaria.navigationcompose.ui.theme.Purple500

@Composable
fun ListScreen(navController: NavHostController) {
    val idUser = 1234
    val names = listOf("Helena", "Luisa", "Sara", "Maria")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List Screen") },
                backgroundColor = Purple500,
                navigationIcon = {
                    IconButton(onClick = {
                        // return information to MainScreen
                        navController.previousBackStackEntry?.savedStateHandle?.set("firstElement", names[0])
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.ArrowBack,"")
                    }
                }
            )
        }) {
        LazyColumn {
            items(names) { name ->
                Text(name,
                    modifier = Modifier.padding(10.dp).clickable(
                        onClick = {
                            navController.currentBackStackEntry?.arguments?.putInt("idUser", idUser)
                            navController.navigate("details/$name")
                        }
                    )
                )
            }
        }
    }
}