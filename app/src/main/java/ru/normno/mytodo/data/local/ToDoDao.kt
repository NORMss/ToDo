package ru.normno.mytodo.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.normno.mytodo.domain.model.ToDoTask

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(toDoTask: ToDoTask)

    @Delete
    suspend fun delete(toDoTask: ToDoTask)

    @Query("SELECT * FROM to_do_task")
    fun selectAllToDoTask(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM to_do_task WHERE id=:id")
    suspend fun selectToDoTask(id: Int): ToDoTask
}