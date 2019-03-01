package com.example.admin.roomdbtutorial.handler;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.admin.roomdbtutorial.LoginActivity;
import com.example.admin.roomdbtutorial.model.UserModel;
import com.example.admin.roomdbtutorial.model.UserViewModel;

import androidx.lifecycle.ViewModelProviders;

public class LoginHandler {

    private Context context;
    private LoginInterface loginInterface;
    private UserViewModel userViewModel;
    private LoginActivity loginActivity;

    public LoginHandler(Context context, LoginInterface loginInterface) {
        this.context = context;
        this.loginInterface = loginInterface;
        loginActivity = (LoginActivity) context;
        userViewModel = ViewModelProviders.of(loginActivity).get(UserViewModel.class);
    }

    public void buttonSave(View view, UserModel userModel){

        System.out.println("first name in presenter "+userModel.getFirstName());
        userViewModel.insertUser(userModel);
        loginInterface.saveUser(userModel);

    }
    public void buttonShowUserList(View view){
        loginInterface.showUserList();
    }

    public interface LoginInterface {

        void saveUser(UserModel userModel);
        void showUserList();
    }
}