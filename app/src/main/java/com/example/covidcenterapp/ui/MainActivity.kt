package com.example.covidcenterapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidcenterapp.R
import com.example.covidcenterapp.model.Parent
import com.example.covidcenterapp.model.Sessions
import com.example.covidcenterapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var pincode: EditText
    private lateinit var date: EditText
    private lateinit var submit: Button
    private lateinit var center_list: RecyclerView
    private lateinit var adapter: MainactivityAdapter
    private lateinit var noData: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pincode = findViewById(R.id.pincode)
        date = findViewById(R.id.date)
        submit = findViewById(R.id.submit)
        center_list = findViewById(R.id.center_list)
        noData=findViewById(R.id.noData)

        submit.setOnClickListener(View.OnClickListener {
            if (pincode.text.toString().isNotEmpty()
                && date.text.toString().isNotEmpty()
            ) {

                getAppointmentList(pincode.text.toString(), date.text.toString())

            }
        })

    }

    private fun getAppointmentList(pincode: String, date: String) {

        RetrofitService
            .getInstance()
            .getAppointmentList(
                pincode,
                date
            )
            .enqueue(object : Callback<Parent> {
                override fun onResponse(call: Call<Parent>, response: Response<Parent>) {

                    var parent = response.body() as Parent
                    var list = parent.sessions

                    Log.d("data", list.toString())
                    if(list.size>1){
                        adapter = MainactivityAdapter(list,applicationContext)
                        center_list.adapter = adapter
                        center_list.layoutManager = LinearLayoutManager(applicationContext)
                    }else{
                        noData.visibility=View.VISIBLE
                    }

                }

                override fun onFailure(call: Call<Parent>, t: Throwable) {
                    Log.d("data", t.toString())
                }
            })

    }

}