package com.ankush.constraintlayout.ui.Dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankush.constraintlayout.model.AddFoodResponse
import com.ankush.constraintlayout.repository.AddFoodRepository

class AddFoodViewModel:ViewModel() {

    var serviceLiveData = MutableLiveData<AddFoodResponse>()
    fun addNewFood(name:String,description: String,category:String,foodType:String,price:Int,readyTime:Int,
                   images:ArrayList<String>,token:String):MutableLiveData<AddFoodResponse>{
        serviceLiveData = AddFoodRepository().getServiceCall(name,description,category,foodType,price,readyTime,images,token)
        return  serviceLiveData

    }
}