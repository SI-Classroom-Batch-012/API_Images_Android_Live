package com.example.apiapplication.data.remote

import com.example.apiapplication.data.CatFact
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://cat-fact.herokuapp.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface CatApiService {
        @GET("facts")
        suspend fun getFacts(): List<CatFact>

    }

object CatAPI {
    val retrofitService: CatApiService by lazy { retrofit.create(CatApiService::class.java) }
}