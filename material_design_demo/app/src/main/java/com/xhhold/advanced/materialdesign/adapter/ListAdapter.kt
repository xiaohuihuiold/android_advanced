package com.xhhold.advanced.materialdesign.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.xhhold.advanced.materialdesign.R

class ListAdapter(
    private val context: Context,
    private val datas: List<Array<out Any>>,
    private val layout: ListLayout
) :

    RecyclerView.Adapter<ListAdapter.MainViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder {
        when (layout) {
            ListLayout.HORIZONTAL -> {

                return MainViewHolder(
                    LayoutInflater.from(context).inflate(
                        R.layout.recycler_main_horizontal,
                        p0,
                        false
                    )
                )
            }
            ListLayout.VERTICAL -> {

                return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_main_vertical, p0, false))
            }
            ListLayout.GRID -> {

                return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_main_grid, p0, false))
            }
            ListLayout.STAGGER -> {

                return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_main_vertical, p0, false))
            }
        }
    }

    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) {
        p0.title?.text = datas[p1][0] as String
        p0.subTitle?.text = datas[p1][1] as String
        p0.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(datas[p1], p1)
        }
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = itemView.findViewById(R.id.recycler_main_title)
        var subTitle: TextView? = itemView.findViewById(R.id.recycler_main_subtitle)
    }

    enum class ListLayout {
        HORIZONTAL,
        VERTICAL,
        GRID,
        STAGGER
    }

    class DividerItemDecoration : RecyclerView.ItemDecoration() {
        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
        }
    }
}