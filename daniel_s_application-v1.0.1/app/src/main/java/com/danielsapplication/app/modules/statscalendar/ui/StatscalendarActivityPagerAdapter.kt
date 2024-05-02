package com.danielsapplication.app.modules.statscalendar.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.di.MyApp
import com.danielsapplication.app.modules.statstwo.ui.StatsTwoFragment
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class StatscalendarActivityPagerAdapter(
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = viewPages.size

    override fun createFragment(position: Int): Fragment = viewPages[position]

    companion object AdapterConstant {
        val title: List<String> =
                listOf(MyApp.getInstance().resources.getString(R.string.lbl_day),MyApp.getInstance().resources.getString(R.string.lbl_day),MyApp.getInstance().resources.getString(R.string.lbl_week),MyApp.getInstance().resources.getString(R.string.lbl_week),MyApp.getInstance().resources.getString(R.string.lbl_month),MyApp.getInstance().resources.getString(R.string.lbl_month),MyApp.getInstance().resources.getString(R.string.lbl_year),MyApp.getInstance().resources.getString(R.string.lbl_year))

        val viewPages: List<Fragment> =
                listOf(StatsTwoFragment(),StatsTwoFragment(),StatsTwoFragment(),StatsTwoFragment(),StatsTwoFragment(),StatsTwoFragment(),StatsTwoFragment(),StatsTwoFragment())

    }
}
