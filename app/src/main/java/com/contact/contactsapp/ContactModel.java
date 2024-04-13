package com.contact.contactsapp;

public class ContactModel
{
    int image;
    String name,number,email_id;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }




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
