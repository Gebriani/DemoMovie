package orcaella.com.demomovie.model

data class MovieList(
        var page: Int = 0,
        var total_results: Int = 0,
        var total_pages: Int = 0,
        var results: ArrayList<Movie> = ArrayList()
)