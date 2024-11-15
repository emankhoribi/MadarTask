package com.example.myapplication.repository

import com.example.myapplication.db.InfoDataBase
import com.example.myapplication.db.data.User
import kotlinx.coroutines.flow.Flow

class RegisterRepository(private val db: InfoDataBase) {

    suspend fun insert(user: User): Long = db.userDao().insert(user)
}