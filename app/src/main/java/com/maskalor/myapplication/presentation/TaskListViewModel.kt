package com.maskalor.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maskalor.myapplication.di.Dependencies
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.usecase.AddTaskListUseCase
import com.maskalor.myapplication.domain.usecase.ChangeFavoriteState
import com.maskalor.myapplication.domain.usecase.GetAllTaskListUseCase
import kotlinx.coroutines.launch

class TaskListViewModel : ViewModel() {

    val list = MutableLiveData<List<Task>>()

    private val taskRepository = Dependencies.taskRepository
    private val changeFavoriteState = ChangeFavoriteState(Dependencies.taskRepository)

    fun getTasksFromTaskList(id: Int) {
        viewModelScope.launch {
            list.postValue(taskRepository.getTasksFromTaskList(id))
        }
    }

    fun getFavoriteTasksFromTaskList() {
        viewModelScope.launch {
            list.postValue(taskRepository.getFavoriteTasksFromTaskList())
        }
    }

    fun changeFavoriteState(task: Task) {
        viewModelScope.launch {
            changeFavoriteState.execute(task)
        }
    }
}