package com.contact.contactsapp;

public class ContactModel
{
    int image;
    String name,number,email_id;




    public ContactModel(int image,String name, String number,String email_id)
    {
        this.name=name;
        this.number = number;
        this.image = image;
        this.email_id = email_id;
    }
    public ContactModel(String name,String number)
    {
        this.name = name;
        this.number = number;
    }
}
