package com.example.android.carrental.AdminActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.carrental.Adapters.AdminCarsListAdapter;
import com.example.android.carrental.Adapters.AdminRentedCarsListAdapter;
import com.example.android.carrental.R;
import com.example.android.carrental.SystemDatabase.DBHolder;
import com.example.android.carrental.SystemDatabase.RentCarModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayRentedCarsActivity extends AppCompatActivity {
    private ListView listView;
    private AdminRentedCarsListAdapter adapter;

    private DatabaseReference postRef;
    private RecyclerView rentedCarRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rented_cars);

        postRef = FirebaseDatabase.getInstance().getReference().child("RentCar");
        rentedCarRecyclerview= findViewById(R.id.list_view_rented_car_display);
        rentedCarRecyclerview.setHasFixedSize(true);
        rentedCarRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        postsList();

//        if(DBHolder.rentCarData.isEmpty())
//            Toast.makeText(this, getString(R.string.toast_no_cars_to_show), Toast.LENGTH_SHORT).show();
//        else {
//            listView = findViewById(R.id.list_view_rented_car_display);
//            adapter = new AdminRentedCarsListAdapter(this, R.layout.layout_admin_rented_car_item, DBHolder.rentCarData);
//            listView.setAdapter(adapter);
//        }
    }

    private void postsList() {
        FirebaseRecyclerOptions<RentCarModel> options = new FirebaseRecyclerOptions.Builder<RentCarModel>()
                .setQuery(postRef, RentCarModel.class)
                .build();
        FirebaseRecyclerAdapter<RentCarModel, AdminRentedCarsListAdapter> postAdapter = new FirebaseRecyclerAdapter<RentCarModel,
                        AdminRentedCarsListAdapter>(options) {
            @NonNull
            @Override
            public AdminRentedCarsListAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_admin_rented_car_item, parent,
                        false);
                AdminRentedCarsListAdapter holder = new AdminRentedCarsListAdapter(view);
                return holder;
            }

            @Override
            protected void onBindViewHolder(@NonNull AdminRentedCarsListAdapter holder, final int position, @NonNull final RentCarModel model) {

                holder.username.setText(model.getUserName());
                holder.userphn.setText(model.getUserPhone());
                holder.cartype.setText(model.getType());
                holder.caroccation.setText(model.getOccasion());
                holder.price.setText(model.getPrice());
                holder.dateFrom.setText(model.getDateFrom());
                holder.dateTo.setText(model.getDateTo());




            }
        };

        rentedCarRecyclerview.setAdapter(postAdapter);
        postAdapter.startListening();
    }
}