package com.dicoding.proyekakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    private lateinit var rvBooks: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "My Book List"

        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        list.addAll(BooksData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList()
    {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBooks.adapter = listBookAdapter

        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback
        {
            override fun onItemClicked(data: Book)
            {
                showSelectedBook(data)
            }
        })
    }

    //function buat menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int)
    {
        when (selectedMode)
        {
            R.id.menu_about ->
            {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showSelectedBook(book: Book)
    {
        val detailActivityIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_TITLE, book.title)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_AUTHOR, book.author)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_COVER, book.cover)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_DESC, book.desc)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_CATEGORY, book.category)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_LANGUAGE, book.language)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_PUBLISHER, book.publisher)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_YEAR, book.year)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_PAGES, book.pages)
        
        startActivity(detailActivityIntent)
    }
}