package com.example.testmenuapplicationdz;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar materialToolbar = findViewById(R.id.material_toolbar);
        setSupportActionBar(materialToolbar);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, materialToolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);

        replaceFragment(new FragmentSetting()); // запуск окна с самого начала

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.circle_Of_life){
                    replaceFragment(new FragmentCircleOfLife());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.global_target){
                    replaceFragment(new FragmentGlobalTarget());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.calendar){
                    replaceFragment(new FragmentCalendar());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.tasks){
                    replaceFragment(new FragmentDayTasks());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.counter_calories){
                    replaceFragment(new FragmentCounterCalories());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.setting){
                    replaceFragment(new FragmentSetting());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}