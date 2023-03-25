package com.elkenany.wafer.entities

import com.elkenany.wafer.utilities.GenericRecyclerEntity
import com.squareup.moshi.Json

data class AboutUsData(
    val about: String?,
)


data class SponsersListData(
    val logos: List<LogosAndBannersData?>,
)

data class LogosAndBannersData(
    override val id: String,
    val link: String?,
    val image: String?,
    @Json(name = "company_id") val companyId: Long?,
    @Json(name = "company_name") val companyName: String?,
    val type: String?,
) : GenericRecyclerEntity