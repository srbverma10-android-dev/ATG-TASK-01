package com.example.atginterntask1.di

import com.example.atginterntask1.data.RetroService
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

    private const val BASE_URL = "https://api.flickr.com/services/rest/"
    @Singleton
    @Provides
    fun getRetrofitService(retrofit:Retrofit) : RetroService {
        return retrofit.create(RetroService::class.java)
    }
    @Singleton
    @Provides
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}