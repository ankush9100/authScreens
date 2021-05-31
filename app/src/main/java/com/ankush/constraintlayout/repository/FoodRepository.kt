package com.ankush.constraintlayout.repository

import androidx.lifecycle.MutableLiveData
import com.ankush.constraintlayout.api.RetrofitInstance
import com.ankush.constraintlayout.model.FoodResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRepository {

    val serviceSetterGetter = MutableLiveData<FoodResponse>()

    fun getServiceApiCall(token:String):MutableLiveData<FoodResponse>{
        val call = RetrofitInstance().api.getFood(token)
        call.enqueue(object :Callback<FoodResponse>{
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
               serviceSetterGetter.value = response.body()
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return serviceSetterGetter
    }
}