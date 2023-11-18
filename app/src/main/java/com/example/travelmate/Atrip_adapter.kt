package com.example.travelmate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.recyclerview.com.example.travelmate.ActiveTrips_data

class Atrip_adapter(private val activeTripList:ArrayList<ActiveTrips_data>):RecyclerView.Adapter<Atrip_adapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.active_trip_list,
            parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=activeTripList[position]
        holder.destinationImg.setImageResource(currentItem.destinationImg)
        holder.upcoming_des.text=currentItem.upcoming_des
        holder.upcoming_des_flag.setImageResource(currentItem.upcoming_des_flag)
        holder.upcoming_trip_detail.text=currentItem.upcoming_trip_detail
    }

    override fun getItemCount(): Int {
        return activeTripList.size
    }




    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

         var destinationImg:ImageView=itemView.findViewById(R.id.destination)
        var upcoming_des:TextView=itemView.findViewById(R.id.upcoming_des)
        var upcoming_des_flag:ImageView=itemView.findViewById(R.id.upcoming_des_flag)
        var upcoming_trip_detail:TextView=itemView.findViewById(R.id.upcoming_trip_detail)
    }


}