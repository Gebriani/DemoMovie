package orcaella.com.demomovie.viewHelper

import orcaella.com.demomovie.model.MovieModel
import java.util.ArrayList

interface ViewHelperMovieList {
    fun showLoading()

    fun showRefreshLoading()

    fun hideLoading()

    fun hideRefreshLoading()

    fun showError(message: String)

    fun showMovieList(list: ArrayList<MovieModel>)

    fun removeAllList()
}