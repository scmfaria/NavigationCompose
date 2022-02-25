package com.sarafaria.navigationcompose.screens

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sarafaria.navigationcompose.ui.theme.Purple200
import com.sarafaria.navigationcompose.ui.theme.Purple500

@Composable
fun MainScreen(navController: NavHostController, activity: Activity) {
    // receive returned data of ListScreen
    val firstElement = navController.currentBackStackEntry?.savedStateHandle?.
            getLiveData<String>("firstElement")?.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Main Screen") },
                backgroundColor = Purple500,
                actions = {
                    IconButton(onClick = { activity.finish() }) {
                        Icon(Icons.Default.ExitToApp,"")
                    }
                }
            )
    }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "This is the first and Main Screen",
                modifier = Modifier.padding(10.dp),
                style = TextStyle(color = Purple200, fontSize = 18.sp)
            )
            Button(
                onClick = {
                    navController.navigate("list")
                },
                modifier = Modifier.padding(3.dp)) {
                Text("Open List Names")
            }
            // show data returned
            firstElement?.value?.let {
                Text(
                    text = "First element of list: $it",
                    modifier = Modifier.padding(10.dp))
            }
        }
    }
}
