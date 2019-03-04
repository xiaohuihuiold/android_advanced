package com.xhhold.advanced.materialdesign

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.xhhold.advanced.materialdesign.activity.RecyclerViewActivity
import com.xhhold.advanced.materialdesign.adapter.ListAdapter
import com.xhhold.advanced.materialdesign.adapter.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val datas: List<Array<out Any>> =
        arrayListOf(
            arrayOf("RecyclerView", "ListView的升级版", RecyclerViewActivity::class.java),
            arrayOf("CardView", "卡片式布局"),
            arrayOf("CardView", "卡片式布局")
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initData() {
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        val adapter = ListAdapter(this, datas)
        adapter.onItemClickListener = this
        main_recycler_view.adapter = adapter
    }

    override fun onItemClick(datas: Array<out Any>, index: Int) {
        if (datas.size == 3) {
            startActivity(Intent(this, datas[2] as Class<*>))
        }
    }
}
