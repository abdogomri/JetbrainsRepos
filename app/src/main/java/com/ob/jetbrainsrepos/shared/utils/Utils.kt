package com.ob.jetbrainsrepos.shared.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ob.jetbrainsrepos.MyApplication

inline fun <reified T> getMock(filePath: String): T {

    val jsonObject = loadJSONFromAssets("mock_files/$filePath")
    val response = object : TypeToken<T>() {}.type
    return Gson().fromJson(jsonObject, response)
}

fun loadJSONFromAssets(fileName: String): String {
    return MyApplication.appContext.assets.open(fileName).bufferedReader().use { reader ->
        reader.readText()
    }
}