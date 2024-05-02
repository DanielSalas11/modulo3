package com.danielsapplication.app.modules.stats.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielsapplication.app.modules.stats.`data`.model.StatsModel
import org.koin.core.KoinComponent

class StatsVM : ViewModel(), KoinComponent {
  val statsModel: MutableLiveData<StatsModel> = MutableLiveData(StatsModel())

  var navArguments: Bundle? = null
}
