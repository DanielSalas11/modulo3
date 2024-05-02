package com.danielsapplication.app.modules.screeninfo.ui

import androidx.activity.viewModels
import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.base.BaseActivity
import com.danielsapplication.app.databinding.ActivityScreeninfoBinding
import com.danielsapplication.app.modules.screeninfo.`data`.viewmodel.ScreeninfoVM
import kotlin.String
import kotlin.Unit

class ScreeninfoActivity : BaseActivity<ActivityScreeninfoBinding>(R.layout.activity_screeninfo) {
  private val viewModel: ScreeninfoVM by viewModels<ScreeninfoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screeninfoVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREENINFO_ACTIVITY"

  }
}
