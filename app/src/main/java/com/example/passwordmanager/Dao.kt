package com.example.passwordmanager

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(entity: Entity)

    @Query("SELECT * FROM items")
    fun getALlItems(): Flow<List<Entity>>

    @Query("DELETE FROM items")
    fun delete()

    @Query("DELETE FROM items WHERE id= :id")
    fun deletebyID(id: Int)
}