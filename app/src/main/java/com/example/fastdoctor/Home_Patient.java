package com.example.fastdoctor;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Home_Patient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    //Navigation bar:fragment
    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__patient);

        //Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationDrawer();
        //Navigation bar
        chipNavigationBar = findViewById(R.id.chipNavigation);


        chipNavigationBar.setItemSelected(R.id.home_patientt, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomePatientFrag()).commit();

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.home_patientt:
                        fragment = new HomePatientFrag();
                        break;
                    case R.id.notif_msg_patientt:
                        fragment = new MsgFrag();
                        break;
                    case R.id.notif_patient:
                        fragment = new NotificationFrag();
                        break; }
                if (fragment != null) { getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit(); }
            }
        });

    }

    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_pofil);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomePatientFrag());

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

        switch (item.getItemId()){
            case R.id.nav_pofil:
                chipNavigationBar.setItemSelected(R.id.home_patientt, false);
                chipNavigationBar.setItemSelected(R.id.notif_msg_patientt, false);
                chipNavigationBar.setItemSelected(R.id.notif_patient, false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfilPatientFrag()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_Rdv:
                chipNavigationBar.setItemSelected(R.id.home_patientt, false);
                chipNavigationBar.setItemSelected(R.id.notif_msg_patientt, false);
                chipNavigationBar.setItemSelected(R.id.notif_patient, false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new FixRdvFlag()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_forum:
                chipNavigationBar.setItemSelected(R.id.home_patientt, false);
                chipNavigationBar.setItemSelected(R.id.notif_msg_patientt, false);
                chipNavigationBar.setItemSelected(R.id.notif_patient, false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new ForumFrag()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }

        return true;
    }
}