package com.example.covidcenterapp.model

data class Sessions(
    var center_id: String,
    var address: String,
    var state_name: String,
    var district_name: String,
    var block_name: String,
    var pincode: String,
    var from: String,
    var to: String,
    var lat: Int,
    var long: Int,
    var fee_type: String,
    var session_id: String,
    var date: String,
    var available_capacity: Int,
    var available_capacity_dose1: Int,
    var available_capacity_dose2: Int,
    var fee: String,
    var min_age_limit: Int,
    var allow_all_age: Boolean,
    var vaccine: String,
    var slots: Array<String>
)
