package com.contact.contactsapp.ContactROOM;

import android.content.Context;


import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ContactEntity.class,exportSchema = false,version = 178)
public abstract class ContactDatabaseHelper extends RoomDatabase {

    private static final String DB_NAME = "contactDB";
    private static ContactDatabaseHelper instance;

    public static synchronized ContactDatabaseHelper getDb(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context,ContactDatabaseHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()//not planning on updating database schema anytime soon
                    .build();
        }

        return instance;
    }

    public abstract ContactDAO contactDB();//not sure what it does,just copied it.Want to explain it, be my guest


}

//Explanation

//1.public void ContactDatabaseHelper extends ROOM database
//as the name suggests, it is extending the ROOM database class which gives us various methods to implement the DB

//2.@Database(entities=contactEntity,exportSchema = "false" version="1")
//this annotation tells the database the number of tables(entities)
//exportSchema means whether you want to generate its schema file i.e the schema of the database
//version--as you update,you increase number

//ContactDatabaseHelper instance; --basically the object (which will be the database)

//instance==null -whether database has been created or not

// instance = Room.databaseBuilder(context,ContactDatabaseHelper.class,DB_NAME)
//                                .fallbackToDestructiveMigration()--when updating to another version,previous database will be dropped (existing data will be lost)
//
