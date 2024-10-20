package ru.normno.mytodo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.normno.mytodo.domain.model.ToDoTask


@Database(
    entities = [ToDoTask::class], version = 1,
)
abstract class ToDoDatabase : RoomDatabase() {
    abstract val toDoDao: ToDoDao
}