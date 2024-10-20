package ru.normno.mytodo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.normno.mytodo.domain.model.ToDoTask

interface ToDoRepository {
    suspend fun upsert(toDoTask: ToDoTask)
    suspend fun delete(toDoTask: ToDoTask)
    fun selectAllToDoTask(): Flow<List<ToDoTask>>
    suspend fun selectToDoTask(id: Int): ToDoTask
}