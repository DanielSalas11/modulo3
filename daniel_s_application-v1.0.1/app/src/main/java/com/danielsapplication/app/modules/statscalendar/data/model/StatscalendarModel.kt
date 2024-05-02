package com.danielsapplication.app.modules.statscalendar.`data`.model

import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class StatscalendarModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtBitacora: String? = MyApp.getInstance().resources.getString(R.string.lbl_bitacora)

)
