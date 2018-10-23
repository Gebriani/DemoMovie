package orcaella.com.demomovie.network.requestx

import orcaella.com.demomovie.Constant
import orcaella.com.demomovie.model.MovieListResponse

class RequestTopRatedMovieList : BaseRequest<MovieListResponse>() {

    override fun requestApi() {
        sendRequest(getClient().getTopRated(Constant.api_key, 1))
    }

}