package com.example.atginterntask1.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atginterntask1.pojo.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepo: HomeRepo) : ViewModel() {

    private var apiResponse : MutableLiveData<Item> = MutableLiveData()

    fun getDataFromAPI():MutableLiveData<Item>{
        apiResponse = homeRepo.getPhotosFromAPI()
        return apiResponse
    }

}