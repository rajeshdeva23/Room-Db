package com.example.admin.roomdbtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.roomdbtutorial.handler.LoginHandler;
import com.example.admin.roomdbtutorial.databinding.ActivityLoginBinding;
import com.example.admin.roomdbtutorial.model.UserModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


public class LoginActivity extends AppCompatActivity implements LoginHandler.LoginInterface {

    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        UserModel userModel = new UserModel();
        LoginHandler loginHandler = new LoginHandler(this, this);
        activityLoginBinding.setUser(userModel);
        activityLoginBinding.setOnClick(loginHandler);
    }

    @Override
    public void saveUser(UserModel userModel) {
        Toast.makeText(LoginActivity.this, "buttonclicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserList() {
        startActivity(new Intent(LoginActivity.this, ViewUsersActivity.class));
    }
}