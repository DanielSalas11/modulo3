package com.danielsapplication.app.modules.statstwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danielsapplication.app.R
import com.danielsapplication.app.databinding.RowTwoBinding
import com.danielsapplication.app.modules.statstwo.`data`.model.TwoRowModel
import kotlin.Int
import kotlin.collections.List

class StatsTwoAdapter(
  var list: List<TwoRowModel>
) : RecyclerView.Adapter<StatsTwoAdapter.RowTwoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowTwoVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_two,parent,false)
    return RowTwoVH(view)
  }

  override fun onBindViewHolder(holder: RowTwoVH, position: Int) {
    val twoRowModel = TwoRowModel()
    // TODO uncomment following line after integration with data source
    // val twoRowModel = list[position]
    holder.binding.twoRowModel = twoRowModel
  }

  override fun getItemCount(): Int = 35
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<TwoRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: TwoRowModel
    ) {
    }
  }

  inner class RowTwoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowTwoBinding = RowTwoBinding.bind(itemView)
  }
}
