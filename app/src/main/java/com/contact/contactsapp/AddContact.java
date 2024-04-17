package com.contact.contactsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.contact.contactsapp.ContactROOM.ContactDatabaseHelper;
import com.contact.contactsapp.ContactROOM.ContactEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AddContact extends AppCompatActivity {

    EditText contactName, contactNumber, contactEmail;
    ImageView contactImage;
    Button addContact;
    ProgressBar progressBar;

    private final int GALLERY_REQ_CODE = 100;

    String enteredContactName, enteredContactEmail, enteredContactNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        ContactDatabaseHelper databaseObject = ContactDatabaseHelper.getDb(this);

        contactImage = findViewById(R.id.imageView);
        contactName = findViewById(R.id.editTextText);
        contactNumber = findViewById(R.id.editTextText2);
        contactEmail = findViewById(R.id.editTextText3);
        addContact = findViewById(R.id.addToContactButton);
        progressBar = findViewById(R.id.progressBar);

        contactImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                getContactImage();
                return false;
            }
        });

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact.setEnabled(false);

                enteredContactName = contactName.getText().toString();
                enteredContactEmail = contactEmail.getText().toString();
                enteredContactNumber = contactNumber.getText().toString();

                progressBar.setVisibility(View.VISIBLE);

                new LoadImageTask().execute();
            }
        });
    }

    public void getContactImage() {
        Intent iGallery = new Intent(Intent.ACTION_PICK);
        iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(iGallery, GALLERY_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQ_CODE && data != null) {
                new LoadImageTask().execute(data.getData());
            }
        }
    }

    private class LoadImageTask extends AsyncTask<android.net.Uri, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(android.net.Uri... uris) {
            android.net.Uri imageUri = uris[0];
            try {
                return MediaStore.Images.Media.getBitmap(AddContact.this.getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                contactImage.setImageBitmap(bitmap);
                new UploadContactTask().execute(bitmap);
            } else {
                Toast.makeText(AddContact.this, "Error loading image", Toast.LENGTH_SHORT).show();
                addContact.setEnabled(true);
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    private class UploadContactTask extends AsyncTask<Bitmap, Void, Void> {

        @Override
        protected Void doInBackground(Bitmap... bitmaps) {
            Bitmap bitmap = bitmaps[0];
            byte[] byteImageStore = bitmapToByteArray(bitmap);
            ContactDatabaseHelper databaseObject = ContactDatabaseHelper.getDb(AddContact.this);
            if (byteImageStore == null) {
                databaseObject.contactDB().AddContact(new ContactEntity(enteredContactName, enteredContactNumber));
            } else {
                databaseObject.contactDB().AddContact(new ContactEntity(byteImageStore, enteredContactName, enteredContactNumber));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBar.setVisibility(View.GONE);
            addContact.setEnabled(true);

            // Now refresh the Fragment
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.myFragmentContainer, new ContactsFragment());
            ft.commit();
        }
    }

    public byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
