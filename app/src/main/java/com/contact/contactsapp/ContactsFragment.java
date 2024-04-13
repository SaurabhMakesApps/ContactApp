package com.contact.contactsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {


    public ContactsFragment() {
        // Required empty public constructor
    }


    Context thiscontext;
ArrayList<ContactModel> contactList = new ArrayList<>();
RecyclerView recyclerView;

        View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view =  inflater.inflate(R.layout.fragment_contacts, container, false);
        thiscontext = view.getContext();

         recyclerView = view.findViewById(R.id.contactsrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //test data, will be fetching data from local storage through ROOM
//         contactList.add(new ContactModel("Saurabh","99999"));
//         contactList.add((new ContactModel("Tushar","686868686")));
//        contactList.add((new ContactModel("Tushar","686868686")));
//        contactList.add((new ContactModel("Tushar","686868686")));
//        contactList.add((new ContactModel("Tushar","686868686"))); contactList.add((new ContactModel("Tushar","686868686")));

        //



        ContactAdapter contactAdapter = new ContactAdapter(getContext(),contactList);

         recyclerView.setAdapter(contactAdapter);
        return view;
    }
}