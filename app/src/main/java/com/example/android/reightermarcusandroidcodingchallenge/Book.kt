package com.example.android.reightermarcusandroidcodingchallenge

import com.google.gson.annotations.SerializedName

data class Book (
    @SerializedName("title") val title: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("imageURL") val imageURL: String?
    )