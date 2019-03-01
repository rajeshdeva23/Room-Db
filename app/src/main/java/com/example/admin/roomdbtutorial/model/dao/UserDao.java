package com.example.admin.roomdbtutorial.model.dao;

import com.example.admin.roomdbtutorial.model.UserModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM usermodel")
    LiveData<List<UserModel>> getAllUser();

    @Insert
    void insertUser(UserModel userModel);

    @Delete
    void deleteUser(UserModel userModel);

    @Update
    void updateUser(UserModel userModel);
}