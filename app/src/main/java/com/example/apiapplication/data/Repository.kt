package com.example.apiapplication.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiapplication.data.remote.CatAPI
import java.lang.Exception

class Repository(private val api: CatAPI) {

    private val _facts = MutableLiveData<List<CatFact>>()
    val facts: LiveData<List<CatFact>>
        get() = _facts


    suspend fun getFacts() {
        try {
            _facts.value = api.retrofitService.getFacts()
        } catch (e : Exception) {
            Log.d("Repo", "$e")
        }
    }
}