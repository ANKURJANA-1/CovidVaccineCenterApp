package com.example.covidcenterapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidcenterapp.R
import com.example.covidcenterapp.model.Sessions

class MainactivityAdapter(
    private val list: ArrayList<Sessions>,
    private val context: Context
) :
    RecyclerView.Adapter<MainactivityAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.vaccine_center_view_layout,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }
}