package com.example.secretdiary;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.ActionMenuView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toolbar;
;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    TabLayout tabLayout;
    FrameLayout frameLayout;
    private View Fab_add;
    private View Btn_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton Fab_add ;

        frameLayout = findViewById(R.id.simpleFrameLayout);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("RECENT"));
        tabLayout.addTab(tabLayout.newTab().setText("CALENDER"));
        tabLayout.addTab(tabLayout.newTab().setText("MOOD"));

        Fab_add = findViewById(R.id.fab_add);
        Fab_add.setOnClickListener((View.OnClickListener) this);

        Btn_setting = findViewById(R.id.btn_setting);
        Btn_setting.setOnClickListener((View.OnClickListener) this);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment = new MainFragment();
                        break;
                    case 1:
                        fragment = new CalenderFragment();
                        break;
                    case 2:
                        fragment = new MoodFragment();
                        break;
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.simpleFrameLayout, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.fab_add:
                Intent fab_add = new Intent(MainActivity.this, StoryActivity.class);
                startActivity(fab_add);
            case R.id.btn_setting:
                Intent btn_setting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(btn_setting);
        }
    }
}
