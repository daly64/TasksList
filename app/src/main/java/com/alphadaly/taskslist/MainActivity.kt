package com.alphadaly.taskslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.alphadaly.taskslist.application.navigation.SetupNavGraph
import com.alphadaly.taskslist.application.room.TaskViewModel
import com.alphadaly.taskslist.application.room.task.TaskDatabase


class MainActivity : ComponentActivity() {

     val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            "TasksDataBase.db"
        ).build()
    }


    private val viewModel by viewModels<TaskViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TaskViewModel(db.dao) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            HomePage()

            val navController = rememberNavController()
            SetupNavGraph(navController = navController,viewModel)
        }
    }
}

