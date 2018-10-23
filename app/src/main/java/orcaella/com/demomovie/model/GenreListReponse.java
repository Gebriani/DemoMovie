package orcaella.com.demomovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GenreListReponse {

    @SerializedName("genres")
    private ArrayList<GenreModel> genres;

    public ArrayList<GenreModel> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<GenreModel> genres) {
        this.genres = genres;
    }
}
