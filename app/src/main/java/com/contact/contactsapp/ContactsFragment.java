package com.contact.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.contact.contactsapp.ContactROOM.ContactDatabaseHelper;
import com.contact.contactsapp.ContactROOM.ContactEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ContactsFragment extends Fragment implements View.OnClickListener {


    public ContactsFragment() {
        // Required empty public constructor
    }


    Context thiscontext;
    ArrayList<ContactEntity> contactList = new ArrayList<>();
    RecyclerView recyclerView;

    View view;

    public ContactsFragment(ArrayList<ContactEntity> contactList)
    {
        this.contactList = contactList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contacts, container, false);
        thiscontext = view.getContext();

        recyclerView = view.findViewById(R.id.contactsrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


       FloatingActionButton addContact= (FloatingActionButton) view.findViewById(R.id.add_new_contact);
       addContact.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              Intent toAddContact = new Intent(thiscontext,AddContact.class);
              startActivity(toAddContact);
           }
       });



        ContactDatabaseHelper database_object = ContactDatabaseHelper.getDb(thiscontext);


        ArrayList<ContactEntity> contacts = (ArrayList<ContactEntity>) database_object.contactDB().getAllColumnsFromContacts();

        ContactAdapter contactAdapter = new ContactAdapter(getContext(), contacts);


        recyclerView.setAdapter(contactAdapter);
        return view;
    }

    @Override
    public void onClick(View v) {

        int id = view.getId();
        if(id == R.id.add_new_contact)
        {
            Toast.makeText(thiscontext, "Working", Toast.LENGTH_SHORT).show();
        }
    }

}