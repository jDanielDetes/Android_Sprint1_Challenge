package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint1_challenge.Model.Movie
import com.example.android_sprint1_challenge.R
import kotlinx.android.synthetic.main.activity_movie_list.*


class movieList : AppCompatActivity() {


    var movielist = mutableListOf<Movie>()
    var counter = 0

    companion object {
        const val REQUEST_CODE_EDIT_MOVIE = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_editpage)

        button_add_movie.setOnClickListener {
            var addMovieIntent = Intent(this, movieEdit::class.java)
            startActivityForResult(addMovieIntent, REQUEST_CODE_EDIT_MOVIE)
        }

    }

    fun MovieTextView(movie: com.example.android_sprint1_challenge.Model.Movie, index: Int): TextView {
        var newMovieView = TextView(this)
        newMovieView.id = index
        newMovieView.text = movie.movieName
        newMovieView.textSize = 19f

        newMovieView.setOnClickListener{

            var tvIntent = Intent(this,movieEdit::class.java)
            tvIntent.putExtra("movieKey",movielist[newMovieView.id])
            movielist.removeAt(newMovieView.id)
            startActivityForResult(tvIntent, REQUEST_CODE_EDIT_MOVIE)

        }
        return newMovieView



    }


    fun refreshMovieList(){
            LL_movielist.removeAllViews()
            for((counter,Movie) in movielist.withIndex()){

                LL_movielist.addView(MovieTextView(Movie,counter))
            }
        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode== REQUEST_CODE_EDIT_MOVIE && resultCode == Activity.RESULT_OK) {
            val newMovie= data!!.getSerializableExtra("movie") as com.example.android_sprint1_challenge.Model.Movie
            movielist.add(newMovie)
        }
    }
}
