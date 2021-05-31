package com.ankush.constraintlayout.repository

import androidx.lifecycle.MutableLiveData
import com.ankush.constraintlayout.api.RetrofitInstance
import com.ankush.constraintlayout.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginRepository {
    val serviceSetterGetter = MutableLiveData<LoginResponse>()

    fun getServiceCall(email:String,password:String):MutableLiveData<LoginResponse>{
        val call = RetrofitInstance().api.login(email,password)
        call.enqueue(object :Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val data = response.body()
                serviceSetterGetter.value = data
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }

        })
        return serviceSetterGetter

    }


}