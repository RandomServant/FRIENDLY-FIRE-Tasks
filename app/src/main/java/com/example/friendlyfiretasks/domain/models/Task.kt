package com.example.friendlyfiretasks.domain.models

data class Task(
    var name: String,
    var description: String,
    var date: String,
    var isFavourite: Boolean = false,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
