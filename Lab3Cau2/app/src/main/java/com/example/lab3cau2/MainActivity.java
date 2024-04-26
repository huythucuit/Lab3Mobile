package com.example.lab3cau2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> contactList;
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;

    private void addControl() {
        DatabaseHandler db = new DatabaseHandler(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        contactList = new ArrayList<>();
        contactAdapter = new ContactAdapter(this, contactList, db);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(contactAdapter);
    }

    private void addEvent() {
        /** Call method add data*/
        createData();
    }

    public void createData() {


        Contact contact = new Contact(1, "Ravi", "9100000000");
        contactList.add(contact);
        Contact contact1 = new Contact(2, "Srinivas", "9199999999");
        contactList.add(contact1);
        Contact contact2 = new Contact(3, "Tommy", "9522222222");
        contactList.add(contact2);
        Contact contact3 = new Contact(4, "Karthik", "9533333333");
        contactList.add(contact3);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        addControl();
        addEvent();
        Log.e("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + "Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.e("Name: ", log);
        }
    }
}


