package ru.normno.mytodo.domain.usecases.todousecases

import ru.normno.mytodo.domain.repository.ToDoRepository

class SelectToDo(
    private val toDoRepository: ToDoRepository,
) {
    suspend operator fun invoke(id:Int) {
        toDoRepository.selectToDoTask(id)
    }
}