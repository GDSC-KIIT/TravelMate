package com.example.travelmate.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travelmate.Adapters.CategoryAdaptar;
import com.example.travelmate.R;
import com.example.travelmate.models.CategoryDomain;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class home_main_fragment extends Fragment {

    private RecyclerView popmenu;
    private RecyclerView.Adapter adapter;

    private TextView tvViewAllPopularDest;
    private TextView tvViewAllArticles;

    private NavController navController;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_main_fragment, container, false);


        tvViewAllPopularDest = view.findViewById(R.id.tvViewAllPopularDestination);
        tvViewAllArticles = view.findViewById(R.id.tvViewAllArticles);


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        view.findViewById(R.id.tvViewAllPopularDestination).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_main_fragment_to_popular_destination);
            }
        });

//        view.findViewById(R.id.tvViewAllArticles).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navController.navigate(R.id.);  // add id after making popular articles fragment
//            }
//        });

    }



    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        popmenu = getActivity().findViewById(R.id.rc1);
        popmenu.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Meal","cat_1"));
        category.add(new CategoryDomain("Snacks","cat_2"));
        category.add(new CategoryDomain("Drink","cat_3"));
        category.add(new CategoryDomain("Deserts","cat_4"));

        adapter=new CategoryAdaptar(category, requireContext());
        popmenu.setAdapter(adapter);

        // popmenu.addItemDecoration(new CategoryAdaptar.ItemDecoration(12));
    }
}