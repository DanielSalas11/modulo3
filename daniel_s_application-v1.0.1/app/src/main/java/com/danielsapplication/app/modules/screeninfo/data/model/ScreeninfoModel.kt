package com.danielsapplication.app.modules.screeninfo.`data`.model

import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ScreeninfoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtActivity: String? = MyApp.getInstance().resources.getString(R.string.lbl_activity)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThursdaymarch: String? =
      MyApp.getInstance().resources.getString(R.string.msg_thursday_march)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmociones: String? = MyApp.getInstance().resources.getString(R.string.lbl_emociones)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDuranteeste: String? =
      MyApp.getInstance().resources.getString(R.string.msg_durante_este_tiempo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDatos: String? = MyApp.getInstance().resources.getString(R.string.lbl_datos)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAnalisisGraf: String? =
      MyApp.getInstance().resources.getString(R.string.msg_35_de_los_d_as)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAnlisis: String? = MyApp.getInstance().resources.getString(R.string.lbl_an_lisis)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTusestad: String? = MyApp.getInstance().resources.getString(R.string.msg_tus_estad_sticas)

)
