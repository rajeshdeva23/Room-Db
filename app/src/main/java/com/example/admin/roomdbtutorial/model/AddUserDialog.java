package com.example.admin.roomdbtutorial.model;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.roomdbtutorial.R;
import com.example.admin.roomdbtutorial.ViewUsersActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;

public class AddUserDialog extends DialogFragment {

    private ViewUsersActivity viewUsersActivity;
    private UserViewModel userViewModel;
    private MaterialButton button, buttonCancel;
    private TextInputEditText  tieFirstName,tieLastName,tieEmail,tiePassword,tieMobileNumber;
    private TextInputLayout tilFirstName,tilLastName, tilEmail, tilPassword, tilMobileNumber;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userViewModel = ViewModelProviders.of(viewUsersActivity).get(UserViewModel.class);
        button = view.findViewById(R.id.btnSaveData);
        buttonCancel = view.findViewById(R.id.btnCancel);
        tieFirstName = view.findViewById(R.id.tieFirstName);
        tieLastName = view.findViewById(R.id.tieLastName);
        tieEmail = view.findViewById(R.id.tieEmail);
        tiePassword = view.findViewById(R.id.tiePassword);
        tieMobileNumber = view.findViewById(R.id.tieMobileNumber);
        tilFirstName = view.findViewById(R.id.tilFirstName);
        tilLastName = view.findViewById(R.id.tilLastName);
        tilEmail = view.findViewById(R.id.tilEmail);
        tilPassword = view.findViewById(R.id.tilPassword);
        tilMobileNumber = view.findViewById(R.id.tilMobileNumber);

        button.setOnClickListener(v -> {
            saveData();

        });
        buttonCancel.setOnClickListener(v -> {
             getDialog().dismiss();
        });


    }


    private void saveData() {
        if (String.valueOf(tieFirstName).trim().isEmpty()) {
            tilFirstName.setError("Enter valid first Name");
        } else if (String.valueOf(tieLastName).trim().isEmpty()) {
            tilLastName.setError("Enter valid last Name");

        } else if (String.valueOf(tieEmail).trim().isEmpty()) {
            tilEmail.setError("Enter valid email ");

        } else if (String.valueOf(tiePassword).trim().isEmpty()) {
            tilPassword.setError("Enter valid Password");

        } else if (String.valueOf(tieMobileNumber).trim().isEmpty()) {
            tilMobileNumber.setError("Enter valid mobileNumber ");
        } else {
            UserModel userModel = new UserModel();
            userModel.setFirstName(String.valueOf(tieFirstName.getText()).trim());
            userModel.setLastName(String.valueOf(tieLastName.getText()).trim());
            userModel.setEmailId(String.valueOf(tieEmail.getText()).trim());
            userModel.setPassword(String.valueOf(tiePassword.getText()).trim());
            userModel.setMobileNumber(String.valueOf(tieMobileNumber.getText()).trim());
            userViewModel.insertUser(userModel);
            getDialog().dismiss();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (viewUsersActivity == null)
            viewUsersActivity = (ViewUsersActivity) context;
    }

    @Override
    public void onDetach() {
        if (viewUsersActivity != null)
            viewUsersActivity = null;
        super.onDetach();
    }

    @Override
    public void onStart() {
        super.onStart();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setLayout(width,height);
    }
}
