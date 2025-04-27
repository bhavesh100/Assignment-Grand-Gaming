package com.bhavesh.grandgamingassignment.di

import com.bhavesh.grandgamingassignment.data.remote.network.CatApi
import com.bhavesh.grandgamingassignment.data.repository.CatRepositoryImpl
import com.bhavesh.grandgamingassignment.domain.repository.CatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCatApiService(retrofit: Retrofit): CatApi =
        retrofit.create(CatApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(
        api: CatApi
    ): CatRepository = CatRepositoryImpl(api)
}