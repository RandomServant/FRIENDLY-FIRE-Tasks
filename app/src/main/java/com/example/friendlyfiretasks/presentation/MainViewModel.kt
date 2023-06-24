package com.example.friendlyfiretasks.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendlyfiretasks.di.Dependencies
import com.example.friendlyfiretasks.domain.models.TaskList
import com.example.friendlyfiretasks.domain.useCases.AddTaskListUseCase
import com.example.friendlyfiretasks.domain.useCases.GetAllTaskListUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val taskLists = MutableLiveData<List<TaskList>>()

    private val taskListRepository = Dependencies.taskListRepository

    private val addTaskListUseCase = AddTaskListUseCase(taskListRepository)
    private val getAllTaskListUseCase = GetAllTaskListUseCase(taskListRepository)

    fun addTaskList(name: String) {
        val viewModelScope = null
        viewModelScope?.launch {
            addTaskListUseCase.execute(name)
        }
        getAllTAskList()
    }

    fun getAllTAskList() {
        val viewModelScope = null
        viewModelScope?.launch {
            taskLists.postValue(getAllTaskListUseCase.execute())
        }
    }
}