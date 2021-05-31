package com.ankush.constraintlayout.model


import com.google.gson.annotations.SerializedName

data class FoodResponseItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("foodType")
    val foodType: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("vendorId")
    val vendorId: String
)