package com.example.domain

import com.example.domain.models.Phone

interface ProductsRepository {

    fun getProductList() : List<Phone>

}