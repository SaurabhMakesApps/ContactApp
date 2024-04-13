package com.contact.contactsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.contact.contactsapp.ContactROOM.ContactEntity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>
//Adapter acts as a machine connecting AdapterViews with data
{
Context context;
ArrayList<ContactEntity> listOfContacts;
    public ContactAdapter(Context context,ArrayList<ContactEntity> listOfContacts)
    {
        this.context = context;
        this.listOfContacts = listOfContacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View contactCard = LayoutInflater.from(context).inflate(R.layout.contact_item_layout,parent,false);
        return new ContactViewHolder(contactCard);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
//          holder.contactImage.setImageResource(listOfContacts.get(position).image); //how to set image
          holder.contactName.setText(listOfContacts.get(position).getContactName());
          holder.contactNumber.setText(listOfContacts.get(position).getContactNumber());
    }

    @Override
    public int getItemCount() {
        return listOfContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView contactImage;
        TextView contactName;
        TextView contactNumber;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            contactImage = itemView.findViewById(R.id.contactImage);
            contactName = itemView.findViewById(R.id.contactName);
            contactNumber = itemView.findViewById(R.id.contactNumber);
            Context context1;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //this method will handle what we want to do when we click an item
                    Toast.makeText(itemView.getContext(), "Item clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
