package com.example.myapplication.repository

import com.example.myapplication.db.InfoDataBase
import com.example.myapplication.db.data.User

class RegisterRepository(private val db: InfoDataBase) {

    suspend fun insert(user: User){
        db.userDao().insert(user)
    }
}