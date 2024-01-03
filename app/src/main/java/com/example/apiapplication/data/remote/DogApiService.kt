package com.example.apiapplication.data.remote

import com.example.apiapplication.data.DogImages
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://dog.ceo/api/breed/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface DogApiService {
        @GET("{breed}/images")
        suspend fun getImages(@Path("breed") breed: String): DogImages

    }

object DogAPI {
    val retrofitService: DogApiService by lazy { retrofit.create(DogApiService::class.java) }
}