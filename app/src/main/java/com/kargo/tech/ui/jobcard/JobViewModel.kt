package com.kargo.tech.ui.jobcard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kargo.tech.models.KargoJob

class JobViewModel : ViewModel() {
    val list = MutableLiveData<ArrayList<KargoJob>>()
    val sortPrice = MutableLiveData<Int>()
    val sortDate = MutableLiveData<Int>()
    val progress = MutableLiveData<Boolean>()

    init {
        sortPrice.value = 0
        sortDate.value = 0
        progress.value = false
    }

    fun getList() {

    }
}