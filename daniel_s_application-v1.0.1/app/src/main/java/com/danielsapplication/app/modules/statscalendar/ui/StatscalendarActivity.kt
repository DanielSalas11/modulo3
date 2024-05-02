package com.danielsapplication.app.modules.statscalendar.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.base.BaseActivity
import com.danielsapplication.app.databinding.ActivityStatscalendarBinding
import com.danielsapplication.app.modules.statscalendar.`data`.viewmodel.StatscalendarVM
import com.danielsapplication.app.modules.statsone.ui.StatsOneActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.String
import kotlin.Unit

class StatscalendarActivity :
    BaseActivity<ActivityStatscalendarBinding>(R.layout.activity_statscalendar) {
  private val viewModel: StatscalendarVM by viewModels<StatscalendarVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.statscalendarVM = viewModel
    val adapter = StatscalendarActivityPagerAdapter(supportFragmentManager,lifecycle)
    binding.viewPagerViewpager.adapter = adapter
    TabLayoutMediator(binding.tabLayoutTabview,binding.viewPagerViewpager) { tab, position ->
      tab.text = StatscalendarActivityPagerAdapter.title[position]
      }.attach()
      Handler(Looper.getMainLooper()).postDelayed( {
        val destIntent = StatsOneActivity.getIntent(this, null)
        startActivity(destIntent)
        finish()
        }, 3000)
      }

      override fun setUpClicks(): Unit {
      }

      companion object {
        const val TAG: String = "STATSCALENDAR_ACTIVITY"

      }
    }
