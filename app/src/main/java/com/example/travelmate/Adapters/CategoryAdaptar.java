package com.example.travelmate.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.travelmate.MainActivity;
import com.example.travelmate.R;
import com.example.travelmate.details_activity;
import com.example.travelmate.models.CategoryDomain;

import java.util.List;

public class CategoryAdaptar extends RecyclerView.Adapter<CategoryAdaptar.ViewHolder> {
    private List<CategoryDomain> categoryDomains;

    Button bevv1;

    public CategoryAdaptar(List<CategoryDomain> categoryDomains, Context context) {
        this.categoryDomains = categoryDomains;
    }

    @Override
    public CategoryAdaptar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_dest_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdaptar.ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl = "";
        switch (position){
            case 0:{
                picUrl="img";
                //holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_3));
                break;

            }
            case 1:{

                picUrl="tokoyo";
                //holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_back2));
                break;
            }
            case 2:{
                picUrl="f3";
                //holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_back1));
                break;

            }
            case 3:{
                picUrl="deserts";
                //holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat2));
                break;

            }
            case 4:{
                picUrl="";
                // holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.color.white));
                break;

            }

        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            int drawableResourceHolder= holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getOpPackageName());

            Glide.with(holder.itemView.getContext())
                    .load(drawableResourceHolder)
                    .into(holder.categoryImage);

        }
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryImage;
        LinearLayout mainLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryText);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            // Handle click for case 0
                            // Launch a new activity
                            Context context3 = view.getContext();
                            Intent intent3 = new Intent(context3, details_activity.class);
                            context3.startActivity(intent3);
                            break;
                        case 1:
                        case 2:
                        case 3:
                            // Handle click for cases 1, 2, and 3 (add your logic here)
                            break;
                    }
                }
            });
        }
    }

    public static class ItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public ItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            // if (parent.getChildAdapterPosition(view) == 0) {
            //   outRect.top = space;
            // }
        }
    }

}
