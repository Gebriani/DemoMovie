package orcaella.com.demomovie.network.requestx

import orcaella.com.demomovie.Constant
import orcaella.com.demomovie.model.MovieList

class RequestTopRatedMovieList : BaseRequest<MovieList>() {

    override fun requestApi() {
        sendRequest(getClient().getTopRated(Constant.api_key, 1))
    }

}