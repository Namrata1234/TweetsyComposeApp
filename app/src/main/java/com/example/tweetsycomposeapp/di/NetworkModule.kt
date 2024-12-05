package com.example.tweetsycomposeapp.di

import com.example.tweetsycomposeapp.api.TweetsyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesTweetsAPI(retrofit: Retrofit):TweetsyAPI{
        return retrofit.create(TweetsyAPI::class.java)
    }
}