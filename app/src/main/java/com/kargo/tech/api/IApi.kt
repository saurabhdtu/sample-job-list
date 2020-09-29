package com.kargo.tech.api

import com.kargo.tech.models.entities.KargoJob
import com.kargo.tech.models.response.JobResponse
import retrofit2.Call
import retrofit2.http.GET

interface IApi {

    @GET("jobs")
    fun getJobCards(): Call<JobResponse>

}