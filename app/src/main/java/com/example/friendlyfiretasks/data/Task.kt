package com.example.friendlyfiretasks.data

data class Task(
    var name: String,
    var description: String,
    var isFavourite: Boolean = false,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
