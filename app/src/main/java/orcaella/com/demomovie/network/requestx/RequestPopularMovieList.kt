package orcaella.com.demomovie.network.requestx

import orcaella.com.demomovie.Constant
import orcaella.com.demomovie.model.MovieList

class RequestPopularMovieList : BaseRequest<MovieList>() {

    override fun requestApi() {
        sendRequest(getClient().getPopularMovie(Constant.api_key, 1))
    }

}