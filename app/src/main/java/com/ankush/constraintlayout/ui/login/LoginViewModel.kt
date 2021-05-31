package com.ankush.constraintlayout.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankush.constraintlayout.model.LoginResponse
import com.ankush.constraintlayout.repository.LoginRepository

class LoginViewModel:ViewModel() {
    var serviceLiveData = MutableLiveData<LoginResponse>()
    fun getUser(email:String,password:String):LiveData<LoginResponse>{
        serviceLiveData = LoginRepository().getServiceCall(email,password)
        return  serviceLiveData
    }

}