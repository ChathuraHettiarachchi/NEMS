package com.chootdev.nems.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.chootdev.nems.R;
import com.chootdev.nems.fragments.HomeFragment;
import com.chootdev.nems.fragments.NotificationFragment;
import com.chootdev.nems.fragments.SettingsFragment;
import com.chootdev.nems.fragments.StatsFragment;
import com.chootdev.nems.helpers.utilities.BottomNavigationViewHelper;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_stats:
                    fragment = new StatsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_settings:
                    fragment = new SettingsFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
