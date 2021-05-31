package com.ankush.constraintlayout.ui.Dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankush.constraintlayout.model.FoodResponse
import com.ankush.constraintlayout.repository.FoodRepository

class FoodViewModel: ViewModel() {

    var serviceLiveData = MutableLiveData<FoodResponse>()
    fun getFood(token:String):MutableLiveData<FoodResponse>{
        serviceLiveData = FoodRepository().getServiceApiCall(token)
        return serviceLiveData
    }
}