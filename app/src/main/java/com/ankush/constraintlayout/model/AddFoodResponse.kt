package com.ankush.constraintlayout.model


import com.google.gson.annotations.SerializedName

data class AddFoodResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("desccrioption")
    val desccrioption: String,
    @SerializedName("foodType")
    val foodType: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("readyTime")
    val readyTime: Int
)