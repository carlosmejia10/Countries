package com.countries_activity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val Name: String,
    val NativeName: String,
    val Alpha2Code: String,
    val Alpha3Code: String,
    val Region: String,
    val SubRegion: String,
    val Population: Int,
    val Area: Int,
    val Flag: String,
    val FlagPng: String

    // ... other fields you want to include
) : Parcelable