package com.contact.contactsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contact.contactsapp.ContactROOM.ContactDatabaseHelper;
import com.contact.contactsapp.ContactROOM.ContactEntity;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {


    public ContactsFragment() {
        // Required empty public constructor
    }


    Context thiscontext;
ArrayList<ContactEntity> contactList = new ArrayList<>();
RecyclerView recyclerView;

        View view;
//        ContactDatabaseHelper.contactDB().AddContact(new ContactEntity("Saurabh","939393939"));
//        ContactDatabaseHelper.contactDB().AddContact(new ContactEntity("Tushar","828282828"));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view =  inflater.inflate(R.layout.fragment_contacts, container, false);
        thiscontext = view.getContext();

         recyclerView = view.findViewById(R.id.contactsrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



ContactDatabaseHelper database_object = ContactDatabaseHelper.getDb(thiscontext);

        assert ContactDatabaseHelper.contactDB() != null;
        ContactDatabaseHelper.contactDB().AddContact(new ContactEntity("Saurabh","939393939"));
//        ContactDatabaseHelper.contactDB().AddContact(new ContactEntity("Tushar","828282828"));
//
//        // Now,data will be fetched from the database,no need of ContactModel class
//        ArrayList<ContactEntity> contacts = (ArrayList<ContactEntity>)ContactDatabaseHelper.contactDB().importantColumnsfromContacts();
//
////        ContactAdapter contactAdapter = new ContactAdapter(getContext(),contacts);
//        ContactDatabaseHelper.contactDB().AddContact(new ContactEntity("Saurabh","939393939"));
//        ContactDatabaseHelper.contactDB().AddContact(new ContactEntity("Tushar","828282828"));

////
////        ArrayList<ContactEntity> data = ArrayList<ContactEntity>
//        recyclerView.setAdapter(contactAdapter);
        return view;
    }
}