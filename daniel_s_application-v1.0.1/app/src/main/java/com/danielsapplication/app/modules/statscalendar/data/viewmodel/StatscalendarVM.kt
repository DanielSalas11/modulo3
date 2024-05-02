package com.danielsapplication.app.modules.statscalendar.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielsapplication.app.modules.statscalendar.`data`.model.StatscalendarModel
import org.koin.core.KoinComponent

class StatscalendarVM : ViewModel(), KoinComponent {
  val statscalendarModel: MutableLiveData<StatscalendarModel> =
      MutableLiveData(StatscalendarModel())

  var navArguments: Bundle? = null
}
