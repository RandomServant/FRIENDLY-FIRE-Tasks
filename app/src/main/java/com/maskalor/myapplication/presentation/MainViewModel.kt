package com.maskalor.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maskalor.myapplication.di.Dependencies
import com.maskalor.myapplication.domain.models.TaskList
import com.maskalor.myapplication.domain.usecase.AddTaskListUseCase
import com.maskalor.myapplication.domain.usecase.GetAllTaskListUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val taskLists = MutableLiveData<List<TaskList>>()

    private val taskListRepository = Dependencies.taskListRepository

    private val addTaskListUseCase = AddTaskListUseCase(taskListRepository)
    private val getAllTaskListUseCase = GetAllTaskListUseCase(taskListRepository)

    fun addTaskList(name: String) {
        viewModelScope.launch {
            addTaskListUseCase.execute(name)
        }
        getAllTAskList()
    }

    fun getAllTAskList() {
        viewModelScope.launch {
            taskLists.postValue(getAllTaskListUseCase.execute())
        }
    }
}