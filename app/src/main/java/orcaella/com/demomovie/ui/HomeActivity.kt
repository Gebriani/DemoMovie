package orcaella.com.demomovie.ui

import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_home.*
import orcaella.com.demomovie.R
import orcaella.com.demomovie.ui.adapter.ViewPagerAdapter
import orcaella.com.demomovie.ui.fragment.MovieListFragment

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupViewPager(viewpager)
        tabsLayout.setupWithViewPager(viewpager)
    }

    private fun setupViewPager(pager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(MovieListFragment.newInstance(MovieListFragment.TYPE_POPULAR), "POPULAR")
        adapter.addFragment(MovieListFragment.newInstance(MovieListFragment.TYPE_TOP_RATED), "TOP RATED")
        adapter.addFragment(MovieListFragment.newInstance(MovieListFragment.TYPE_FAVORITE), "FAVORITE")
        pager.adapter = adapter
    }

}