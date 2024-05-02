package com.danielsapplication.app.modules.stats.ui

import androidx.activity.viewModels
import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.base.BaseActivity
import com.danielsapplication.app.databinding.ActivityStatsBinding
import com.danielsapplication.app.modules.stats.`data`.viewmodel.StatsVM
import kotlin.String
import kotlin.Unit

class StatsActivity : BaseActivity<ActivityStatsBinding>(R.layout.activity_stats) {
  private val viewModel: StatsVM by viewModels<StatsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.statsVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "STATS_ACTIVITY"

  }
}
