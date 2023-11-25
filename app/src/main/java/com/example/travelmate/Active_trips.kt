package com.example.travelmate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.com.example.travelmate.ActiveTrips_data

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Active_trips : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var atrip_adapter:Atrip_adapter
    private lateinit var newARecyclerview: RecyclerView
    private lateinit var newActiveTripList:ArrayList<ActiveTrips_data>
    lateinit var  destinationImg:ArrayList<Int>
    lateinit var upcoming_des:ArrayList<String>
    lateinit var upcoming_des_flag:ArrayList<Int>
    lateinit var upcoming_trip_detail:ArrayList<String>
    lateinit var activetrips: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active_trips, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment My_trip_empty.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Active_trips().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun atripinitialize(){
        newActiveTripList= arrayListOf<ActiveTrips_data>()
        destinationImg= arrayListOf(
            R.drawable.japan_tokyo,
            R.drawable.paris
        )
        upcoming_des= arrayListOf(
            "Tokyo,Japan",
            "Paris,Japan"
        )
        upcoming_des_flag= arrayListOf(
            R.drawable.japan_flag,
            R.drawable.france_flag
        )
        upcoming_trip_detail= arrayListOf(
            "Dec 12 -16 Dec,2023  .  A couple  . Luxury",
            "Dec 21 -26 Dec,2023  .  A couple  . Luxury"
        )

        for (i in destinationImg.indices){
            val activetrips=ActiveTrips_data(destinationImg[i],upcoming_des[i],upcoming_des_flag[i], upcoming_trip_detail[i])
            newActiveTripList.add(activetrips)

        }