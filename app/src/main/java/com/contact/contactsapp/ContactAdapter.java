//package com.contact.contactsapp;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
//
//    private ArrayList<ContactModel> contactsList;
//
//    // Constructor to initialize the adapter with a list of contacts
//    public ContactAdapter(ArrayList<ContactModel> contactsList) {
//        this.contactsList = contactsList;
//    }
//
//    // ViewHolder class to hold the views for each item in the RecyclerView
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        // Views for each item
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            // Initialize views here if needed
//        }
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // Inflate the layout for each item
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
//        // Create a new ViewHolder instance
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        // Bind data to views in each item
//        // Example: holder.textView.setText(contactsList.get(position).getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        // Return the size of the contacts list
//        return contactsList.size();
//    }
//}
