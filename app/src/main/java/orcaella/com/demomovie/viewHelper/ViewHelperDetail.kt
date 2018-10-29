package orcaella.com.demomovie.viewHelper

import orcaella.com.demomovie.model.MovieDetail

interface ViewHelperDetail {
    fun showLoading()

    fun hideLoading()

    fun showError(message: String)

    fun showMovieDetail(movie: MovieDetail)
}