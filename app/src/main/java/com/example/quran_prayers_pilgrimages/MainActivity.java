package com.example.quran_prayers_pilgrimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.quran_prayers_pilgrimages.Fragments.Pilgrimage;
import com.example.quran_prayers_pilgrimages.Fragments.Pursuitofprayer;
import com.example.quran_prayers_pilgrimages.Fragments.Quran;
import com.example.quran_prayers_pilgrimages.Fragments.Supplication;
import com.fxn.BubbleTabBar;
import com.fxn.OnBubbleClickListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ImageView OpenMenuBtn;
    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    BubbleTabBar bubbleTabBar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenMenuBtn=findViewById(R.id.OpenMenuBtn);
        drawerLayout=findViewById(R.id.DrawerLayout);
        frameLayout=findViewById(R.id.FrameLayout);
        bubbleTabBar=findViewById(R.id.bubbleTabBar);
        navigationView=findViewById(R.id.NavigationView);

        OpenMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawers();
                }
                else
                {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id=item.getItemId();

                switch (id)
                {
                    case R.id.Favorites:
                    {

                    }
                    break;

                    case R.id.Donate:
                    {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://zarinp.al/amirhosseindeveloper"));
                        startActivity(intent);
                    }
                    break;

                    case R.id.Commenting:
                    {

                    }
                    break;

                    case R.id.Settings:
                    {

                    }
                    break;

                    case R.id.AboutUs:
                    {

                    }
                    break;

                    case R.id.Instagram:
                    {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/amirhossein.android"));
                        startActivity(intent);
                    }
                    break;

                    case R.id.Exit:
                    {
                        finish();
                    }
                    break;
                }

                return false;
            }
        });

        bubbleTabBar.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
               switch (i)
               {
                   case R.id.Quran:
                   {
                       Quran quran_ =new Quran();
                       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.FrameLayout, quran_);
                       fragmentTransaction.commit();
                   }
                   break;

                   case R.id.Supplication:
                   {
                       Supplication supplication =new Supplication();
                       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.FrameLayout, supplication);
                       fragmentTransaction.commit();
                   }
                   break;

                   case R.id.Pilgrimage:
                   {
                       Pilgrimage pilgrimage =new Pilgrimage();
                       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.FrameLayout, pilgrimage);
                       fragmentTransaction.commit();
                   }
                   break;

                   case R.id.Pursuitofprayer:
                   {
                       Pursuitofprayer pursuitofprayer =new Pursuitofprayer();
                       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.FrameLayout, pursuitofprayer);
                       fragmentTransaction.commit();
                   }
                   break;
               }
            }
        });

    }

}