package com.example.travelmate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ItinerarySummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItinerarySummaryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var ivEditLocation : ImageView
    private lateinit var ivEditDates : ImageView
    private lateinit var ivEditParty : ImageView
    private lateinit var ivEditInterests : ImageView
    private lateinit var ivEditBudget : ImageView
    private lateinit var navController: NavController

    private lateinit var btnContinue : AppCompatButton

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
        return inflater.inflate(R.layout.fragment_itenary_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        ivEditBudget = view.findViewById(R.id.ivEditBudget)
        ivEditDates = view.findViewById(R.id.ivEditDates)
        ivEditInterests = view.findViewById(R.id.ivEditInterests)
        ivEditLocation = view.findViewById(R.id.ivEditLocation)
        ivEditParty = view.findViewById(R.id.ivEditParty)
        btnContinue = view.findViewById(R.id.btnContinue)


        ivEditBudget.setOnClickListener {
            navController.navigate(R.id.action_itinerarySummaryFragment_to_selectBudgetFragment2)
        }

        ivEditDates.setOnClickListener {
            navController.navigate(R.id.action_itinerarySummaryFragment_to_selectDateFragment)
        }

        ivEditInterests.setOnClickListener {
            navController.navigate(R.id.action_itinerarySummaryFragment_to_customizeTripFragment)
        }

        ivEditLocation.setOnClickListener {
            navController.navigate(R.id.action_itinerarySummaryFragment_to_tripDetailsFrag)
        }
        ivEditParty.setOnClickListener {
            navController.navigate(R.id.action_itinerarySummaryFragment_to_startTripFragment)
        }

        btnContinue.setOnClickListener {
            navController.navigate(R.id.action_itinerarySummaryFragment_to_my_trip_details)
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ItenarySummaryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItinerarySummaryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}