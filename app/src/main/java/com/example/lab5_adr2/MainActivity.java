package com.example.lab5_adr2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.NagitionView);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,
                toolbar,R.string.navitione_open,R.string.navitione_close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;
                if (item.getItemId()==R.id.home){
                    toolbar.setTitle("Trang Chủ");
                    fragment=new HomeFlangment();
                } else if (item.getItemId()==R.id.dauTrang) {
                    toolbar.setTitle("Dau Trang");
                    fragment=new DauTrangFlangment();
                    
                } else  {
                    toolbar.setTitle("Cai Dat");
                    fragment = new SettingFlamnet();
                }
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.frameLayout,fragment).commit();
                drawerLayout.close();
                return true;
            }
        });
    }
}