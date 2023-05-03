package com.alphadaly.taskslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alphadaly.taskslist.application.Global
import com.alphadaly.taskslist.application.views.pages.HomePage


class MainActivity : ComponentActivity() {

    /*    val db by lazy {
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
                        return TaskViewModel(db.taskDao) as T
                    }
                }
            }
        )*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Global.context = applicationContext

        setContent {
            HomePage()
        }
    }
}

