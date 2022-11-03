package com.dicoding.proyekakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity()
{
    companion object
    {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_COVER = "extra_cover"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_LANGUAGE = "extra_language"
        const val EXTRA_PUBLISHER = "extra_publisher"
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_PAGES = "extra_pages"
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Book Detail"

        val tvDetailTitle: TextView = findViewById(R.id.tv_detail_title)
        val tvDetailAuthor: TextView = findViewById(R.id.tv_detail_author)
        val ivDetailCover: ImageView = findViewById(R.id.iv_detail_cover)
        val tvDetailDesc: TextView = findViewById(R.id.tv_detail_desc)
        val tvDetailCategory: TextView = findViewById(R.id.tv_detail_category)
        val tvDetailLanguage: TextView = findViewById(R.id.tv_detail_language)
        val tvDetailPublisher: TextView = findViewById(R.id.tv_detail_publisher)
        val tvDetailYear: TextView = findViewById(R.id.tv_detail_year)
        val tvDetailPages: TextView = findViewById(R.id.tv_detail_pages)

        tvDetailTitle.text = intent.getStringExtra(EXTRA_TITLE)
        tvDetailAuthor.text = intent.getStringExtra(EXTRA_AUTHOR)
        val cover = intent.getIntExtra(EXTRA_COVER,0)
        Glide.with(this).load(cover).into(ivDetailCover)
        tvDetailDesc.text = intent.getStringExtra(EXTRA_DESC)
        tvDetailCategory.text = intent.getStringExtra(EXTRA_CATEGORY)
        tvDetailLanguage.text= intent.getStringExtra(EXTRA_LANGUAGE)
        tvDetailPublisher.text = intent.getStringExtra(EXTRA_PUBLISHER)
        val year = intent.getIntExtra(EXTRA_YEAR,0)
        tvDetailYear.text = year.toString()
        val pages = intent.getIntExtra(EXTRA_PAGES,0)
        tvDetailPages.text = pages.toString()

        val btnFavorite: Button = findViewById(R.id.btn_favorite)
        btnFavorite.setOnClickListener {
            Toast.makeText(this, "Book added to Favorite", Toast.LENGTH_SHORT).show()
        }
    }
}