package orcaella.com.demomovie.impl

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import orcaella.com.demomovie.model.MovieList
import orcaella.com.demomovie.network.requestx.RequestCallBack
import orcaella.com.demomovie.network.requestx.RequestFavoriteMovieList
import orcaella.com.demomovie.network.requestx.RequestPopularMovieList
import orcaella.com.demomovie.network.requestx.RequestTopRatedMovieList
import orcaella.com.demomovie.presenter.PresenterMovieList
import orcaella.com.demomovie.viewHelper.ViewHelperMovieList

class ImplMovieList(private val viewHelper: ViewHelperMovieList, val type: Int) : PresenterMovieList, LifecycleObserver, RequestCallBack<MovieList> {
    companion object {
        const val TYPE_POPULAR = 0
        const val TYPE_TOP_RATED = 1
        const val TYPE_FAVORITE = 2
    }

    private val requestPopularList = RequestPopularMovieList()
    private val requestTopRated = RequestTopRatedMovieList()
    private val requestFavoriteMovie = RequestFavoriteMovieList()


    init {
        when (type) {
            TYPE_POPULAR -> {
                requestPopularList.addCallBack(this)
            }
            TYPE_TOP_RATED -> {
                requestTopRated.addCallBack(this)
            }
            TYPE_FAVORITE -> {
                requestFavoriteMovie.addCallBack(this)
            }
            else -> throw IllegalArgumentException("Wrong type")
        }

        if (viewHelper is LifecycleOwner) {
            (viewHelper as LifecycleOwner).lifecycle.addObserver(this)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun addView() {
        requestPopularList.addView()
        requestTopRated.addView()
        requestFavoriteMovie.addView()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun removeView() {
        requestPopularList.removeView()
        requestTopRated.removeView()
        requestFavoriteMovie.removeView()
    }

    override fun getMovieList() {
        when (type) {
            TYPE_POPULAR -> {
                requestPopularList.requestApi()
            }
            TYPE_TOP_RATED -> {
                requestTopRated.requestApi()
            }
            TYPE_FAVORITE -> {
                requestFavoriteMovie.requestApi()
            }
        }
    }

    override fun onRequestSuccess(response: MovieList) {
        viewHelper.hideLoading()
        viewHelper.hideRefreshLoading()
        viewHelper.removeAllList()
        viewHelper.showMovieList(response!!.results)
    }

    override fun onRequestError(message: String) {
        viewHelper.hideLoading()
        viewHelper.hideRefreshLoading()
        viewHelper.showError(message)
    }

}