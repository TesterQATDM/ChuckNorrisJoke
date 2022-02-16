package com.example.chucknorrisjoke

import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL

class Helper() {
    var data1: String = ""
    var data: String = ""
    fun response(): String{
        val connection = URL("https://api.chucknorris.io/jokes/random").openConnection() as HttpURLConnection
        if (connection.responseCode == 200)
            try {
                data = connection.inputStream.bufferedReader().use { it.readText() }
            } finally {
                connection.disconnect()
            }
        var mMineUserEntity = Gson()?.fromJson(data, Model::class.java)
        data1 = mMineUserEntity.value.toString()
        return data1

    }
}