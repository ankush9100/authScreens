package com.ankush.constraintlayout.repository

import androidx.lifecycle.MutableLiveData
import com.ankush.constraintlayout.api.RetrofitInstance
import com.ankush.constraintlayout.model.CreateVendorResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateVendorRepository {
    val serviceSetterGetter = MutableLiveData<CreateVendorResponse>()
    fun getServiceCallApi(name:String,ownerName:String,foodType:List<String>,pinCode:String,address:String,
    phone:String,email:String,password:String,serviceAvailable:Boolean,rating:Int,coverImage:List<String>):MutableLiveData<CreateVendorResponse>{
        val call = RetrofitInstance().api.createVendor(name,ownerName,foodType,pinCode,address,phone,email,
        password,serviceAvailable,rating,coverImage)
        call.enqueue(object: Callback<CreateVendorResponse>{
            override fun onResponse(
                call: Call<CreateVendorResponse>,
                response: Response<CreateVendorResponse>
            ) {
                serviceSetterGetter.value = response.body()
            }

            override fun onFailure(call: Call<CreateVendorResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return serviceSetterGetter
    }
}