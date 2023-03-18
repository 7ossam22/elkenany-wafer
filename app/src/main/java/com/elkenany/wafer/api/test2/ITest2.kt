package com.elkenany.wafer.api.test2

import com.elkenany.wafer.entities.GenericEntity
import com.elkenany.wafer.entities.SponsersListData
import retrofit2.Call
import retrofit2.http.GET

interface ITest2 {
    @GET("sponsers")
    fun getAllSponsersData(): Call<GenericEntity<SponsersListData>>
}