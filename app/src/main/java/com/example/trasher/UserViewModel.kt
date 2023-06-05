package com.example.trasher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

 class UserViewModel: ViewModel() {
    val user = MutableLiveData<User>()
}