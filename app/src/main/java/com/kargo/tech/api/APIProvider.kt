package com.kargo.tech.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIProvider {
    var api: IApi? = null

    @Synchronized
    fun getApiInterface(): IApi? {
        if (api == null) {
            val interceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()

            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
            okHttpClient.readTimeout(60, TimeUnit.SECONDS)
            okHttpClient.writeTimeout(60, TimeUnit.SECONDS)

            val mRetrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://5cac1d41c85e05001452eef0.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
            api = mRetrofit.create(IApi::class.java)
        }
        return api
    }

}