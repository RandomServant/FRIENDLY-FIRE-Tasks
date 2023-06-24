package com.example.friendlyfiretasks.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendlyfiretasks.di.Dependencies
import com.example.friendlyfiretasks.domain.models.Task
import kotlinx.coroutines.launch

class TaskListViewModel : ViewModel() {

    val list = MutableLiveData<List<Task>>()

    private val taskRepository = Dependencies.taskRepository



    fun getTasksFromTaskList(id: Int) {
        val viewModelScope = null
        viewModelScope?.launch {
            list.postValue(taskRepository.getTasksFromList(id))
        }
    }
}