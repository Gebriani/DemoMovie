package orcaella.com.demomovie.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager){

    fun addFragment(fragment: Fragment, title: String){
        fragmentsList.add(fragment)
        titles.add(title)
    }

    val fragmentsList = ArrayList<Fragment>()
    val titles = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentsList.get(position)
    }

    override fun getCount(): Int {
       return fragmentsList.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }
}