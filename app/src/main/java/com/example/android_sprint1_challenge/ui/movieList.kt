package com.example.android_sprint1_challenge.ui

import android.content.Intent
import android.graphics.ColorSpace
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint1_challenge.R
import kotlinx.android.synthetic.main.activity_movie_list.*

class movieList : AppCompatActivity() {


    var movielist = mutableListOf<com.example.android_sprint1_challenge.Model.Movie>()
    var counter = 0

    companion object{
        const val REQUEST_CODE_EDIT_MOVIE = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_editpage)

        button_add_movie.setOnClickListener {
            var addMovieIntent = Intent(this,movieEdit::class.java)
            startActivityForResult(addMovieIntent,REQUEST_CODE_EDIT_MOVIE)
        }

    }
            fun MovieTextView(movie:Movie, index:Int):TextView {
                var newMovieView =TextView(this)
                newMovieView.id=index
                newMovieView.text= movieName
            }


    fun refreshBookList(){
            LL_movielist.removeAllViews()
            for((counter,Movie) in movielist.withIndex()){

                LL_movielist.addView(MovieTextView(Movie,counter))
            }
        }




}
