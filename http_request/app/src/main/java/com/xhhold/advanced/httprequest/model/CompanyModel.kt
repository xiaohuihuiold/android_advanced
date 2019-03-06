package com.xhhold.advanced.httprequest.model

data class CompanyModel(
    val name: String,
    val url: String,
    val page: Int,
    val isNonProfit: Boolean,
    val address: String,
    val links: List<LinkModel>
)