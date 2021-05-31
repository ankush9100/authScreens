package com.ankush.constraintlayout.ui.SignUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankush.constraintlayout.model.CreateVendorResponse
import com.ankush.constraintlayout.repository.CreateVendorRepository

class CreateVendorViewModel:ViewModel() {

    var serviceLiveData = MutableLiveData<CreateVendorResponse>()
    fun createVendor(name:String,ownerName:String,foodType:List<String>,pinCode:String,address:String,
                     phone:String,email:String,password:String,serviceAvailable:Boolean,rating:Int
                     ,coverImage:List<String>):MutableLiveData<CreateVendorResponse>{
        serviceLiveData = CreateVendorRepository().getServiceCallApi(name,ownerName,foodType,pinCode,address,
        phone,email,password,serviceAvailable,rating,coverImage)
        return serviceLiveData
    }

}