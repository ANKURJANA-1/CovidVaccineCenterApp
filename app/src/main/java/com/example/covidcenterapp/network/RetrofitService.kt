package com.example.covidcenterapp.network

import com.example.covidcenterapp.core.ConstantAndKeywords
import com.example.covidcenterapp.model.Parent
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("appointment/sessions/public/findByPin/")
    fun getAppointmentList(
        @Query("pincode") pincode: String,
        @Query("date") date: String
    ): Call<Parent>


    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(ConstantAndKeywords.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}