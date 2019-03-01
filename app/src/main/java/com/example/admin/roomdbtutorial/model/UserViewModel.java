package com.example.admin.roomdbtutorial.model;

import android.app.Application;

import com.example.admin.roomdbtutorial.UserRepositary;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UserViewModel extends AndroidViewModel {

    private UserRepositary userRepositary;
    private LiveData<List<UserModel>> userListLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepositary = new UserRepositary(application);
        userListLiveData = userRepositary.getUserModels();
    }

    public void insertUser(UserModel userModel) {
        userRepositary.insert(userModel);
    }

    public void updateUser(UserModel userModel) {
        userRepositary.update(userModel);
    }

    public void deleteUser(UserModel userModel) {
        userRepositary.delete(userModel);
    }

    public LiveData<List<UserModel>> getUserList(){
        return userListLiveData;
    }
}