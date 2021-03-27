package com.example.lab6;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "users")
public class User {

    @NotNull
    @PrimaryKey
    String name;

    float rating;

    String comment;



    public User(String name, float rating, String comment)
    {
        this.rating = rating;
        this.name = name;
        this.comment = comment;
    }


}