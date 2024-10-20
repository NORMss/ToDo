package ru.normno.mytodo.presentation.home

import androidx.lifecycle.ViewModel
import ru.normno.mytodo.domain.usecases.todousecases.ToDoUseCases

class HomeViewModel(
    private val toDoUseCases: ToDoUseCases,
) : ViewModel() {

}