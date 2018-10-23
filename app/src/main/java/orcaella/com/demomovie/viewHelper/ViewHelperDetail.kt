package orcaella.com.demomovie.viewHelper

import orcaella.com.demomovie.model.MovieDetailModel
import java.util.ArrayList

interface ViewHelperDetail {
    fun showLoading()

    fun hideLoading()

    fun showError(message: String)

    fun showMovieDetail(movie: MovieDetailModel)
}