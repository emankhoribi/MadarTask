package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.db.data.User

@Database(entities = [User::class], version = 1)
abstract class InfoDataBase: RoomDatabase(){
    abstract fun userDao(): UserDao
}