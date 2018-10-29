package orcaella.com.demomovie.model

data class Movie(

        var vote_count: Long = 0,
        var id: Long = 0,
        var video: Boolean = false,
        var vote_average: Double = 0.0,
        var popularity: Double = 0.0,
        var title: String = "",
        var poster_path: String = "",
        var original_language: String = "",
        var original_title: String = "",
        var backdrop_path: String = "",
        var overview: String = "",
        var adult: Boolean = false,
        var release_date: String = "",
        val genre_ids: IntArray = intArrayOf()
)

