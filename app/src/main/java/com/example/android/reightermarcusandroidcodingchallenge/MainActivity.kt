package com.example.android.reightermarcusandroidcodingchallenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private var books: List<Book>? = ArrayList()
    private var bookRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookRecyclerView = findViewById(R.id.list_books)
        bookRecyclerView!!.layoutManager = LinearLayoutManager(this)

        val booksRecyclerAdapter = BooksRecyclerAdapter(this, books)

        val fetchBookData = BookService.create()

        fetchBookData.books.enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                books = response.body()
                booksRecyclerAdapter.addBooks(books)
                booksRecyclerAdapter.notifyDataSetChanged()
                bookRecyclerView!!.adapter = booksRecyclerAdapter
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                var failureMessage: Book = Book(
                    "Something went wrong",
                    "Unable to fetch Data",
                    null)

                books = listOf(failureMessage)

                booksRecyclerAdapter.addBooks(books)
                booksRecyclerAdapter.notifyDataSetChanged()
                bookRecyclerView!!.adapter = booksRecyclerAdapter
            }
        })
    }
}
