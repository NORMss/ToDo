package ru.normno.mytodo.domain.usecases.todousecases

import kotlinx.coroutines.flow.Flow
import ru.normno.mytodo.domain.model.ToDoTask
import ru.normno.mytodo.domain.repository.ToDoRepository

class SelectAllToDo(
    private val toDoRepository: ToDoRepository,
) {
    operator fun invoke(): Flow<List<ToDoTask>> {
        return toDoRepository.selectAllToDoTask()
    }
}