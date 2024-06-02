package com.example.android.carrental.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.carrental.AdminActivities.RemoveCarsActivity;
import com.example.android.carrental.AdminActivities.UpdateCarActivity;
import com.example.android.carrental.Interfaces.PostItemClickListener;
import com.example.android.carrental.R;
import com.example.android.carrental.SystemDatabase.CarModel;
import com.example.android.carrental.SystemDatabase.RentCarModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdminRentedCarsListAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView username, userphn, cartype, caroccation, price, dateFrom, dateTo;
    public PostItemClickListener listener;
    private final Context context;

    public AdminRentedCarsListAdapter(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        username = itemView.findViewById(R.id.text_view_username);
        userphn = itemView.findViewById(R.id.text_view_userphone);
        cartype = itemView.findViewById(R.id.carTypeT);
        caroccation = itemView.findViewById(R.id.text_view_car_occasion_item);
        price = itemView.findViewById(R.id.text_view_car_price_item);
        dateFrom = itemView.findViewById(R.id.text_view_date_from);
        dateTo = itemView.findViewById(R.id.text_view_date_to);

    }


    public void setItemClickListener(PostItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition(),false);
    }

}
