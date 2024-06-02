package com.example.android.carrental.SystemDatabase;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CarDOA {
    private DatabaseReference databaseReference;
    public CarDOA(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("RentCar");
    }
    public Task<Void> add(RentCarModel carM){

        return databaseReference.push().setValue(carM);
    }
}
