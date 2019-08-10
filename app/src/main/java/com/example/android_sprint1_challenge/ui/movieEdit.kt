package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_sprint1_challenge.Model.Movie
import com.example.android_sprint1_challenge.R
import kotlinx.android.synthetic.main.activity_movie_editpage.*



class movieEdit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_editpage)


        fun createMovie(): Movie {
            var newMovie = Movie(edit_movie_title.text.toString())
            return newMovie
        }

        fun loadMovie(movie: Movie) {
            edit_movie_title.setText(movie.movieName)
        }




          btn_SAVE.setOnClickListener {
            var intentSaveMovie = Intent()
            intentSaveMovie.putExtra("movie", createMovie())
            setResult(Activity.RESULT_OK, intentSaveMovie)
            finish()
        }
        var bundle: Bundle? = intent.extras
        if (bundle != null) {
            loadMovie(bundle!!.getSerializable("movieKey") as Movie)
        }

        btn_Delete.setOnClickListener{
            
        }
    }


}