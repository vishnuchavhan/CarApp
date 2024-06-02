package com.example.android.carrental.AdminActivities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.example.android.carrental.Adapters.AdminCarsListAdapter;
import com.example.android.carrental.SystemDatabase.DBHolder;
import com.example.android.carrental.R;

public class DisplayCarsActivity extends AppCompatActivity {

    private ListView listView;
    private AdminCarsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cars);

        if(DBHolder.carsData.isEmpty())
            Toast.makeText(this, getString(R.string.toast_no_cars_to_show), Toast.LENGTH_SHORT).show();
        else {
            listView = findViewById(R.id.list_view_users_display);
            adapter = new AdminCarsListAdapter(this, R.layout.layout_admin_car_item, DBHolder.carsData);
            listView.setAdapter(adapter);
        }
    }

}