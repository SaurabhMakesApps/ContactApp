package com.contact.contactsapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.contact.contactsapp.ContactROOM.ContactDatabaseHelper;
import com.contact.contactsapp.ContactROOM.ContactEntity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        BottomNavigationView bottomNavigation = findViewById(R.id.myBottomNavigationView);

       bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)

           {

               int id = menuItem.getItemId();

               if(id==R.id.frag_5)
               {
                   loadFragment(new ContactsFragment(),0);
               }
               return true;
           }


       });
    }

    public void loadFragment(Fragment fragment,int flag)
    {
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag==0)
        {

            ft.add(R.id.myFragmentContainer,fragment);
        }
        else{
            ft.replace(R.id.myFragmentContainer,fragment);
        }


        ft.commit();
    }

}