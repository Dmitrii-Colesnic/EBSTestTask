package com.example.data

import android.util.Log
import com.example.data.internet.Common
import com.example.data.internet.Product
import com.example.domain.ProductsRepository
import com.example.domain.models.Phone
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRepositoryImpl(

    private val revealCourtPlaceCallbacks: RevealCourtPlaceCallbacks

) : ProductsRepository {

    override fun getProductList(): List<Phone> {

        lateinit var phones: List<Phone>
/*
        Common.retrofitService.getProducts()
            .enqueue(object : Callback<Product> {
                override fun onFailure(call: Call<Product>, t: Throwable) {
                    Log.e("AAA", "Convert json error")
                    Log.e("AAA", t.toString())
                }

                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    if (response.body() == null) {
                        Log.e("AAA", "jsonProduct is null")
                    } else {
                        phones = mapProductToPhone(response.body()!!)
                    }
                }
            })
*/
        revealCourtPlace(object : RevealCourtPlaceCallbacks {
            override fun onSuccess(jsonProducts: Product?): List<Phone> {
                if (jsonProducts == null) {
                    Log.e("AAA", "jsonProduct is null")
                }
                phones = mapProductToPhone(jsonProducts!!)
                return phones
            }

            override fun onError(throwable: Throwable) {
                Log.e("AAA", "Convert json error")
                Log.e("AAA", throwable.toString())
            }
        })

        return phones

    }

    private fun revealCourtPlace(callbacks: RevealCourtPlaceCallbacks) {

        Common.retrofitService.getProducts()
            .enqueue(object : Callback<Product> {
                override fun onFailure(call: Call<Product>, t: Throwable) {
                    callbacks.onError(t)
                }

                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    callbacks.onSuccess(response.body())
                }

            })

    }

    private fun mapProductToPhone(product: Product?): List<Phone> {
        lateinit var phones: MutableList<Phone>

        for (item in product!!.results){
            if(item.category.name == "Electronics"){
                phones.add(Phone(
                    id = item.id,
                    image = item.main_image,
                    name = item.name,
                    details = item.details,
                    price = item.price.toString(),
                    size = item.size,
                    colour = item.colour
                ))
            }
        }

        return phones
    }

    interface RevealCourtPlaceCallbacks {
        fun onSuccess(jsonProducts: Product?): List<Phone>
        fun onError(throwable: Throwable)
    }

}

