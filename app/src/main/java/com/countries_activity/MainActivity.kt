package com.countries_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryList = loadCountriesFromAssets()

        val recyclerView: RecyclerView = findViewById(R.id.countryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountryAdapter(countryList)
    }

    fun loadCountriesFromAssets(): List<Country> {
        val jsonFileString = this.assets.open("data.json").bufferedReader().use { it.readText() }

        // Parse the entire JSON as a JSONObject
        val jsonObject = JSONObject(jsonFileString)

        // Extract the "Countries" array as a string
        val countriesArrayString = jsonObject.getJSONArray("Countries").toString()

        // Parse the "Countries" array into a list of Country objects
        val listCountryType = object : TypeToken<List<Country>>() {}.type
        return Gson().fromJson(countriesArrayString, listCountryType)
    }
}