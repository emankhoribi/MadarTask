package com.example.myapplication.di.module

import com.example.myapplication.db.InfoDataBase
import com.example.myapplication.repository.RegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    fun provideRegisterRepo(infoDataBase: InfoDataBase): RegisterRepository = RegisterRepository(infoDataBase)
}