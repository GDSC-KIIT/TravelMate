package com.example.travelmate.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.travelmate.R;

public class DestinationDetailsFragment extends Fragment {

    AppCompatButton btnStartTrip;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageToStatusBar();

        btnStartTrip = requireActivity().findViewById(R.id.btnStartTrip);
        btnStartTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_tripDetailsFrag_to_startTripFragment);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_trip_details, container, false);



        return view;
    }

    public void ImageToStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getContext(), R.color.Transparent));
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                int statusBarHeight = getResources().getDimensionPixelSize(resourceId);

                ImageView statusBarBackground = getActivity().findViewById(R.id.image_holder);
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) statusBarBackground.getLayoutParams();
                params.setMargins(0, -statusBarHeight, 0, 0);
            }
        }
    }
}