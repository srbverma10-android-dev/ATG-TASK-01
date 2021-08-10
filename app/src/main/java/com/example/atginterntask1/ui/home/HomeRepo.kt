package com.example.atginterntask1.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.atginterntask1.data.RetroService
import com.example.atginterntask1.pojo.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeRepo @Inject constructor(private val retroService : RetroService){
    private var apiResponse = MutableLiveData<Item>()
    fun getPhotosFromAPI():MutableLiveData<Item>{
        retroService.getDataFromAPI().enqueue(object : Callback<Item>{
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: response is successful")
                    apiResponse.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<Item>, t: Throwable) {
                Log.d("TAG", "onFailure: on Failure in getDataFromAPI t : ${t.message}")
            }
        })
        return apiResponse
    }

}






