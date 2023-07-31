package com.example.lab5_adr2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Bai3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        BottomNavigationView bottomNavigationView=findViewById(R.id.btnnavi);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment1 ;
                if (item.getItemId()==R.id.trangChu){
                    fragment1=new HomeFlangment();
                }else if (item.getItemId()==R.id.map){
                    fragment1=new Map();
                }else {
                    fragment1=new Image();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fm_b3, fragment1).commit();
                return true;
            }
        });
    }
}