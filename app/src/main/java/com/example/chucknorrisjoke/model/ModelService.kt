package com.example.chucknorrisjoke.model

import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL

class ModelService {

    lateinit var mMineUserEntity: Model
    var model = ""

    init{
        val connection = URL("https://api.chucknorris.io/jokes/random").openConnection() as HttpURLConnection
        if (connection.responseCode == 200)
            try {
                model = connection.inputStream.bufferedReader().use { it.readText() }
            } finally {
                connection.disconnect()
            }
        mMineUserEntity = Gson().fromJson(model, Model::class.java)
    }
}