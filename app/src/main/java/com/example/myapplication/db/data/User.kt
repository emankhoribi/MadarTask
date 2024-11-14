package com.example.myapplication.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User (
    @PrimaryKey
    val id: Int,
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: String
)