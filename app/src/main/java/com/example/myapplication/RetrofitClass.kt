package com.example.myapplication

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass {
   private val r=Retrofit.Builder()
        .baseUrl("http://192.168.3.14:8081/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
   private val apiInterface=r.create(ApiInterface::class.java)
    fun loginFunction(emailEditText:String,emailEditText1: String):Int{
        var i=0
        val call: Call<Void> = apiInterface.sendData(emailEditText,emailEditText1)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                i=response.code()
                if(response.isSuccessful){

                    Log.e("LoginActivity", "Login successfully$response")
                }else{
                    Log.e("LoginActivity", "Login Failed:$response")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("LoginActivity", "on failure" + t.message)
            }

        })
        return i
    }

    fun registerFunction(name:String,email:String,password:String,conPassword:String):Int{
        var i=0
        val call: Call<Void> = apiInterface.userDetails("Register",name, email, password, conPassword)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                i=response.code()
                Log.d("MainActivity","$i  $response")
                if (response.isSuccessful) {
                    Log.e("MainActivity", "registered  $response")

                } else {
                    Log.e("MainActivity", "not registered Status code:$response")
                }
            }
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("MainActivity", "on failure" + t.message)
            }

        })
        Log.d("iiii","$i")
        return i
    }
}