package com.example.travelmate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class ActiveTripsFragment : Fragment() {
    private lateinit var newARecyclerview: RecyclerView
    private lateinit var newActiveTripList: ArrayList<ActiveTrips_data>
    private lateinit var destinationImg: ArrayList<Int>
    private lateinit var upcomingDes: ArrayList<String>
    private lateinit var upcomingDesFlag: ArrayList<Int>
    private lateinit var upcomingTripDetail: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_active_trips, container, false)
    }
}
