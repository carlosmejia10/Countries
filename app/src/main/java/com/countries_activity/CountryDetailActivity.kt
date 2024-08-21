package com.countries_activity


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class CountryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val country = intent.getParcelableExtra<Country>("COUNTRY_DATA")

        if (country != null) {
            val flagImageView: ImageView = findViewById(R.id.flagImageView)
            val nameTextView: TextView = findViewById(R.id.nameTextView)
            val nativeNameTextView: TextView = findViewById(R.id.nativeNameTextView)
            val alpha2CodeTextView: TextView = findViewById(R.id.alpha2CodeTextView) // Initialize
            val alpha3CodeTextView: TextView = findViewById(R.id.alpha3CodeTextView) // Initialize
            val regionTextView: TextView = findViewById(R.id.regionTextView) // Initialize
            val subRegionTextView: TextView = findViewById(R.id.subRegionTextView) // Initialize
            val populationTextView: TextView = findViewById(R.id.populationTextView) // Initialize
            val areaTextView: TextView = findViewById(R.id.areaTextView) // Initialize
            // ... inside onCreate() ...
            Picasso.get().load(country.FlagPng).into(flagImageView)
            // ... other TextViews for the remaining

            nameTextView.text = country.Name
            nativeNameTextView.text = country.NativeName
            alpha2CodeTextView.text = country.Alpha2Code // Now you can use the variables
            alpha3CodeTextView.text = country.Alpha3Code
            regionTextView.text = country.Region
            subRegionTextView.text = country.SubRegion
            populationTextView.text = country.Population.toString()
            areaTextView.text = country.Area.toString()
        }
    }
}
