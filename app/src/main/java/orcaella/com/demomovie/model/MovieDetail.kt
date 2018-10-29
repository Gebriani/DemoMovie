package orcaella.com.demomovie.model

data class MovieDetail(
        var adult: Boolean = false,
        var genres: ArrayList<Genre> = ArrayList(),
        var backdrop_path: String = "",
        var budget: Int = 0,
        var homepage: String = "",
        var id: Long = 0,
        var imdb_id: String = "",
        var original_language: String = "",
        var original_title : String = "",
        var overview: String = "",
        var popularity: Double = 0.0,
        var poster_path: String = "",
        var production_companies: ArrayList<ProductionCompany> = ArrayList(),
        var production_countries: ArrayList<ProductionCountry> = ArrayList(),
        var release_date: String = "",
        var revenue: Int = 0,
        var runtime: Int = 0,
        var spoken_languages: ArrayList<Language> = ArrayList(),
        var status: String = "",
        var tagline: String = "",
        var title: String = "",
        var video: Boolean = false,
        var vote_average: Double = 0.0,
        var vote_count: Int = 0

)
