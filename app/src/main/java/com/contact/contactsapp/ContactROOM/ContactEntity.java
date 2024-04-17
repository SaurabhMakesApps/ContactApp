package com.contact.contactsapp.ContactROOM;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName="contacts")
public class ContactEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] imageData;

    @ColumnInfo(name = "contactName")
    private String contactName;

    @ColumnInfo(name = "contactNumber")
    private String contactNumber;

    @Ignore
    public ContactEntity(int id) {
        this.id = id;
    }

    public ContactEntity(byte[] imageData, String contactName, String contactNumber) {
        this.imageData = imageData;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.id = 0;
    }
@Ignore
    public ContactEntity(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(@NonNull String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NonNull String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Method to retrieve image byte array
    public byte[] getImageBytes() {
        return imageData;
    }
}
