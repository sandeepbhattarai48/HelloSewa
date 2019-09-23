package com.hellosewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hellosewa.cartFragment.Cart;
import com.hellosewa.homeFragment.Home;
import com.hellosewa.liveCareFragment.LiveCare;
import com.hellosewa.profileFragment.Profile;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host,new Home()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.home_nav:
                            selectedFragment = new Home();
                            break;
                         case R.id.cart_nav:
                            selectedFragment = new Cart();
                            break;
                         case R.id.livcare_nav:
                            selectedFragment = new LiveCare();
                            break;
                         case R.id.profile_nav:
                            selectedFragment = new Profile();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host,selectedFragment).commit();
                    return true;
                }
            };


}
