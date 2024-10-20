package ru.normno.mytodo.domain.usecases.todousecases

import ru.normno.mytodo.domain.model.ToDoTask
import ru.normno.mytodo.domain.repository.ToDoRepository

class UpsertToDo(
    private val toDoRepository: ToDoRepository,
) {
    suspend operator fun invoke(toDoTask: ToDoTask) {
        toDoRepository.upsert(toDoTask)
    }
}