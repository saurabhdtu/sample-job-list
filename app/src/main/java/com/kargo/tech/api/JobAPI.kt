package com.kargo.tech.api

import com.kargo.tech.models.KargoJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response

class JobAPI private constructor() {
    val apiService: IApi? = APIProvider.getApiInterface()

    suspend fun getJobCards():Any? {
        if (apiService != null) {
            return ApiRequestWrapper.executeCall(apiService.getJobCards())
        }
        return null
    }

    companion object {
        var jobInstance: JobAPI? = null

        fun getInstance(): JobAPI? {
            if (jobInstance == null)
                jobInstance = JobAPI()
            return jobInstance
        }
    }
}