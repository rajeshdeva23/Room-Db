package com.example.admin.roomdbtutorial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.roomdbtutorial.model.UserModel;
import com.example.admin.roomdbtutorial.model.UserViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateActivity extends AppCompatActivity {

    private static String TAG = UpdateActivity.class.getSimpleName();
    private UserViewModel userViewModel;

    private UserModel userModel;


    @BindView(R.id.tieFirstName)
    TextInputEditText tieFirstName;
    @BindView(R.id.tilFirstName)
    TextInputLayout tilFirstName;
    @BindView(R.id.tieLastName)
    TextInputEditText tieLastName;
    @BindView(R.id.tilLastName)
    TextInputLayout tilLastName;
    @BindView(R.id.tieEmail)
    TextInputEditText tieEmail;
    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;
    @BindView(R.id.tiePassword)
    TextInputEditText tiePassword;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    @BindView(R.id.tieMobileNumber)
    TextInputEditText tieMobileNumber;
    @BindView(R.id.tilMobileNumber)
    TextInputLayout tilMobileNumber;
    @BindView(R.id.btnUpdateData)
    MaterialButton btnUpdateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        userModel = (UserModel) getIntent().getSerializableExtra("userDetails");
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        bindValues();
    }

    private void bindValues() {
        tieFirstName.setText(userModel.getFirstName());
        tieLastName.setText(userModel.getLastName());
        tieEmail.setText(userModel.getEmailId());
        tiePassword.setText(userModel.getPassword());
        tieMobileNumber.setText(userModel.getMobileNumber());
    }

    @OnClick(R.id.btnUpdateData)
    public void onViewClicked() {
        if (String.valueOf(tieFirstName.getText()).trim().isEmpty()) {
            tilFirstName.setError("Enter Valid First Name");

        } else if (String.valueOf(tieLastName.getText()).trim().isEmpty()) {
            tilLastName.setError("Enter Valid Last Name");

        } else if (String.valueOf(tieEmail.getText()).trim().isEmpty()) {
            tilEmail.setError("Enter Valid Email Id");

        } else if (String.valueOf(tiePassword.getText()).trim().isEmpty()) {
            tilPassword.setError("Enter Valid Password ");

        } else if (String.valueOf(tieMobileNumber.getText()).trim().isEmpty()) {
            tilMobileNumber.setError("Enter Valid Mobile Number");
        } else {
            String firstName, lastName, email, password, mobileNumber;
            firstName = String.valueOf(tieFirstName.getText()).trim();
            lastName = String.valueOf(tieLastName.getText()).trim();
            email = String.valueOf(tieEmail.getText()).trim();
            password = String.valueOf(tiePassword.getText()).trim();
            mobileNumber = String.valueOf(tieMobileNumber.getText()).trim();
            userModel.setFirstName(firstName);
            userModel.setLastName(lastName);
            userModel.setEmailId(email);
            userModel.setPassword(password);
            userModel.setMobileNumber(mobileNumber);
            userViewModel.updateUser(userModel);
        }
    }

}
