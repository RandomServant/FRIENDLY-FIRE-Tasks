package com.example.friendlyfiretasks.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendlyfiretasks.data.RepositoryImplementation
import com.example.friendlyfiretasks.data.Task
import com.example.friendlyfiretasks.domain.useCases.AddTaskUseCase
import com.example.friendlyfiretasks.domain.useCases.ChangeFavouriteStateUseCase
import com.example.friendlyfiretasks.domain.useCases.GetAllTaskListUseCase
import com.example.friendlyfiretasks.domain.useCases.RemoveTaskUseCase

class TaskActivityViewModel : ViewModel(){

    var taskList = MutableLiveData<List<Task>>()
    private val repository = RepositoryImplementation
    private val getAllTaskListUseCase = GetAllTaskListUseCase(repository)
    private val changeFavoriteState = ChangeFavouriteStateUseCase(repository)
    private val addTaskUseCase = AddTaskUseCase(repository)
    private val removeTaskUseCase = RemoveTaskUseCase(repository)

    fun getAllTaskList() {
        taskList.value = getAllTaskListUseCase.execute()
    }

    fun addTaskToList(title: String, description: String, date: String) {
        addTaskUseCase.execute(Task(title, description, date))
        getAllTaskList()
    }

    fun removeTaskToList(task: Task) {
        removeTaskUseCase.execute(task)
        getAllTaskList()
    }

    fun changeFavoriteState(task: Task) {
        changeFavoriteState.execute(task)
    }
}