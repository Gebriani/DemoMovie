package orcaella.com.demomovie.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*
import orcaella.com.demomovie.R
import orcaella.com.demomovie.impl.ImplMovieDetail
import orcaella.com.demomovie.model.MovieDetailModel
import orcaella.com.demomovie.presenter.PresenterMovieDetail
import orcaella.com.demomovie.viewHelper.ViewHelperDetail

class DetailActivity: BaseActivity(), ViewHelperDetail {

    var movieID = 0
    val basePath = "https://image.tmdb.org/t/p/w500/"

    lateinit var presenter: PresenterMovieDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(movie_detail_toolbar)

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setTitle("")
        }
        movieID = intent.getLongExtra("ID", 0).toInt()
        presenter = ImplMovieDetail(this, movieID)
        presenter.getMovieDetail()
        movie_detail_collaps.isTitleEnabled = false

    }


    override fun showLoading() {
        movie_detail_progressbar.visibility = View.VISIBLE
    }


    override fun hideLoading() {
        movie_detail_progressbar.visibility = View.GONE

    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showMovieDetail(movie: MovieDetailModel) {

        Glide.with(this)
                .load(basePath + movie.poster_path)
                .into(movie_detail_small_image)

        Glide.with(this)
                .load(basePath + movie.backdrop_path)
                .into(movie_imageView)

        movie_detail_title.text = movie.title
        movie_detail_language.text = movie.original_language
        movie_detail_star.text = movie.vote_average.toString() + "/10"
        movie_detail_votes.text = movie.vote_count.toString() +" votes"
        movie_detail_release_date.text = movie.release_date
        movie_detail_overview.text = movie.overview

        var genres = ""
        for (i in movie.genres){
            genres += i.name + " "
        }

        movie_detail_genre.text = genres
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


}















