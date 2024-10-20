package ru.normno.mytodo.domain.usecases.todousecases

import ru.normno.mytodo.domain.model.ToDoTask
import ru.normno.mytodo.domain.repository.ToDoRepository

class DeleteToDo(
    private val toDoRepository: ToDoRepository,
) {
    suspend operator fun invoke(toDoTask: ToDoTask) {
        toDoRepository.delete(toDoTask)
    }
}