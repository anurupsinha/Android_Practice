package com.example.loginmain.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.loginmain.R
import com.example.loginmain.ui.login.view.ViewPager.DummyRetrofitFragment
import kotlinx.android.synthetic.main.fragment_view_pager.*


class ViewPagerFragment : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_view_pager)


        val adapter = MyViewPagerAdapter(supportFragmentManager)

        //add two fragments to viewpager
        adapter.addFragment(DummyRetrofitFragment(), "Dummy Retrofit")
        adapter.addFragment(RealmFragment(), "Realm DB")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}