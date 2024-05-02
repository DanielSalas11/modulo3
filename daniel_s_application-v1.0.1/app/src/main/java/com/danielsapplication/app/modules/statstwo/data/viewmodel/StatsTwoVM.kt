package com.danielsapplication.app.modules.statstwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielsapplication.app.modules.statstwo.`data`.model.StatsTwoModel
import com.danielsapplication.app.modules.statstwo.`data`.model.TwoRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class StatsTwoVM : ViewModel(), KoinComponent {
  val statsTwoModel: MutableLiveData<StatsTwoModel> = MutableLiveData(StatsTwoModel())

  var navArguments: Bundle? = null

  val statsTwoList: MutableLiveData<MutableList<TwoRowModel>> = MutableLiveData(mutableListOf())
}
