package com.example.apiapplication.data

import com.squareup.moshi.Json

class DogImages(
    @Json(name="message")
    val images: List<String>
)