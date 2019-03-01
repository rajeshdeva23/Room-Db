package com.example.admin.roomdbtutorial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.roomdbtutorial.model.AddUserDialog;
import com.example.admin.roomdbtutorial.model.UserModel;
import com.example.admin.roomdbtutorial.model.UserViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewUsersActivity extends AppCompatActivity {

    private static String TAG = ViewUsersActivity.class.getSimpleName();
    private UserViewModel userViewModel;

    @BindView(R.id.rvUserList)
    RecyclerView rvUserList;
    @BindView(R.id.fabIcon)
    FloatingActionButton fabIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        ButterKnife.bind(this);
        rvUserList.setHasFixedSize(true);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(ViewUsersActivity.this);
        rvUserList.setAdapter(userAdapter);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUserList().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                Toast.makeText(ViewUsersActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
                System.out.println("on live data "+userModels.size());
                userAdapter.setUserList(userModels);
            }
        });

    }

    @OnClick(R.id.fabIcon)
    public void onViewClicked() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddUserDialog  addUserDialog = new AddUserDialog();
        addUserDialog.show(fragmentManager,"Add User Dialog");

    }

}
