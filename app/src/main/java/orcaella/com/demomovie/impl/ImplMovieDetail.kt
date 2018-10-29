package orcaella.com.demomovie.impl

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import orcaella.com.demomovie.model.MovieDetail
import orcaella.com.demomovie.network.requestx.RequestCallBack
import orcaella.com.demomovie.network.requestx.RequestMovieDetail
import orcaella.com.demomovie.presenter.PresenterMovieDetail
import orcaella.com.demomovie.viewHelper.ViewHelperDetail

class ImplMovieDetail(private val viewHelper: ViewHelperDetail, val movieID: Int): PresenterMovieDetail, LifecycleObserver, RequestCallBack<MovieDetail> {

    private val requestMovieDetail = RequestMovieDetail()

    init {
        requestMovieDetail.addCallBack(this)
        if (viewHelper is LifecycleOwner) {
            (viewHelper as LifecycleOwner).lifecycle.addObserver(this)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun addView() {
        requestMovieDetail.addView()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun removeView() {
        requestMovieDetail.removeView()
    }

    override fun getMovieDetail() {
        requestMovieDetail.movie_id = movieID
        requestMovieDetail.requestApi()
    }

    override fun onRequestSuccess(response: MovieDetail) {
        viewHelper.hideLoading()
        viewHelper.showMovieDetail(response)
    }

    override fun onRequestError(message: String) {
        viewHelper.hideLoading()
        viewHelper.showError(message)
    }

}
