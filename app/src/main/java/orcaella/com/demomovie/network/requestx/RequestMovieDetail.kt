package orcaella.com.demomovie.network.requestx

import orcaella.com.demomovie.Constant
import orcaella.com.demomovie.model.MovieDetail

class RequestMovieDetail: BaseRequest<MovieDetail>(){

    var movie_id = 0

    override fun requestApi() {
        sendRequest(getClient().getMovieDetail(movie_id, Constant.api_key))
    }
}