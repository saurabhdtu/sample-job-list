package com.kargo.tech.ui.jobcard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kargo.tech.api.Error
import com.kargo.tech.api.JobAPI
import com.kargo.tech.models.entities.KargoJob
import com.kargo.tech.models.response.JobResponse
import kotlinx.coroutines.*

class JobViewModel : ViewModel() {
    val list = MutableLiveData<ArrayList<KargoJob>>()
    val sortPrice = MutableLiveData<Int>()
    val sortDate = MutableLiveData<Int>()
    val progress = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    init {
        sortPrice.value = 0
        sortDate.value = 0
        progress.value = false
    }

    fun getList() {
        progress.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val response = async { JobAPI.getInstance()?.getJobCards() }.await()
            if(response is JobResponse){
                withContext(Dispatchers.Main){
                    progress.value = false
                    list.value= response.jobs
                }
            }else if(response is Error){
                withContext(Dispatchers.Main) {
                    progress.value = false
                    error.value = response.responseMessage
                }
            }
        }
    }
}