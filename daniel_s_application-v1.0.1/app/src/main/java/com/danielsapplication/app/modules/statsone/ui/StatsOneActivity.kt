package com.danielsapplication.app.modules.statsone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.base.BaseActivity
import com.danielsapplication.app.databinding.ActivityStatsOneBinding
import com.danielsapplication.app.modules.statsone.`data`.viewmodel.StatsOneVM
import kotlin.String
import kotlin.Unit

class StatsOneActivity : BaseActivity<ActivityStatsOneBinding>(R.layout.activity_stats_one) {
  private val viewModel: StatsOneVM by viewModels<StatsOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.statsOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "STATS_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StatsOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
