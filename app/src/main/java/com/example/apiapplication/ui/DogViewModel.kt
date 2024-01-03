package com.example.apiapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiapplication.data.Repository
import com.example.apiapplication.data.remote.DogAPI
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val repository = Repository(DogAPI)
    val images = repository.images


    fun searchImages(breed: String) {
        viewModelScope.launch {
            repository.getImages(breed)
        }
    }
}