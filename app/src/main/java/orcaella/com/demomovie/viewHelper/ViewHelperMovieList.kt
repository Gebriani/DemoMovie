package orcaella.com.demomovie.viewHelper

import orcaella.com.demomovie.model.Movie
import java.util.ArrayList

interface ViewHelperMovieList {
    fun showLoading()

    fun showRefreshLoading()

    fun hideLoading()

    fun hideRefreshLoading()

    fun showError(message: String)

    fun showMovieList(list: ArrayList<Movie>)

    fun removeAllList()
}