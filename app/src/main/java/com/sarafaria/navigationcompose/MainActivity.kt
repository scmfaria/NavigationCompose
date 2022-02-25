package com.sarafaria.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarafaria.navigationcompose.screens.DetailsScreen
import com.sarafaria.navigationcompose.screens.ListScreen
import com.sarafaria.navigationcompose.screens.MainScreen
import com.sarafaria.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComposeTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(navController, this@MainActivity)
                    }

                    composable("list") {
                        ListScreen(navController)
                    }

                    composable("details/{name}") { backStackEntry ->
                        DetailsScreen(
                            navController,
                            backStackEntry.arguments?.getString("name") ?: ""
                        )
                    }
                }
            }
        }
    }

}