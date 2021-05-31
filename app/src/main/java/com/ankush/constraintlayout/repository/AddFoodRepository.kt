package com.ankush.constraintlayout.repository

import android.accounts.AuthenticatorDescription
import androidx.lifecycle.MutableLiveData
import com.ankush.constraintlayout.api.RetrofitInstance
import com.ankush.constraintlayout.model.AddFoodResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFoodRepository {

    val serviceSetterGetter = MutableLiveData<AddFoodResponse>()

    fun getServiceCall(name:String,description: String,category:String,foodType:String,price:Int,readyTime:Int,images:ArrayList<String>,token:String):MutableLiveData<AddFoodResponse>{
        val call = RetrofitInstance().api.AddFood(name,description,category,foodType,price,readyTime,images,token)
        call.enqueue(object : Callback<AddFoodResponse> {
            override fun onResponse(call: Call<AddFoodResponse>, response: Response<AddFoodResponse>) {
                val data = response.body()
                serviceSetterGetter.value = data
            }

            override fun onFailure(call: Call<AddFoodResponse>, t: Throwable) {

            }

        })
        return serviceSetterGetter

    }
}