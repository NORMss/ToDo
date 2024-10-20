package ru.normno.mytodo.presentation.task

import androidx.lifecycle.ViewModel
import ru.normno.mytodo.domain.usecases.todousecases.ToDoUseCases

class TaskViewModel(
    private val toDoUseCases: ToDoUseCases,
) : ViewModel() {
}