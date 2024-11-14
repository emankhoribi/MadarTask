package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.data.User
import com.example.myapplication.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(val registerRepo: RegisterRepository): ViewModel() {

    private val id = 0
    private val _userFLow : MutableStateFlow<Long?> = MutableStateFlow(null)
    val userFlow = _userFLow

    fun addUser(name: String,  age: Int,jobTitle: String, gender: String ){
            val user = User(id, name, age, jobTitle, gender)
        viewModelScope.launch {
            try {
                _userFLow.value = registerRepo.insert(user)
            }catch (e: Exception){
                Log.e("RegisterViewModel", e.message.toString())
            }
        }
    }
}