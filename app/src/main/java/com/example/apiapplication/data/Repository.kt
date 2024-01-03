package com.example.apiapplication.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiapplication.data.remote.DogAPI
import java.lang.Exception

class Repository(private val api: DogAPI) {

    private val _images = MutableLiveData<List<String>>()
    val images: LiveData<List<String>>
        get() = _images


    suspend fun getImages(breed: String) {
        try {
            _images.value = api.retrofitService.getImages(breed).images
        } catch (e : Exception) {
            Log.d("Repo", "$e")
        }
    }
}