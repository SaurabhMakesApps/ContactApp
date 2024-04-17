package com.contact.contactsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.contact.contactsapp.ContactROOM.ContactEntity;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private Context context;
    private ArrayList<ContactEntity> listOfContacts;

    public ContactAdapter(Context context, ArrayList<ContactEntity> listOfContacts) {
        this.context = context;
        this.listOfContacts = listOfContacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactCard = LayoutInflater.from(context).inflate(R.layout.contact_item_layout, parent, false);
        return new ContactViewHolder(contactCard);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactEntity contact = listOfContacts.get(position);
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return listOfContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView contactImage;
        private TextView contactName;
        private TextView contactNumber;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            contactImage = itemView.findViewById(R.id.contactImage);
            contactName = itemView.findViewById(R.id.contactName);
            contactNumber = itemView.findViewById(R.id.contactNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle item click
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ContactEntity clickedContact = listOfContacts.get(position);
                        // You can perform an action when a contact is clicked
                        Toast.makeText(context, "Clicked: " + clickedContact.getContactName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bind(ContactEntity contact) {
            // Set data to views
            byte[] imageBytes = contact.getImageBytes();
            if (imageBytes != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                contactImage.setImageBitmap(bitmap);
            } else {
                // If no image is available, you can set a placeholder image or hide the ImageView
                contactImage.setImageResource(R.drawable.contact_image_placeholder);
            }
            contactName.setText(contact.getContactName());
            contactNumber.setText(contact.getContactNumber());
        }
    }
}
