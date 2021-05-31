package com.ankush.constraintlayout.api

import com.ankush.constraintlayout.model.AddFoodResponse
import com.ankush.constraintlayout.model.CreateVendorResponse
import com.ankush.constraintlayout.model.FoodResponse
import com.ankush.constraintlayout.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface VendorApi {

    @FormUrlEncoded
    @POST("/vendor/login")
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<LoginResponse>


    @FormUrlEncoded
    @POST("/admin/vendor")
    fun createVendor(
        @Field("name") name:String,
        @Field("ownerName") ownerName:String,
        @Field("foodType") FoodType:List<String>,
        @Field("pinCode") pinCode:String,
        @Field("address") address:String,
        @Field("phone") phone:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("serviceAvailable") serviceAvailable:Boolean,
        @Field("rating") rating:Int,
        @Field("CoverImage") CoverImage:List<String>
    ):Call<CreateVendorResponse>


    @FormUrlEncoded
    @POST("/vendor/food")
    fun AddFood(
        @Field("name") name:String,
        @Field("description") description:String,
        @Field("category") category:String,
        @Field("foodType") foodType:String,
        @Field("price") price:Int,
        @Field("readyTime") readyTime:Int,
        @Field("images") images:ArrayList<String>,
        @Header("Authorization") token: String
    ):Call<AddFoodResponse>

    @GET("/vendor/food")
    fun getFood(@Header("Authorization") token: String): Call<FoodResponse>



}