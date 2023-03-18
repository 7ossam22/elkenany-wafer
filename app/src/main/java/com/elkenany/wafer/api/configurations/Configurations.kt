package com.elkenany.wafer.api.configurations

import android.util.Log
import com.elkenany.wafer.entities.GenericEntity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.moshi.MoshiConverterFactory

//this base url for published server
const val BASE_URL = "https://admin.elkenany.com/api/"

private val moshi by lazy {
    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}

private val interceptor by lazy {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder().addInterceptor(interceptor).build()
}

val retrofit: Retrofit by lazy {
    Retrofit.Builder()
////         Make sure to comment this section before publishing any versions
//        .client(interceptor)
        .baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
}

suspend fun <T> onHandlingResponseStates(
    funName: String,
    request: () -> Call<GenericEntity<T>>,
): GenericEntity<T> {
    return try {
        request().await()
    } catch (e: HttpException) {
        Log.i(funName, e.message.toString())
        GenericEntity(null, e.code().toString(), null)
    } catch (e: Exception) {
        Log.i(funName, e.message.toString())
        GenericEntity(null, "304", null) // make sure to debug after this specially
    }
}

fun <H> retrofitInterfaceHandler(interfaceHandler: Class<H>): H {
    return retrofit.create(interfaceHandler) as H
}