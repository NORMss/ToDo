package ru.normno.mytodo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "to_do_task",
)
data class ToDoTask(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val favorite: Boolean,
    val completed: Boolean,
)
