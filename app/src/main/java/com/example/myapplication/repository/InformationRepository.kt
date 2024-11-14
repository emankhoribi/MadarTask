package com.example.myapplication.repository

import com.example.myapplication.db.InfoDataBase
import com.example.myapplication.db.data.User
import kotlinx.coroutines.flow.Flow

class InformationRepository(private val db: InfoDataBase) {

    fun getUser(): Flow<User> = db.userDao().getUser()
}