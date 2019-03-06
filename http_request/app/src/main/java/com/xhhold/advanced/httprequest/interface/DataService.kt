package com.xhhold.advanced.httprequest.`interface`

import com.xhhold.advanced.httprequest.model.CompanyModel
import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET("v2/5c7fce40330000c3398483cd")
    fun getData(): Call<CompanyModel>
}