package ru.normno.mytodo.data.repository

import kotlinx.coroutines.flow.Flow
import ru.normno.mytodo.data.local.ToDoDao
import ru.normno.mytodo.domain.model.ToDoTask
import ru.normno.mytodo.domain.repository.ToDoRepository

class ToDoRepositoryImpl(
    private val toDoTaskDao: ToDoDao,
) : ToDoRepository {
    override suspend fun upsert(toDoTask: ToDoTask) {
        toDoTaskDao.upsert(toDoTask)
    }

    override suspend fun delete(toDoTask: ToDoTask) {
        toDoTaskDao.delete(toDoTask)
    }

    override fun selectAllToDoTask(): Flow<List<ToDoTask>> {
        return toDoTaskDao.selectAllToDoTask()
    }

    override suspend fun selectToDoTask(id: Int): ToDoTask {
        return toDoTaskDao.selectToDoTask(id)
    }
}