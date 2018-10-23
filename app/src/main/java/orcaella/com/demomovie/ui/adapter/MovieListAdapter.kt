package orcaella.com.demomovie.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_movie_item.view.*
import orcaella.com.demomovie.R
import orcaella.com.demomovie.model.MovieModel
import orcaella.com.demomovie.ui.DetailActivity

class MovieListAdapter(val context: Context, val movieList: ArrayList<MovieModel>) : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {
    val basePath = "https://image.tmdb.org/t/p/w500/"

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie_item, parent, false)
        return MovieListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.movieTitle.text = movieList[position].title
        Glide.with(context)
                .load(basePath + movieList[position].poster_path)
                .into(holder.movieImage)
        holder.movieroot.setOnClickListener { view ->
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("ID", movieList[position].id)
            context.startActivity(intent)
        }

    }


    class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage = itemView.item_movie_image
        val movieTitle = itemView.item_movie_title
        val movieGenre = itemView.item_movie_genres
        val movieIsLike = itemView.item_movie_like
        val movieroot = itemView.item_root_layout
    }

}

