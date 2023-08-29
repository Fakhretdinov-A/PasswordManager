package com.example.passwordmanager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = [Entity::class], version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        fun getDB(context: Context): MainDB { // Создание бд или при её наличии выдаёт её инстанцию
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "accounts.db"
            ).build()
        }
    }
}