package com.danielsapplication.app.modules.screeninfo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielsapplication.app.modules.screeninfo.`data`.model.ScreeninfoModel
import org.koin.core.KoinComponent

class ScreeninfoVM : ViewModel(), KoinComponent {
  val screeninfoModel: MutableLiveData<ScreeninfoModel> = MutableLiveData(ScreeninfoModel())

  var navArguments: Bundle? = null
}
