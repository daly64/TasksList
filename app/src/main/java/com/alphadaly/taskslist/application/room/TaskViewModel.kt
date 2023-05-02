package com.alphadaly.taskslist.application.room


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphadaly.taskslist.application.room.task.Task
import com.alphadaly.taskslist.application.room.task.TaskDAO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskViewModel(private val dao: TaskDAO) : ViewModel() {


    private var _tasks = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private var _state = MutableStateFlow(TaskState())

    var state = combine(_state, _tasks) { state, tasks ->
        state.copy(tasks = tasks)
    }
        .stateIn(viewModelScope, SharingStarted.Eagerly, TaskState())


    fun onEvent(event: TaskEvent) {
        when (event) {
            is TaskEvent.SaveTask -> {

                val text = state.value.text
                val done = state.value.done
                if (text.isNotBlank()) {

                    val task = Task(text = text, done = done)
                    viewModelScope.launch {
                        dao.insertTask(task)
                    }
                    _state.update { it.copy(isDeletingTask = false, text = "", done = false) }


                }
            }


            is TaskEvent.DeleteTask -> {
                viewModelScope.launch { dao.deleteTask(event.task) }
            }

            TaskEvent.ShowDialog -> _state.update { it.copy(isDeletingTask = true) }
            TaskEvent.HideDialog -> _state.update { it.copy(isDeletingTask = false) }
            is TaskEvent.SetDone -> {
                _state.update { it.copy(done = event.done) }
            }

            is TaskEvent.SetText -> {
                _state.update { it.copy(text = event.text) }
            }

            TaskEvent.DeleteAll -> {
                viewModelScope.launch { dao.deleteAll() }
            }

            is TaskEvent.CreateTask -> {
                if (event.task.text.isNotBlank()) {

                    viewModelScope.launch {
                        dao.insertTask(event.task)
                    }
                    _state.update { it.copy(isDeletingTask = false, text = "", done = false) }


                }
            }

            is TaskEvent.UpdateTask -> {
                if (event.task.text.isNotBlank()) {

                    viewModelScope.launch {
                        dao.updateTask(event.task)
                    }
                    _state.update {
                        it.copy(
                            isDeletingTask = false,
                            text = event.task.text,
                            done = event.task.done
                        )
                    }


                }
            }
        }

    }
}

