package com.alphadaly.taskslist.application.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphadaly.taskslist.application.data.Task
import com.alphadaly.taskslist.application.data.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class TasksListViewModel(taskRepository: TaskRepository) : ViewModel() {

    val tasksListUiState: StateFlow<TasksListUiState> =
        taskRepository.getAllTasks().map { TasksListUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = TasksListUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }


}

data class TasksListUiState(val tasksList: List<Task> = listOf())