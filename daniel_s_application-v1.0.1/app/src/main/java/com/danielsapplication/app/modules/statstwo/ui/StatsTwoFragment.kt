package com.danielsapplication.app.modules.statstwo.ui

import android.view.View
import androidx.fragment.app.viewModels
import com.danielsapplication.app.R
import com.danielsapplication.app.appcomponents.base.BaseFragment
import com.danielsapplication.app.databinding.FragmentStatsTwoBinding
import com.danielsapplication.app.modules.statstwo.`data`.model.TwoRowModel
import com.danielsapplication.app.modules.statstwo.`data`.viewmodel.StatsTwoVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class StatsTwoFragment : BaseFragment<FragmentStatsTwoBinding>(R.layout.fragment_stats_two) {
  private val viewModel: StatsTwoVM by viewModels<StatsTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val statsTwoAdapter = StatsTwoAdapter(viewModel.statsTwoList.value?:mutableListOf())
    binding.recyclerStatsTwo.adapter = statsTwoAdapter
    statsTwoAdapter.setOnItemClickListener(
    object : StatsTwoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : TwoRowModel) {
        onClickRecyclerStatsTwo(view, position, item)
      }
    }
    )
    viewModel.statsTwoList.observe(requireActivity()) {
      statsTwoAdapter.updateData(it)
    }
    binding.statsTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerStatsTwo(
    view: View,
    position: Int,
    item: TwoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "STATS_TWO_FRAGMENT"

  }
}
