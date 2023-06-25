package com.maskalor.myapplication.domain.models

data class Task(
    var name: String,
    var description: String,
    var date: String,
    val taskListId: Int,
    var isFavorite: Boolean = false,
    val id: Int = UNDEFINED_ID

) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}