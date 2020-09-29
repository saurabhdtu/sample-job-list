package com.kargo.tech.api

class JobAPI private constructor() {
    val apiService: IApi? = APIProvider.getApiInterface()

    suspend fun getJobCards() {

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