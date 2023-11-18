package com.example.travelmate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.com.example.travelmate.ActiveTrips_data


class Active_trips : Fragment() {
    private lateinit var newARecyclerview: RecyclerView
    private lateinit var newActiveTripList:ArrayList<ActiveTrips_data>
    lateinit var  destinationImg:ArrayList<Int>
    lateinit var upcoming_des:ArrayList<String>
    lateinit var upcoming_des_flag:ArrayList<Int>
    lateinit var upcoming_trip_detail:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_active_trips, container, false)
    }


}