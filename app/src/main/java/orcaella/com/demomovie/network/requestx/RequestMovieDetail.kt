package orcaella.com.demomovie.network.requestx

import orcaella.com.demomovie.Constant
import orcaella.com.demomovie.model.MovieDetailModel

class RequestMovieDetail: BaseRequest<MovieDetailModel>(){

    var movie_id = 0

    override fun requestApi() {
        sendRequest(getClient().getMovieDetail(movie_id, Constant.api_key))
    }
}