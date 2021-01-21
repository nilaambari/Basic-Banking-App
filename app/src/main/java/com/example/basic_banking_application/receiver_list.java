package com.example.basic_banking_application;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

public class receiver_list extends AppCompatActivity {

    private ArrayList<User> userList;
    private  RecyclerView recyclerView;
    private ReceiverAdapter.recyclerviewClicklistener listenernew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_list);
        recyclerView = findViewById(R.id.receivers_recycler_view);
        userList = new ArrayList<>();

        setAdapter();
        setUserInfo();

    }

    private void setAdapter() {
        setOnclicklistener();
        ReceiverAdapter adapter = new ReceiverAdapter(userList, listenernew);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnclicklistener() {
        listenernew = new ReceiverAdapter.recyclerviewClicklistener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent= new Intent(getApplicationContext(), money_transfer.class);
                startActivity(intent);
            }
        };
    }


    private void setUserInfo() {

        userList.add(new User("Nilambari","nilambari@gmail.com","Rs.100000"));
        userList.add(new User("Arjun","arjun@gmail.com","Rs.5254564"));
        userList.add(new User("Blake","blake@gmail.com","Rs.56789"));
        userList.add(new User("Neha","neha@gmail.com","Rs.99999"));
        userList.add(new User("Warren","warren@gmail.com","Rs.234567"));
        userList.add(new User("Mark","mark@gmail.com","Rs.754564"));
        userList.add(new User("Christine","christine@gmail.com","Rs.334567"));
        userList.add(new User("Joseph","joseph@gmail.com","Rs.54564"));
        userList.add(new User("Priya","Priya@gmail.com","Rs.984564"));
        userList.add(new User("Lily","lily@gmail.com","Rs.88564"));
    }

}