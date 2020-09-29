package com.kargo.tech.models.entities

object JobUtils {
    fun sortByPrice(jobList:ArrayList<KargoJob>,order:Int?){
        if (order == 1) {
            jobList.sortBy { it.price }
        } else if (order == -1) {
            jobList.sortByDescending { it.price }
        }
    }

    fun sortByTime(jobList:ArrayList<KargoJob>,order:Int?){
        if (order == 1) {
            jobList.sortBy { it.date }
        } else if (order == -1) {
            jobList.sortByDescending { it.date }
        }
    }
}