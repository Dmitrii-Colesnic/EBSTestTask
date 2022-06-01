package com.example.data.internet

object Common {
    private val BASE_URL = "http://mobile-shop-api.hiring.devebs.net/"
    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}