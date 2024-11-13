package com.example.myapplication.di.module

import android.app.Application
import androidx.room.Room
import com.example.myapplication.db.InfoDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, InfoDataBase::class.java, "info.db").build()
}