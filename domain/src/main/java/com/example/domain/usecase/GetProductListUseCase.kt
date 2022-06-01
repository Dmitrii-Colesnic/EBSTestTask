package com.example.domain.usecase

import com.example.domain.ProductsRepository
import com.example.domain.models.Phone

class GetProductListUseCase(private val productsRepository: ProductsRepository) {

    fun execute(): List<Phone> {

        return productsRepository.getProductList()

    }

}