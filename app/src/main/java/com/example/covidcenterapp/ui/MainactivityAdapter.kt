package com.example.covidcenterapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covidcenterapp.R
import com.example.covidcenterapp.model.Parent
import com.example.covidcenterapp.model.Sessions

class MainactivityAdapter(
    private val list: ArrayList<Sessions>,
    private val context: Context
) :
    RecyclerView.Adapter<MainactivityAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val vaccine_center_name: TextView = itemView.findViewById(R.id.idTVCenterName)
        private val vaccine_center_address: TextView = itemView.findViewById(R.id.idTVCenterAddress)
        private val vaccine_center_timing: TextView = itemView.findViewById(R.id.idTVCenterTimings)
        private val vaccine_name: TextView = itemView.findViewById(R.id.idTVVaccineName)
        private val vaccine_fee_type: TextView = itemView.findViewById(R.id.idTVFeeType)
        private val vaccine_age_limit: TextView = itemView.findViewById(R.id.idTVAgeLimit)
        private val vaccine_avaliablity: TextView = itemView.findViewById(R.id.idTVAvaliablity)

        fun addViewToLayout(sessions: Sessions) {
            vaccine_center_name.text =
                (sessions.state_name + " " + sessions.block_name + " " + sessions.district_name)
            vaccine_center_address.text = sessions.address
            vaccine_center_timing.text =
                (sessions.slots[0] + " " + sessions.slots[1] + " " + sessions.slots[3])
            vaccine_name.text = sessions.vaccine
            vaccine_fee_type.text = sessions.fee_type
            vaccine_age_limit.text = sessions.min_age_limit.toString()
            vaccine_avaliablity.text = sessions.available_capacity.toString()
        }

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
        holder.addViewToLayout(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}