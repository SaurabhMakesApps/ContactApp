package com.contact.contactsapp.ContactROOM;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName="contacts")
public class ContactEntity {

    @ColumnInfo(name = "contactImage")
    private byte[] contactImage;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "contactName")
    private String contactName;

    @NonNull
    @ColumnInfo(name = "contactNumber")
    private String contactNumber;

    @ColumnInfo(name = "contactEmail")
    private String email_id;

    @Ignore //ignore annotation tells us that this constructor is secondary
    public ContactEntity(byte[] contactImage, int id, @NonNull String contactName, @NonNull String contactNumber, String email_id) {
        this.contactImage = contactImage;
        this.id = id;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.email_id = email_id;
    }

    public ContactEntity(int id, @NonNull String contactName, @NonNull String contactNumber) {
        this.id = id;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public byte[] getContactImage() {
        return contactImage;
    }

    public void setContactImage(byte[] contactImage) {
        this.contactImage = contactImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getContactName() {
        return contactName;
    }

    public void setContactName(@NonNull String contactName) {
        this.contactName = contactName;
    }

    @NonNull
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NonNull String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
