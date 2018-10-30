package com.example.android.reightermarcusandroidcodingchallenge

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BookService {
    @get:GET("books.json")
    val books: Call<List<Book>>

    companion object {
        fun create(): BookService{
            val builder = Retrofit.Builder().baseUrl("http://de-coding-test.s3.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
            val retrofit = builder.build()

            return retrofit.create(BookService::class.java)
        }
    }
}