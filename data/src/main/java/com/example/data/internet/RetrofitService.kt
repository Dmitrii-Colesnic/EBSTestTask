package com.example.data.internet

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("./products")
    fun getProducts(): Call<Product>

}