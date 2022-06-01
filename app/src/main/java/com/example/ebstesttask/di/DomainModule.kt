package com.example.ebstesttask.di

import com.example.domain.ProductsRepository
import com.example.domain.usecase.AddProductToFavoriteUseCase
import com.example.domain.usecase.GetFavoritesProductsListUseCase
import com.example.domain.usecase.GetProductInfoUseCase
import com.example.domain.usecase.GetProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providerGetProductListUseCase(productsRepository: ProductsRepository): GetProductListUseCase {
        return GetProductListUseCase(productsRepository = productsRepository)
    }

    @Provides
    fun providerGetProductInfoUseCase(productsRepository: ProductsRepository): GetProductInfoUseCase {
        return GetProductInfoUseCase(productsRepository = productsRepository)
    }

    @Provides
    fun providerGetFavoritesProductsListUseCase(productsRepository: ProductsRepository): GetFavoritesProductsListUseCase {
        return GetFavoritesProductsListUseCase(productsRepository = productsRepository)
    }

    @Provides
    fun providerAddProductToFavoriteUseCase(productsRepository: ProductsRepository): AddProductToFavoriteUseCase {
        return AddProductToFavoriteUseCase(productsRepository = productsRepository)
    }
}