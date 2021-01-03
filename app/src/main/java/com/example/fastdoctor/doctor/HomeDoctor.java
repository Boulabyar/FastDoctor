package com.example.fastdoctor.doctor;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.fastdoctor.ForumFrag;
import com.example.fastdoctor.BoiteRMsgFrag;
import com.example.fastdoctor.NotificationFrag;
import com.example.fastdoctor.R;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomeDoctor extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    //Navigation bar:fragment
    public static ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_doctor);
        //Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);


        navigationDrawer();
        //Navigation bar
        chipNavigationBar = findViewById(R.id.chipNavigation);

        //Selected Home by default
        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeDoctorFrag()).commit();
        //Select item in Navigation bar
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.home:
                        fragment = new HomeDoctorFrag();
                        break;
                    case R.id.notif_msg:
                        fragment = new BoiteRMsgFrag();
                        break;
                    case R.id.notification:
                        fragment = new NotificationFrag();
                        break;
                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }
            }
        });

    }

    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_pofil);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeDoctorFrag());

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }

        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_pofil:
                chipNavigationBar.setItemSelected(R.id.home, false);
                chipNavigationBar.setItemSelected(R.id.notif_msg, false);
                chipNavigationBar.setItemSelected(R.id.notification, false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfilDoctorFrag()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_Rdv:
                chipNavigationBar.setItemSelected(R.id.home, false);
                chipNavigationBar.setItemSelected(R.id.notif_msg, false);
                chipNavigationBar.setItemSelected(R.id.notification, false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CalendrierFlag()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_forum:
                chipNavigationBar.setItemSelected(R.id.home, false);
                chipNavigationBar.setItemSelected(R.id.notif_msg, false);
                chipNavigationBar.setItemSelected(R.id.notification, false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ForumFrag()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }

        return true;
    }
}