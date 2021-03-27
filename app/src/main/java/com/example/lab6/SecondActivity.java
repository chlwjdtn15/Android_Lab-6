package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class SecondActivity extends AppCompatActivity {


    MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        database = MyDatabase.getInstance(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);




        new Thread(new Runnable() {
            @Override
            public void run() {
                List<User> userList =  database.userDAO().getAll();

                MyAdaptor adaptor = new MyAdaptor(userList);




                recyclerView.setLayoutManager(new LinearLayoutManager(SecondActivity.this));

                recyclerView.setAdapter(adaptor);
            }
        }).start();



    }
}