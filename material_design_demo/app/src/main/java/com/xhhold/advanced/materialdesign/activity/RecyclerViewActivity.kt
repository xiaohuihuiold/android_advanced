package com.xhhold.advanced.materialdesign.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.xhhold.advanced.materialdesign.R
import com.xhhold.advanced.materialdesign.adapter.ListAdapter
import com.xhhold.advanced.materialdesign.adapter.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerViewActivity : AppCompatActivity(), OnItemClickListener {
    private val datas: List<Array<out Any>> =
        arrayListOf(
            arrayOf("RecyclerView", "纵向列表"),
            arrayOf("RecyclerView", "横向列表"),
            arrayOf("RecyclerView", "网格布局"),
            arrayOf("RecyclerView", "瀑布流"),
            arrayOf("RecyclerView", "带分割线的列表")
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        initData()
    }

    private fun initData() {
        initVertical()
    }

    private fun initVertical() {
        val layoutManager = LinearLayoutManager(this)
        recycler_recycler_view.layoutManager = layoutManager
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = ListAdapter(this, datas, ListAdapter.ListLayout.VERTICAL)
        adapter.onItemClickListener = this
        recycler_recycler_view.adapter = adapter
    }

    private fun initHorizontal() {
        val layoutManager = LinearLayoutManager(this)
        recycler_recycler_view.layoutManager = layoutManager
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val adapter = ListAdapter(this, datas, ListAdapter.ListLayout.HORIZONTAL)
        adapter.onItemClickListener = this
        recycler_recycler_view.adapter = adapter
    }

    private fun initGrid() {
        val layoutManager = GridLayoutManager(this, 3)
        recycler_recycler_view.layoutManager = layoutManager
        val adapter = ListAdapter(this, datas, ListAdapter.ListLayout.GRID)
        adapter.onItemClickListener = this
        recycler_recycler_view.adapter = adapter
    }

    private fun initStagger() {
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recycler_recycler_view.layoutManager = layoutManager
        val adapter = ListAdapter(this, datas, ListAdapter.ListLayout.STAGGER)
        adapter.onItemClickListener = this
        recycler_recycler_view.adapter = adapter
    }

    override fun onItemClick(datas: Array<out Any>, index: Int) {
        when (index) {
            0 -> {
                initVertical()
            }
            1 -> {
                initHorizontal()
            }
            2 -> {
                initGrid()
            }
            3 -> {
                initStagger()
            }
            4 -> {
                /*initVertical()*/
                Toast.makeText(this, "未添加", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
