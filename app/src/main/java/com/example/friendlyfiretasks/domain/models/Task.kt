package com.example.friendlyfiretasks.domain.models

data class Task(
    var name: String,
    var description: String,
    val taskListId: Int,
    var date: String,
    var isFavourite: Boolean = false,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
