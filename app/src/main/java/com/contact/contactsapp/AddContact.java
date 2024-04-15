package com.contact.contactsapp;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;

import com.contact.contactsapp.ContactROOM.ContactDAO;
import com.contact.contactsapp.ContactROOM.ContactDatabaseHelper;
import com.contact.contactsapp.ContactROOM.ContactEntity;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.contact.contactsapp.databinding.ActivityAddContactBinding;


import java.util.ArrayList;

public class AddContact extends AppCompatActivity {
    EditText contactName, contactNumber, contactEmail;
    ImageView contactImage;
    ImageView placeholderContactImage;

    private final int GALLERY_REQ_CODE = 100;

    String enteredContactName, enteredContactEmail;
    String enteredContactNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ContactDatabaseHelper databaseObject = ContactDatabaseHelper.getDb(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Intent fromFrag = getIntent();


        contactImage = findViewById(R.id.imageView);
        contactName = findViewById(R.id.editTextText);
        contactNumber = findViewById(R.id.editTextText2);
        contactEmail = findViewById(R.id.editTextText3);


        Button test = findViewById(R.id.addToContactButton);

        FragmentManager fm = getSupportFragmentManager();


        ArrayList<ContactEntity> contacts = (ArrayList<ContactEntity>) databaseObject.contactDB().getAllColumnsFromContacts();
        new ContactsFragment(contacts);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable the button to prevent multiple clicks
                test.setEnabled(false);

                enteredContactName = contactName.getText().toString();
                enteredContactEmail = contactEmail.getText().toString();
                enteredContactNumber = contactNumber.getText().toString();

                databaseObject.contactDB().AddContact(new ContactEntity(enteredContactName, enteredContactNumber));

                // Show a ProgressBar
                progressBar.setVisibility(View.VISIBLE);

                // Perform the operation in a background thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Add contact to the database

                        // Update UI on the main thread
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // Now refresh the Fragment
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.myFragmentContainer, new ContactsFragment());
                                ft.commit();

                                // Register a FragmentLifecycleCallbacks to listen for fragment events
                                getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                                    @Override
                                    public void onFragmentResumed(@NonNull FragmentManager fm, @NonNull Fragment f) {
                                        // When the fragment is completely resumed, hide the ProgressBar
                                        progressBar.setVisibility(View.GONE);

                                        // Unregister the FragmentLifecycleCallbacks to avoid memory leaks
                                        getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this);
                                    }
                                }, false);

                                // Enable the button again
                                test.setEnabled(true);
                            }
                        });
                    }
                }).start();

            }
        });

    }
}
