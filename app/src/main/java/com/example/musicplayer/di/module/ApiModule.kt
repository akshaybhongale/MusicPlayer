package com.example.musicplayer.di.module


import com.example.musicplayer.api.BASE_URL
import com.example.musicplayer.api.IApi
import com.example.musicplayer.utils.API_TIME_OUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApiModule {

    @Provides
    fun provideBaseURL(): String {
        return BASE_URL
    }


    @Provides
    fun provideApiService(baseURL: String, okHttpClient: OkHttpClient): IApi {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitBuilder.create(IApi::class.java)
    }

    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(API_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(API_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(API_TIME_OUT, TimeUnit.SECONDS)
            .build()
    }


}