package com.contact.contactsapp.ContactROOM;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface ContactDAO
{

    @Query("select*from contacts")
    List<ContactEntity> getAllColumnsFromContacts();

    @Query("select contactName,contactNumber FROM contacts")
    List<ContactEntity> importantColumnsfromContacts(); //will come to it later

    @Insert
    void AddContactName(ContactEntity contact);

    @Update
    void updateContact(ContactEntity contact);

    @Delete
    void deleteContact(ContactEntity delete);
}
