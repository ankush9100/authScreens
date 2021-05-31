package com.ankush.constraintlayout.model


import com.google.gson.annotations.SerializedName

data class CreateVendorResponse(
    @SerializedName("address")
    val address: String,
    @SerializedName("coverImage")
    val coverImage: List<Any>,
    @SerializedName("email")
    val email: String,
    @SerializedName("foodType")
    val foodType: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("ownerName")
    val ownerName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("pinCode")
    val pinCode: String,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("salt")
    val salt: String,
    @SerializedName("serviceAvailable")
    val serviceAvailable: String
)