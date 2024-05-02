package com.danielsapplication.app.modules.statsone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielsapplication.app.modules.statsone.`data`.model.StatsOneModel
import org.koin.core.KoinComponent

class StatsOneVM : ViewModel(), KoinComponent {
  val statsOneModel: MutableLiveData<StatsOneModel> = MutableLiveData(StatsOneModel())

  var navArguments: Bundle? = null
}
