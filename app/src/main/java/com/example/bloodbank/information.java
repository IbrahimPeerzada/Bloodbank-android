package com.example.bloodbank;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class information extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav = (NavigationView) findViewById(R.id.navmenu);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId())
            {
                case R.id.Home :
                    Toast.makeText(getApplicationContext(),"Home Panel is Open",Toast.LENGTH_LONG).show();
                    Intent t = new Intent(information.this , Selection.class);
                    startActivity(t);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.info :
                    Toast.makeText(getApplicationContext(),"INFO PANEL", Toast.LENGTH_LONG).show();
                    Intent t2 = new Intent(information.this , information.class);
                    startActivity(t2);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.exit :
                    Toast.makeText(getApplicationContext(),"LOGOUT",Toast.LENGTH_LONG).show();
                    Intent t1 = new Intent(information.this , Login.class);
                    startActivity(t1);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }

            return true;
        });
    }
    public void ClickLogo(View view) {
        CloseDrawer(drawerLayout);
    }

    private void CloseDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view) {
        recreate();
    }

    public void ClickDashboard(View view) {
        redirectActivity(this, Selection.class);
    }

    public void ClickAboutUs(View view) {
        redirectActivity(this, Selection.class);
    }

    public void Logout(View view) {
        Logout(this);
    }

    private void Logout(Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    private void redirectActivity(Activity activity, Class aclass) {
        Intent intent = new Intent(activity, aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

    protected void OnPause() {
        super.onPause();

        CloseDrawer(drawerLayout);
    }
}