package com.example.atginterntask1.data

import com.example.atginterntask1.pojo.Item
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {
    @GET("?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
    fun getDataFromAPI() : Call<Item>
}