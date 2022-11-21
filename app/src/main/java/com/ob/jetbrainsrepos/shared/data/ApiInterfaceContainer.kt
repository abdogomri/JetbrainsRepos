package com.ob.jetbrainsrepos.shared.data

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ob.jetbrainsrepos.shared.data.local.MockApiInterfaceImpl

import com.ob.jetbrainsrepos.shared.utils.Constant.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiInterfaceContainer(context: Context) {
    private val builder: OkHttpClient.Builder = OkHttpClient.Builder()

    private val mockApiInterface: ApiInterface = MockApiInterfaceImpl()

    private val remoteApiInterface: ApiInterface by lazy {
        addInterceptors(builder, context)

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build()
            .create(ApiInterface::class.java)
    }
    private fun addInterceptors(
        builder: OkHttpClient.Builder,
        context: Context
    ) {
        builder.addInterceptor(
            ChuckerInterceptor.Builder(context)
                .collector(ChuckerCollector(context))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()
        )
    }

    fun provideApiInterface(isOnline: Boolean): ApiInterface {
        return if (isOnline)
            remoteApiInterface
        else mockApiInterface

    }

}