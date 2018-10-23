package orcaella.com.demomovie.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_movie_list.*
import orcaella.com.demomovie.R
import orcaella.com.demomovie.impl.ImplMovieList
import orcaella.com.demomovie.model.MovieModel
import orcaella.com.demomovie.presenter.PresenterMovieList
import orcaella.com.demomovie.ui.adapter.MovieListAdapter
import orcaella.com.demomovie.viewHelper.ViewHelperMovieList
import java.util.*

class MovieListFragment : Fragment(), ViewHelperMovieList {
    companion object {
        private const val type_args = "type"
        const val TYPE_POPULAR = 0
        const val TYPE_TOP_RATED = 1
        const val TYPE_FAVORITE = 2

        fun newInstance(type: Int): MovieListFragment {
            val fragment = MovieListFragment()
            val args = Bundle()
            args.putInt(type_args, type)
            fragment.arguments = args
            return fragment
        }
    }

    var movieList = ArrayList<MovieModel>()
    var type: Int = TYPE_POPULAR
    lateinit var adapter: MovieListAdapter
    lateinit var presenter: PresenterMovieList
    lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        type = arguments!!.getInt(type_args)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieListAdapter(context!!, movieList)
        popular_list.adapter = adapter
        popular_list.layoutManager = GridLayoutManager(context!!, 2)
        presenter = ImplMovieList(this, type)
        presenter.getMovieList()
    }

    override fun showLoading() {
        popular_progressbar.visibility = View.VISIBLE
    }

    override fun showRefreshLoading() {

    }

    override fun hideLoading() {
        popular_progressbar.visibility = View.GONE
    }

    override fun hideRefreshLoading() {

    }

    override fun showMovieList(list: ArrayList<MovieModel>) {
        movieList.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun removeAllList() {
        movieList.clear()
        adapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        Toast.makeText(context!!, message, Toast.LENGTH_LONG).show()
    }
}