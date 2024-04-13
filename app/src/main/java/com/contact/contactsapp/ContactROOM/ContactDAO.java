package com.contact.contactsapp.ContactROOM;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface ContactDAO
{

    @Insert
    void AddContact(ContactEntity contact);

    @Query("select*from contacts")
    List<ContactEntity> getAllColumnsFromContacts();


    @Update
    void updateContact(ContactEntity contact);

    @Delete
    void deleteContact(ContactEntity delete);
}
