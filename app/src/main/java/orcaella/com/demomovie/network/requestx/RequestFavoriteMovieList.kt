package orcaella.com.demomovie.network.requestx

import orcaella.com.demomovie.Constant
import orcaella.com.demomovie.model.MovieList

class RequestFavoriteMovieList : BaseRequest<MovieList>() {

    override fun requestApi() {
        sendRequest(getClient().getFavorite(Constant.api_key, 1))
    }

}