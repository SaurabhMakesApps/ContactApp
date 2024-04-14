package com.contact.contactsapp;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.contact.contactsapp.ContactROOM.ContactDatabaseHelper;
import com.contact.contactsapp.ContactROOM.ContactEntity;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
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



try {
    

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enteredContactName = contactName.getText().toString();
                enteredContactEmail = contactEmail.getText().toString();
                enteredContactNumber = contactNumber.getText().toString();
                databaseObject.contactDB().AddContact(new ContactEntity(enteredContactName, enteredContactNumber));
            }
        });
    }
    catch(Exception e)
    {
        Toast.makeText(this, "App crashing at data population in database", Toast.LENGTH_SHORT).show();
    }
        ArrayList<ContactEntity> contacts = (ArrayList<ContactEntity>) databaseObject.contactDB().getAllColumnsFromContacts();
        new ContactsFragment(contacts);




    }
}
//    void fetchImageFromGallery()
//    {
//        Intent goToGallery = new Intent(Intent.ACTION_PICK);
//        goToGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(goToGallery,GALLERY_REQ_CODE);
//    }
//
   //I don't know how to store Images in ROOM persistent library
    //For now, have not put checks for what to do in case the image is modified or deleted





//}