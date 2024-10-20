package ru.normno.mytodo.domain.usecases.todousecases

data class ToDoUseCases(
    val upsertToDo: UpsertToDo,
    val deleteToDo: DeleteToDo,
    val selectAllToDo: SelectAllToDo,
    val selectToDo: SelectToDo,
)