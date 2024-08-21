package com.countries_activity

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class CountryAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val nativeNameTextView: TextView = itemView.findViewById(R.id.nativeNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.nameTextView.text = country.Name
        holder.nativeNameTextView.text = country.NativeName

        holder.itemView.setOnClickListener {
            if (country.Name != null) {
                val intent = Intent(holder.itemView.context, CountryDetailActivity::class.java)
                intent.putExtra("COUNTRY_DATA", country)
                holder.itemView.context.startActivity(intent)
                Log.d("CountryDetailActivity", "Image URL: ${country.Flag}")
            } else {
                Toast.makeText(holder.itemView.context, "Capital information not available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = countries.size
}