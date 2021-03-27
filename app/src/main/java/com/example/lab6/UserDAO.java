package com.example.lab6;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {


    @Insert
    public void addUser(User u);


    @Query("Delete from users")

    public void deleteUser();


    @Query("select * from users")
    public List<User> getAll();


}
