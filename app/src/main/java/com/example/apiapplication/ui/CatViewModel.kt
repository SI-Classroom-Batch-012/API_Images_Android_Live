package com.example.apiapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiapplication.data.Repository
import com.example.apiapplication.data.remote.CatAPI
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {

    private val repository = Repository(CatAPI)
    val facts = repository.facts

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getFacts()
        }
    }
}