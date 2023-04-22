package com.alphadaly.taskslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.alphadaly.taskslist.application.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomePage()
            val navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}

