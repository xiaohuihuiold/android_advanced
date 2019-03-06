package com.xhhold.advanced.httprequest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.xhhold.advanced.httprequest.`interface`.DataService
import com.xhhold.advanced.httprequest.model.CompanyModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dataService = retrofit.create(DataService::class.java)
        val call = dataService.getData()
        call.enqueue(object : Callback<CompanyModel> {
            override fun onFailure(call: Call<CompanyModel>, t: Throwable) {
                textview.text=t.message
            }

            override fun onResponse(call: Call<CompanyModel>, response: Response<CompanyModel>) {
                textview.append(response.body()?.name + "\n")
                textview.append(response.body()?.links!![0].name + "\n")
            }
        })
    }
}
