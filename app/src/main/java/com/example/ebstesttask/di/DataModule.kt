package com.example.ebstesttask.di

import com.example.data.ProductsRepositoryImpl
import com.example.domain.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRevealCourtPlaceCallbacks(): RevealCourtPlaceCallbacks {
        return IMPL()
    }
    @Provides
    @Singleton
    fun provideProductRepository(revealCourtPlaceCallbacks: RevealCourtPlaceCallbacks): ProductsRepository {
        return ProductsRepositoryImpl(revealCourtPlaceCallbacks = revealCourtPlaceCallbacks)
    }

}