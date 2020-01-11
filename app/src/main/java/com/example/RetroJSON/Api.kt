package com.example.RetroJSON

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

const val BASE_URL = "http://thetakotlin.azurewebsites.net/Home/"
interface Api {

    @GET("AllStudentsList")
    fun getData() : Call<List<Nameage>>

    companion object{
        operator fun invoke() : Api{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)

        }
    }
}