package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("/ApiDemo1/FirstApi1")
    fun userDetails(@Field("key_action") action:String,
                    @Field("Key_name") name: String?  ,
                    @Field("Key_email") email: String? ,
                    @Field("Key_password") password: String? ,
                    @Field("key_conPassword") confirmPassword: String?):Call<Void>
    @FormUrlEncoded
    @POST("/ApiDemo2/SecondApi")
    fun sendData(@Field("Key_Email") email:String,@Field("Key_Password")password: String):Call<Void>
}