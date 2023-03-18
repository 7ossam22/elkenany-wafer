package com.elkenany.wafer.api.test

import android.os.IInterface
import com.elkenany.wafer.api.configurations.retrofit
import com.elkenany.wafer.entities.AboutUsData
import com.elkenany.wafer.entities.GenericEntity
import retrofit2.Call
import retrofit2.http.GET

interface ITest {
    @GET("about-us")
    fun testingCallFromBackendServer(): Call<GenericEntity<AboutUsData>>
}

