package ru.normno.mytodo.di

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.normno.mytodo.data.local.ToDoDao
import ru.normno.mytodo.data.local.ToDoDatabase
import ru.normno.mytodo.data.repository.ToDoRepositoryImpl
import ru.normno.mytodo.domain.repository.ToDoRepository
import ru.normno.mytodo.domain.usecases.todousecases.DeleteToDo
import ru.normno.mytodo.domain.usecases.todousecases.SelectAllToDo
import ru.normno.mytodo.domain.usecases.todousecases.SelectToDo
import ru.normno.mytodo.domain.usecases.todousecases.ToDoUseCases
import ru.normno.mytodo.domain.usecases.todousecases.UpsertToDo
import ru.normno.mytodo.presentation.home.HomeViewModel
import ru.normno.mytodo.presentation.task.TaskViewModel
import ru.normno.mytodo.util.Constants.TO_DO_DATABASE_NAME

object AppModule {
    fun initializeKoin(application: Application) {
        startKoin {
            androidContext(application)
            modules(
                dataBaseModule,
                toDoRepositoryModule,
                toDoUseCasesModule,
                viewModelModule,
            )
        }
    }

    private val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
        viewModel { TaskViewModel(get()) }
    }

    private val dataBaseModule = module {
        single { provideDatabase(get()) }
        single { provideDao(get()) }
    }

    private val toDoRepositoryModule = module {
        factory<ToDoRepository> {
            ToDoRepositoryImpl(get())
        }
    }

    private val toDoUseCasesModule = module {
        single<ToDoUseCases> {
            ToDoUseCases(
                upsertToDo = UpsertToDo(get()),
                deleteToDo = DeleteToDo(get()),
                selectAllToDo = SelectAllToDo(get()),
                selectToDo = SelectToDo(get()),
            )
        }
    }

    private fun provideDatabase(application: Application): ToDoDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = ToDoDatabase::class.java,
            name = TO_DO_DATABASE_NAME,
        ).fallbackToDestructiveMigration(false).build()
    }

    private fun provideDao(toDoDatabase: ToDoDatabase): ToDoDao = toDoDatabase.toDoDao
}