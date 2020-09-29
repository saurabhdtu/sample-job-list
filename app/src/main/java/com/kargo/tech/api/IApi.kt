package com.kargo.tech.api

import com.kargo.tech.models.KargoJob
import retrofit2.Call
import retrofit2.http.GET

interface IApi {

    @GET("jobs")
    fun getJobCards(): Call<ArrayList<KargoJob>>

}