package com.example.passwordmanager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "items")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Service")
    var service: String,
    @ColumnInfo(name = "EmailOrLogin")
    var log: String,
    @ColumnInfo(name = "Password")
    var password: String,
)
