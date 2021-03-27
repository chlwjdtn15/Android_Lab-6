package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyDatabase database;
    EditText usernameET;
    EditText commentIdET;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = MyDatabase.getInstance(this);
        usernameET = findViewById(R.id.name_ET);
        commentIdET = findViewById(R.id.comment_ET);
        ratingBar = findViewById(R.id.ratingBar);



    }

    public void addUser(View view) {




                String name = usernameET.getText().toString();
                float rating = ratingBar.getRating();
                String comment = commentIdET.getText().toString();

                User user = new User(name, rating, comment);


                database.userDAO().addUser(user);


                 Toast.makeText(MainActivity.this, "Your Comment is saved", Toast.LENGTH_SHORT).show();


    }

    public void displayUsers(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);


    }


    public void deleteData(View view) {

        database.userDAO().deleteUser();

        Toast.makeText(MainActivity.this, "Comments are deleted", Toast.LENGTH_SHORT).show();




    }
}
