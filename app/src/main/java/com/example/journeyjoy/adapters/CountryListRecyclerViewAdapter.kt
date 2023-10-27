package com.example.journeyjoy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.journeyjoy.R
import com.example.journeyjoy.models.CountryDataModel

class CountryListRecyclerViewAdapter(private val countryDataModel: CountryDataModel) :
    RecyclerView.Adapter<CountryListRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_ayout, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return countryDataModel.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.countryNameTxt.text =countryDataModel[position].country
    }

    class Holder(item: View) : ViewHolder(item) {
        val countryNameTxt: TextView = item.findViewById(R.id.countryNameTxt)

    }
}