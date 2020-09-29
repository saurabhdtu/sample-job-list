package com.kargo.tech.api

class JobAPI private constructor() {
    val apiService: IApi? = APIProvider.getApiInterface()

    suspend fun getJobCards(): Any? {
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