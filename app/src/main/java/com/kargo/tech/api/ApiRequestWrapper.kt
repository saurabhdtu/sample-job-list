package com.kargo.tech.api

import retrofit2.Call

object ApiRequestWrapper {
    fun <T>executeCall(call:Call<T>): Any {
        val response = call.execute()
        return if(response.isSuccessful && response.body()!=null){
            response.body()!!
        }else if(response.errorBody()!=null){
            Error(response.code(), response.message())
        }else{
            Error(500,"Some error occurred")
        }
    }
}